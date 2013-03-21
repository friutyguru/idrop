package org.irods.mydrop.controller

import org.irods.jargon.core.connection.IRODSAccount
import org.irods.jargon.core.pub.IRODSAccessObjectFactory
import org.irods.jargon.hive.service.VocabularyService
import org.irods.mydrop.service.HiveService


class HiveController {

	IRODSAccessObjectFactory irodsAccessObjectFactory
	IRODSAccount irodsAccount
	VocabularyService vocabularyService
	HiveService hiveService

	/**
	 * Interceptor grabs IRODSAccount from the SecurityContextHolder
	 */
	def beforeInterceptor = [action:this.&auth]

	def auth() {

		if(!session["SPRING_SECURITY_CONTEXT"]) {
			redirect(controller:"login", action:"login")
			return false
		}
		irodsAccount = session["SPRING_SECURITY_CONTEXT"]
	}


	def afterInterceptor = {
		log.debug("closing the session")
		irodsAccessObjectFactory.closeSession()
	}

	/**
	 * Update with the selected vocabularies
	 * @return
	 */
	def selectVocabularies() {
		log.info("selectVocabularies")
		log.info(params)
		def selected = params['selectedVocab']
		// TODO: list versus object

		if (selected instanceof Object[]) {
			// ok
		} else {
			selected = [selected]
		}


		hiveService.selectVocabularies(selected)

		forward(action:"index")


	}


	/**
	 * Sbow initial HIVE view, which should reflect the selected set of vocabularies, and show a list of all vocabularies 
	 * @return
	 */
	def index() {
		log.info("index")

		def vocabularies = hiveService.retrieveVocabularySelectionListing()
		def hiveState = hiveService.retrieveHiveState()
		if (hiveState.vocabularies.size() == 0) {
			log.info("no HIVE vocabularies configured")
			//TODO: create this view
			render(view:"noVocabularies")
			return
		}

		if (hiveService.areVocabulariesSelected()==false) {
			render(view:"vocabSelectionList", model:[vocabs:vocabularies])
		} else {
			forward(action:"conceptBrowser", model:[hiveState:hiveState,vocabs:vocabularies])
		}
	}
	
	/**
	 * Set the concept browser to display the top level of the given vocabulary
	 * @return
	 */
	def resetConceptBrowser() {
		log.info("resetConceptBrowser")
		log.info(params)
		
		def vocabulary = params['vocabulary']
		def hiveState = hiveService.retrieveHiveState()
		
		if (!vocabulary) {
			vocabulary = hiveState.currentVocabulary
		}
		
		if (!vocabulary) {
			log.error("no vocabulary is selected or possible to select")
				response.sendError(500, message(code:"error.no.vocabulary.selected" ))
				return
		}
		
		hiveService.getTopLevelConceptProxyForVocabulary(vocabulary)
		forward(action:"conceptBrowser")
	
		
	}
	
	/**
	 * Show the concept browser given the selected vocabularies
	 * @return
	 */
	def conceptBrowser() {
		log.info("conceptBrowser")
		log.info(params)

		def indexLetter = params['indexLetter']
		def targetUri = params['targetURI']
		/*def vocabularies = params['vocabularies']
		 */

		if (!indexLetter) {
			indexLetter = 'A'
		}

		if (!targetUri) {
			targetUri = ""
		}

		def hiveState = hiveService.retrieveHiveState()
		def conceptProxy
		
		log.info("getting concept proxy for display...")
		
		if (targetUri) {
			log.info("have target uri, make this the current:${targetUri}")
			conceptProxy = hiveService.getConceptByUri(targetUri)
		} else if (hiveState.currentConceptURI) {
			log.info("have a current uri, redisplay this information:${hiveState.currentConceptURI}")
			conceptProxy = hiveService.getConceptByUri(hiveState.currentConceptURI)
		} else {
			// no current or desired uri, select the top level of the current vocabulary
			def currentVocab = hiveService.getCurrentVocabularySelection()
			if(!currentVocab) {
				log.error("no vocabulary is selected or possible to select")
				response.sendError(500, message(code:"error.no.vocabulary.selected" ))
				return
			}
			log.info("getting top level for:${currentVocab}")
			conceptProxy = hiveService.getTopLevelConceptProxyForVocabulary(currentVocab)
			
		}

		render(view:"conceptBrowser", model:[hiveState:hiveState,vocabularySelections:hiveService.retrieveVocabularySelectionListing(), conceptProxy:conceptProxy])
	}

	def searchConcept(){
		log.info("searchConcept")
		log.info(params.searchedConcept)
		
		def searchResult
		def hiveState = hiveService.retrieveHiveState()
		def listOfOpenedVocabularies = hiveState.selectedVocabularies
		def searchedConcept = params['searchedConcept'] //I have to name the concept which is being searched as param searchedConcept
		if (!searchedConcept) {
			log.info("nothing to search for!")
		}
		else {
			searchResult = hiveService.searchConcept(searchedConcept , listOfOpenedVocabularies) 
			if (!searchConcept){
				log.info("nothing was found for the searched term")
			}
			render (view:"conceptSearch", model:[searchResult:searchResult])
		}	
			
	}
	
}

