<div id="browseTabContent"  class="clearfix" style="display:block;width:100%;height:98%;">
<div id="browseToolbar" style="display:block;">
				
	<div id="infoDivPathArea"
		style="overflow: hidden; display:block; margin: 3px; font-size: 120%;">
		<!-- area for the path crumb-trails -->
	</div>
	<g:render template="/common/topToolbar" />
</div> <!--  browseToolbar -->
		
<div id="browser" class="wrapper clearfix" style="height:85%;">
<div id="dataTreeView"
				style="width: 100%; height: 700px; overflow: hidden;">
				
	<div id="dataTreeDivWrapper"  class="ui-layout-west" style="width: 25%; height: 100%; position:relative;">
		<div id="dataTreeToolbar" style="width:100%; height:3%;display:block;" class="fg-toolbar">
				
				<div id="dataTreeMenu" class="fg-buttonset fg-buttonset-multi"
					style="float: left, clear : both; display:block; overflow:hidden;">
					<button type="button" id="refreshTreeButton"
						class="ui-state-default ui-corner-left" value="refreshTreeButton"
						onclick="refreshTree()")>
						<g:img dir="images" file="arrow-refresh.png" width="16" height="16"/>
					</button>
					<button type="button" id="homeTreeButton"
						class="ui-state-default" value="homeTreeButton"
						onclick="setTreeToUserHome()")>
						<g:img dir="images" file="go-home-4.png" width="16" height="16"/>
					</button>
						<button type="button" id="rootTreeButton"
						class="ui-state-default ui-corner-right" value="rootTreeButton"
						onclick="setTreeToRoot()")>
						<g:img dir="images" file="go-parent-folder.png" width="16" height="16"/>
					</button>
				</div> <!--  dataTreeMenu -->
				
		</div> <!--  dataTreeToolbar -->
				
		<div id="dataTreeDiv" class="clearfix" style="height:95%; width:100%; overflow:auto;"></div>	
	</div> <!-- dataTreeDivWrapper -->
					
	<div id="infoDivOuter" style="display: block; width: 75%; height: 100%; position: relative; overflow: auto;"
					class="ui-layout-center">

		<div id="infoDiv" style=""><h2><g:message code="browse.page.prompt" /></h2>
		</div> <!--  infoDiv -->
	
	</div> <!--  infoDivOuter -->
	</div>
</div> <!--  browser -->

</div>