/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.Color;

import javax.swing.ToolTipManager;
import javax.swing.tree.TreeSelectionModel;

import org.irods.jargon.core.utils.MiscIRODSUtils;
import org.irods.jargon.datautils.tree.FileTreeDiffEntry;
import org.irods.jargon.datautils.tree.FileTreeDiffEntry.DiffType;
import org.irods.jargon.datautils.tree.FileTreeModel;
import org.irods.jargon.datautils.tree.FileTreeNode;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.DiffTreeCustomRenderer;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.DiffViewData;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Mike
 */
public class DiffViewDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 66014425290634547L;
	private DiffViewData diffViewData;
	public static org.slf4j.Logger log = LoggerFactory
			.getLogger(ToolsDialog.class);
	private final FileTreeModel fileTreeModel;

	public DiffViewDialog(final iDrop parent, final boolean modal,
			final DiffViewData diffViewData) {
		super(parent, modal);
		initComponents();
		pnlSelectionInfo.setVisible(false);
		btnResolve.setVisible(false);
		btnResolveGet.setVisible(false);
		btnResolvePut.setVisible(false);
		this.diffViewData = diffViewData;
		fileTreeModel = diffViewData.getFileTreeModel();
		treeDiff.setModel(fileTreeModel);
		initializeDiffView();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		pnlTop = new javax.swing.JPanel();
		lblDiffResult = new javax.swing.JLabel();
		lblLocalAbsPathLabel = new javax.swing.JLabel();
		lblLocalAbsPath = new javax.swing.JLabel();
		lblIrodsPathLabel = new javax.swing.JLabel();
		lblIrodsPath = new javax.swing.JLabel();
		pnlCenter = new javax.swing.JPanel();
		scrollPaneDiff = new javax.swing.JScrollPane();
		treeDiff = new javax.swing.JTree();
		pnlSelectionInfo = new javax.swing.JPanel();
		lblSelectedPathLabel = new javax.swing.JLabel();
		lblLocalSelectedPath = new javax.swing.JLabel();
		lblDescriptionOfDiffInfo = new javax.swing.JLabel();
		btnResolve = new javax.swing.JButton();
		lblSuggestedResolution = new javax.swing.JLabel();
		lblIrodsSelectedPathLabel = new javax.swing.JLabel();
		lblIrodsSelectedPath = new javax.swing.JLabel();
		lblTypeLabel = new javax.swing.JLabel();
		lblType = new javax.swing.JLabel();
		pnlFileDiffDetails = new javax.swing.JPanel();
		btnResolveGet = new javax.swing.JButton();
		btnResolvePut = new javax.swing.JButton();
		lblLocalFileLengthLbl = new javax.swing.JLabel();
		lblLocalFileLength = new javax.swing.JLabel();
		lblIrodsFileLengthLbl = new javax.swing.JLabel();
		lblIrodsFileLength = new javax.swing.JLabel();
		lblLocalFileChecksumLbl = new javax.swing.JLabel();
		lblLocalFileChecksum = new javax.swing.JLabel();
		lblIrodsFileChecksumLbl = new javax.swing.JLabel();
		lblIrodsFileChecksum = new javax.swing.JLabel();
		pnlBottom = new javax.swing.JPanel();
		pnlUploadDownloadButtons = new javax.swing.JPanel();
		btnOK = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(org.openide.util.NbBundle.getMessage(DiffViewDialog.class,
				"DiffViewDialog.title")); // NOI18N
		setModal(true);
		setName("DiffViewDialog"); // NOI18N
		setPreferredSize(new java.awt.Dimension(800, 600));

		pnlTop.setLayout(new java.awt.GridBagLayout());

		lblDiffResult.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.lblDiffResult.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.ipady = 5;
		pnlTop.add(lblDiffResult, gridBagConstraints);

		lblLocalAbsPathLabel.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblLocalAbsPathLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipady = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlTop.add(lblLocalAbsPathLabel, gridBagConstraints);

		lblLocalAbsPath.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.lblLocalAbsPath.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlTop.add(lblLocalAbsPath, gridBagConstraints);

		lblIrodsPathLabel.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.lblIrodsPathLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipady = 5;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlTop.add(lblIrodsPathLabel, gridBagConstraints);

		lblIrodsPath.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.lblIrodsPath.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlTop.add(lblIrodsPath, gridBagConstraints);

		getContentPane().add(pnlTop, java.awt.BorderLayout.NORTH);

		pnlCenter.setLayout(new java.awt.BorderLayout());

		treeDiff.setModel(getFileTreeModel());
		treeDiff.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
			@Override
			public void valueChanged(
					final javax.swing.event.TreeSelectionEvent evt) {
				treeDiffValueChanged(evt);
			}
		});
		scrollPaneDiff.setViewportView(treeDiff);

		pnlCenter.add(scrollPaneDiff, java.awt.BorderLayout.CENTER);

		pnlSelectionInfo.setLayout(new java.awt.GridBagLayout());

		lblSelectedPathLabel.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblSelectedPathLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
		pnlSelectionInfo.add(lblSelectedPathLabel, gridBagConstraints);

		lblLocalSelectedPath.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblLocalSelectedPath.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlSelectionInfo.add(lblLocalSelectedPath, gridBagConstraints);

		lblDescriptionOfDiffInfo.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblDescriptionOfDiffInfo.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
		pnlSelectionInfo.add(lblDescriptionOfDiffInfo, gridBagConstraints);

		btnResolve.setMnemonic('r');
		btnResolve.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.btnResolve.text")); // NOI18N
		btnResolve.setToolTipText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.btnResolve.toolTipText")); // NOI18N
		btnResolve.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnResolveActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
		pnlSelectionInfo.add(btnResolve, gridBagConstraints);

		lblSuggestedResolution.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblSuggestedResolution.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 7;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
		pnlSelectionInfo.add(lblSuggestedResolution, gridBagConstraints);

		lblIrodsSelectedPathLabel.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblIrodsSelectedPathLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
		pnlSelectionInfo.add(lblIrodsSelectedPathLabel, gridBagConstraints);

		lblIrodsSelectedPath.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblIrodsSelectedPath.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlSelectionInfo.add(lblIrodsSelectedPath, gridBagConstraints);

		lblTypeLabel.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.lblTypeLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlSelectionInfo.add(lblTypeLabel, gridBagConstraints);

		lblType.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.lblType.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlSelectionInfo.add(lblType, gridBagConstraints);

		pnlFileDiffDetails.setLayout(new java.awt.GridBagLayout());

		btnResolveGet.setMnemonic('g');
		btnResolveGet.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.btnResolveGet.text")); // NOI18N
		btnResolveGet.setToolTipText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.btnResolveGet.toolTipText")); // NOI18N
		btnResolveGet.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnResolveGetActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
		pnlFileDiffDetails.add(btnResolveGet, gridBagConstraints);

		btnResolvePut.setMnemonic('p');
		btnResolvePut.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.btnResolvePut.text")); // NOI18N
		btnResolvePut.setToolTipText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.btnResolvePut.toolTipText")); // NOI18N
		btnResolvePut.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnResolvePutActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
		pnlFileDiffDetails.add(btnResolvePut, gridBagConstraints);

		lblLocalFileLengthLbl.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblLocalFileLengthLbl.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		gridBagConstraints.insets = new java.awt.Insets(3, 0, 3, 0);
		pnlFileDiffDetails.add(lblLocalFileLengthLbl, gridBagConstraints);

		lblLocalFileLength
				.setText(org.openide.util.NbBundle.getMessage(
						DiffViewDialog.class,
						"DiffViewDialog.lblLocalFileLength.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlFileDiffDetails.add(lblLocalFileLength, gridBagConstraints);

		lblIrodsFileLengthLbl.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblIrodsFileLengthLbl.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlFileDiffDetails.add(lblIrodsFileLengthLbl, gridBagConstraints);

		lblIrodsFileLength
				.setText(org.openide.util.NbBundle.getMessage(
						DiffViewDialog.class,
						"DiffViewDialog.lblIrodsFileLength.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlFileDiffDetails.add(lblIrodsFileLength, gridBagConstraints);

		lblLocalFileChecksumLbl.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblLocalFileChecksumLbl.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlFileDiffDetails.add(lblLocalFileChecksumLbl, gridBagConstraints);

		lblLocalFileChecksum.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblLocalFileChecksum.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlFileDiffDetails.add(lblLocalFileChecksum, gridBagConstraints);

		lblIrodsFileChecksumLbl.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblIrodsFileChecksumLbl.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlFileDiffDetails.add(lblIrodsFileChecksumLbl, gridBagConstraints);

		lblIrodsFileChecksum.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class,
				"DiffViewDialog.lblIrodsFileChecksum.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlFileDiffDetails.add(lblIrodsFileChecksum, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 6;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
		pnlSelectionInfo.add(pnlFileDiffDetails, gridBagConstraints);

		pnlCenter.add(pnlSelectionInfo, java.awt.BorderLayout.SOUTH);

		getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

		pnlBottom.setLayout(new java.awt.GridLayout(1, 0));

		pnlUploadDownloadButtons.setLayout(new java.awt.FlowLayout(
				java.awt.FlowLayout.RIGHT));

		btnOK.setMnemonic('o');
		btnOK.setText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.btnOK.text")); // NOI18N
		btnOK.setToolTipText(org.openide.util.NbBundle.getMessage(
				DiffViewDialog.class, "DiffViewDialog.btnOK.toolTipText")); // NOI18N
		btnOK.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnOKActionPerformed(evt);
			}
		});
		pnlUploadDownloadButtons.add(btnOK);

		pnlBottom.add(pnlUploadDownloadButtons);

		getContentPane().add(pnlBottom, java.awt.BorderLayout.SOUTH);

		getAccessibleContext()
				.setAccessibleDescription(
						org.openide.util.NbBundle
								.getMessage(DiffViewDialog.class,
										"DiffViewDialog.AccessibleContext.accessibleDescription")); // NOI18N

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnOKActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKActionPerformed
		dispose();
	}// GEN-LAST:event_btnOKActionPerformed

	private void treeDiffValueChanged(
			final javax.swing.event.TreeSelectionEvent evt) {// GEN-FIRST:event_treeDiffValueChanged

		log.info("value changed:{}", evt);
		FileTreeNode node = (FileTreeNode) treeDiff
				.getLastSelectedPathComponent();
		log.info("selected node:{}", node);

		if (node == null) // Nothing is selected.
		{
			return;
		}

		setDiffTypeDescriptionBasedOnNode((FileTreeDiffEntry) node
				.getUserObject());

	}// GEN-LAST:event_treeDiffValueChanged

	private void btnResolveGetActionPerformed(
			final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResolveGetActionPerformed

		log.info("btnResolveGetActionPerformed()");
		FileTreeNode node = (FileTreeNode) treeDiff
				.getLastSelectedPathComponent();
		log.info("selected node:{}", node);
		FileTreeDiffEntry entry = (FileTreeDiffEntry) node.getUserObject();

		log.info("entry:{}", entry);

		MiscIRODSUtils.separateCollectionAndPathFromGivenAbsolutePath(entry
				.getAbsPathOppositeFile());
	}// GEN-LAST:event_btnResolveGetActionPerformed

	private void btnResolvePutActionPerformed(
			final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResolvePutActionPerformed

		log.info("btnResolvePutActionPerformed()");
		FileTreeNode node = (FileTreeNode) treeDiff
				.getLastSelectedPathComponent();
		log.info("selected node:{}", node);
		FileTreeDiffEntry entry = (FileTreeDiffEntry) node.getUserObject();

		log.info("entry:{}", entry);

		MiscIRODSUtils.separateCollectionAndPathFromGivenAbsolutePath(entry
				.getAbsPathOppositeFile());
	}// GEN-LAST:event_btnResolvePutActionPerformed

	private void btnResolveActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnResolveActionPerformed

		log.info("btnResolveActionPerformed()");
		FileTreeNode node = (FileTreeNode) treeDiff
				.getLastSelectedPathComponent();
		log.info("selected node:{}", node);
		FileTreeDiffEntry entry = (FileTreeDiffEntry) node.getUserObject();

		log.info("entry:{}", entry);
		/*
		 * FIXME: conveyor if (entry.getDiffType() == DiffType.LEFT_HAND_PLUS) {
		 * log.info("schedule a put");
		 * 
		 * // the diff shows the full computed path, you want to use the parent
		 * name for the target so that /x/y doesnt get put to x/y/y
		 * CollectionAndPath collectionAndPath =
		 * MiscIRODSUtils.separateCollectionAndPathFromGivenAbsolutePath
		 * (entry.getAbsPathOppositeFile());
		 * 
		 * 
		 * try { idropGui.getiDropCore() .getTransferManager() .enqueueAPut(
		 * entry
		 * .getCollectionAndDataObjectListingEntry().getFormattedAbsolutePath(),
		 * collectionAndPath.getCollectionParent(),
		 * idropGui.getIrodsAccount().getDefaultStorageResource(),
		 * idropGui.getIrodsAccount()); entry.setResolved(true);
		 * setDiffTypeDescriptionBasedOnNode(entry); } catch (JargonException
		 * ex) { log.error("error enquing put", ex); MessageUtil .showWarning(
		 * this, ex.getMessage(), ""); }
		 * 
		 * } else if (entry.getDiffType() == DiffType.RIGHT_HAND_PLUS) {
		 * log.info("schedule a get");
		 * 
		 * // the diff shows the full computed path, you want to use the parent
		 * name for the target so that /x/y doesnt get put to x/y/y
		 * CollectionAndPath collectionAndPath =
		 * MiscIRODSUtils.separateCollectionAndPathFromGivenAbsolutePath
		 * (entry.getAbsPathOppositeFile());
		 * 
		 * try { idropGui.getiDropCore() .getTransferManager() .enqueueAGet(
		 * entry
		 * .getCollectionAndDataObjectListingEntry().getFormattedAbsolutePath(),
		 * collectionAndPath.getCollectionParent(),
		 * idropGui.getIrodsAccount().getDefaultStorageResource(),
		 * idropGui.getIrodsAccount()); entry.setResolved(true);
		 * setDiffTypeDescriptionBasedOnNode(entry);
		 * 
		 * } catch (JargonException ex) { log.error("error enquing get", ex);
		 * MessageUtil .showWarning( this, ex.getMessage(), ""); } }
		 */

	}// GEN-LAST:event_btnResolveActionPerformed
		// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JButton btnOK;
	private javax.swing.JButton btnResolve;
	private javax.swing.JButton btnResolveGet;
	private javax.swing.JButton btnResolvePut;
	private javax.swing.JLabel lblDescriptionOfDiffInfo;
	private javax.swing.JLabel lblDiffResult;
	private javax.swing.JLabel lblIrodsFileChecksum;
	private javax.swing.JLabel lblIrodsFileChecksumLbl;
	private javax.swing.JLabel lblIrodsFileLength;
	private javax.swing.JLabel lblIrodsFileLengthLbl;
	private javax.swing.JLabel lblIrodsPath;
	private javax.swing.JLabel lblIrodsPathLabel;
	private javax.swing.JLabel lblIrodsSelectedPath;
	private javax.swing.JLabel lblIrodsSelectedPathLabel;
	private javax.swing.JLabel lblLocalAbsPath;
	private javax.swing.JLabel lblLocalAbsPathLabel;
	private javax.swing.JLabel lblLocalFileChecksum;
	private javax.swing.JLabel lblLocalFileChecksumLbl;
	private javax.swing.JLabel lblLocalFileLength;
	private javax.swing.JLabel lblLocalFileLengthLbl;
	private javax.swing.JLabel lblLocalSelectedPath;
	private javax.swing.JLabel lblSelectedPathLabel;
	private javax.swing.JLabel lblSuggestedResolution;
	private javax.swing.JLabel lblType;
	private javax.swing.JLabel lblTypeLabel;
	private javax.swing.JPanel pnlBottom;
	private javax.swing.JPanel pnlCenter;
	private javax.swing.JPanel pnlFileDiffDetails;
	private javax.swing.JPanel pnlSelectionInfo;
	private javax.swing.JPanel pnlTop;
	private javax.swing.JPanel pnlUploadDownloadButtons;
	private javax.swing.JScrollPane scrollPaneDiff;
	private javax.swing.JTree treeDiff;

	// End of variables declaration//GEN-END:variables

	/**
	 * Initialize the components for the diff view
	 */
	private void initializeDiffView() {
		lblIrodsPath.setText(MiscIRODSUtils.abbreviateFileName(diffViewData
				.getIrodsAbsolutePath()));
		lblIrodsPath.setToolTipText(diffViewData.getIrodsAbsolutePath());
		lblLocalAbsPath.setText(MiscIRODSUtils.abbreviateFileName(diffViewData
				.getLocalAbsolutePath()));
		lblLocalAbsPath.setToolTipText(diffViewData.getIrodsAbsolutePath());
		DiffTreeCustomRenderer renderer = new DiffTreeCustomRenderer();
		treeDiff.setCellRenderer(renderer);
		ToolTipManager.sharedInstance().registerComponent(treeDiff);
		treeDiff.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
	}

	public DiffViewData getDiffViewData() {
		return diffViewData;
	}

	public void setDiffViewData(final DiffViewData diffViewData) {
		this.diffViewData = diffViewData;
	}

	public FileTreeModel getFileTreeModel() {
		return fileTreeModel;
	}

	private void setDiffTypeDescriptionBasedOnNode(
			final FileTreeDiffEntry diffEntry) {
		if (diffEntry == null) {
			return;
		}

		final DiffViewDialog thisGui = this;

		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				thisGui.pnlSelectionInfo.setVisible(true);
				lblType.setText(diffEntry
						.getCollectionAndDataObjectListingEntry()
						.getObjectType().name());
				StringBuilder sb = new StringBuilder();

				if (diffEntry.isCountAsDiff() && diffEntry.isResolved()) {
					lblDescriptionOfDiffInfo.setForeground(Color.BLUE);
					sb.append("Diffs were resolved by user action");

					btnResolve.setVisible(false);
					btnResolveGet.setVisible(false);
					btnResolvePut.setVisible(false);
					lblSuggestedResolution.setText("");
					lblDescriptionOfDiffInfo.setText(sb.toString());
					lblLocalSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getCollectionAndDataObjectListingEntry()
									.getFormattedAbsolutePath()));
					lblIrodsSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getAbsPathOppositeFile()));
					lblLocalSelectedPath.setToolTipText(diffEntry
							.getCollectionAndDataObjectListingEntry()
							.getFormattedAbsolutePath());
					lblIrodsSelectedPath.setToolTipText(diffEntry
							.getAbsPathOppositeFile());
					pnlFileDiffDetails.setVisible(false);
				} else if (diffEntry.getDiffType() == DiffType.DIRECTORY_NO_DIFF) {
					lblDescriptionOfDiffInfo.setForeground(Color.BLUE);
					sb.append("No diffs detected at this directory");
					if (diffEntry.getCountOfDiffsInChildren() > 0) {
						sb.append("...there are ");
						sb.append(diffEntry.getCountOfDiffsInChildren());
						sb.append(" diffs detected in children of this directory");
					}

					btnResolve.setVisible(false);
					btnResolveGet.setVisible(false);
					btnResolvePut.setVisible(false);
					lblSuggestedResolution.setText("");
					lblDescriptionOfDiffInfo.setText(sb.toString());
					lblLocalSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getCollectionAndDataObjectListingEntry()
									.getFormattedAbsolutePath()));
					lblIrodsSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getAbsPathOppositeFile()));
					lblLocalSelectedPath.setToolTipText(diffEntry
							.getCollectionAndDataObjectListingEntry()
							.getFormattedAbsolutePath());
					lblIrodsSelectedPath.setToolTipText(diffEntry
							.getAbsPathOppositeFile());
					pnlFileDiffDetails.setVisible(false);

				} else if (diffEntry.getDiffType() == DiffType.FILE_NAME_DIR_NAME_COLLISION) {
					lblDescriptionOfDiffInfo.setForeground(Color.RED);
					lblDescriptionOfDiffInfo
							.setText("A data object name collided with a collection name");
					lblSuggestedResolution
							.setText("This diff must be manually managed using the iDrop GUI");
					btnResolve.setVisible(false);
					btnResolveGet.setVisible(false);
					btnResolvePut.setVisible(false);
					lblLocalSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getCollectionAndDataObjectListingEntry()
									.getFormattedAbsolutePath()));
					lblIrodsSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getAbsPathOppositeFile()));
					lblLocalSelectedPath.setToolTipText(diffEntry
							.getCollectionAndDataObjectListingEntry()
							.getFormattedAbsolutePath());
					lblIrodsSelectedPath.setToolTipText(diffEntry
							.getAbsPathOppositeFile());
					pnlFileDiffDetails.setVisible(false);

				} else if (diffEntry.getDiffType() == DiffType.FILE_OUT_OF_SYNCH) {
					lblDescriptionOfDiffInfo.setForeground(Color.RED);
					lblDescriptionOfDiffInfo.setText("A file is out of synch");
					lblSuggestedResolution
							.setText("This file may be either uploaded or downloaded, overwriting the existing data");
					btnResolve.setVisible(false);
					btnResolveGet.setVisible(true);
					btnResolvePut.setVisible(true);
					pnlFileDiffDetails.setVisible(true);
					lblIrodsFileLength.setText(String.valueOf(diffEntry
							.getLengthOppositeFile()));
					lblLocalFileLength.setText(String.valueOf(diffEntry
							.getCollectionAndDataObjectListingEntry()
							.getDataSize()));
					lblLocalSelectedPath.setToolTipText(diffEntry
							.getCollectionAndDataObjectListingEntry()
							.getFormattedAbsolutePath());
					lblIrodsSelectedPath.setToolTipText(diffEntry
							.getAbsPathOppositeFile());
					lblLocalSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getCollectionAndDataObjectListingEntry()
									.getFormattedAbsolutePath()));
					lblIrodsSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getAbsPathOppositeFile()));

					if (diffEntry.getChecksumOppositeFile().isEmpty()) {
						lblIrodsFileChecksum.setVisible(false);
						lblIrodsFileChecksumLbl.setVisible(false);
						lblLocalFileChecksum.setVisible(false);
						lblLocalFileChecksumLbl.setVisible(false);
					} else {
						lblIrodsFileChecksum.setVisible(true);
						lblIrodsFileChecksumLbl.setVisible(true);
						lblLocalFileChecksum.setVisible(true);
						lblLocalFileChecksumLbl.setVisible(true);
						lblIrodsFileChecksum.setText(diffEntry
								.getChecksumOppositeFile());
						lblLocalFileChecksum.setText(String.valueOf(diffEntry
								.getChecksumThisFile()));
					}

				} else if (diffEntry.getDiffType() == DiffType.LEFT_HAND_PLUS) {
					lblDescriptionOfDiffInfo.setForeground(Color.RED);
					lblDescriptionOfDiffInfo
							.setText("The local file or collection does not exist in iRODS");
					lblSuggestedResolution
							.setText("Selecting the file or collection will upload to iRODS");
					btnResolve.setVisible(true);
					btnResolveGet.setVisible(false);
					btnResolvePut.setVisible(false);
					lblLocalSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getCollectionAndDataObjectListingEntry()
									.getFormattedAbsolutePath()));
					lblIrodsSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getAbsPathOppositeFile()));
					lblLocalSelectedPath.setToolTipText(diffEntry
							.getCollectionAndDataObjectListingEntry()
							.getFormattedAbsolutePath());
					lblIrodsSelectedPath.setToolTipText(diffEntry
							.getAbsPathOppositeFile());
					pnlFileDiffDetails.setVisible(false);

				} else if (diffEntry.getDiffType() == DiffType.RIGHT_HAND_PLUS) {
					lblDescriptionOfDiffInfo.setForeground(Color.RED);
					lblDescriptionOfDiffInfo
							.setText("The iRODS file or collection does not exist in the local directory");
					lblSuggestedResolution
							.setText("Selecting the file or collection will download from iRODS");
					btnResolve.setVisible(true);
					btnResolveGet.setVisible(false);
					btnResolvePut.setVisible(false);
					lblLocalSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getCollectionAndDataObjectListingEntry()
									.getFormattedAbsolutePath()));
					lblIrodsSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getAbsPathOppositeFile()));
					lblLocalSelectedPath.setToolTipText(diffEntry
							.getCollectionAndDataObjectListingEntry()
							.getFormattedAbsolutePath());
					lblIrodsSelectedPath.setToolTipText(diffEntry
							.getAbsPathOppositeFile());
					pnlFileDiffDetails.setVisible(false);

				} else {
					lblDescriptionOfDiffInfo.setForeground(Color.RED);
					lblDescriptionOfDiffInfo.setText(diffEntry.getDiffType()
							.toString());
					lblSuggestedResolution
							.setText("Diff must be manually resolved");
					btnResolve.setVisible(false);
					btnResolveGet.setVisible(false);
					btnResolvePut.setVisible(false);
					lblLocalSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getCollectionAndDataObjectListingEntry()
									.getFormattedAbsolutePath()));
					lblIrodsSelectedPath.setText(MiscIRODSUtils
							.abbreviateFileName(diffEntry
									.getAbsPathOppositeFile()));
					lblLocalSelectedPath.setToolTipText(diffEntry
							.getCollectionAndDataObjectListingEntry()
							.getFormattedAbsolutePath());
					lblIrodsSelectedPath.setToolTipText(diffEntry
							.getAbsPathOppositeFile());
				}

			}
		});
	}
}
