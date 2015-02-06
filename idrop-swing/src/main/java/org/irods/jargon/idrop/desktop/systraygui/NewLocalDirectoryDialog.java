package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import org.irods.jargon.idrop.desktop.systraygui.viscomponents.LocalFileNode;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.LocalFileSystemModel;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.LocalFileTree;
import org.slf4j.LoggerFactory;

/**
 * Dialog to create a new local directory in the local file tree
 * 
 * @author mikeconway
 */
public class NewLocalDirectoryDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5136632505840351034L;
	private final iDrop idrop;
	private String parentDirectory = "";
	private final LocalFileTree localFileTree;
	private final LocalFileNode parentNode;
	public static org.slf4j.Logger log = LoggerFactory
			.getLogger(NewLocalDirectoryDialog.class);

	public String getParentDirectory() {
		return parentDirectory;
	}

	public void setParentDirectory(final String parentDirectory) {
		this.parentDirectory = parentDirectory;
	}

	/** Creates new form NewIRODSDirectoryDialog */
	public NewLocalDirectoryDialog(final iDrop parent, final boolean modal,
			final String parentDirectory, final LocalFileTree localFileTree,
			final LocalFileNode parentNode) {
		super(parent, modal);
		idrop = parent;
		this.parentDirectory = parentDirectory;
		this.localFileTree = localFileTree;
		this.parentNode = parentNode;
		initComponents();
		registerKeystrokeListener();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */

	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitle = new javax.swing.JLabel();
        pnlFolderData = new javax.swing.JPanel();
        txtNewFolder = new javax.swing.JTextField();
        pnlBottom = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Local Folder Dialog");
        setName("newLocalDialog"); // NOI18N
        setPreferredSize(new java.awt.Dimension(300, 200));

        lblTitle.setText("Please enter a name for the new folder");
        lblTitle.setName("lblWelcome"); // NOI18N
        getContentPane().add(lblTitle, java.awt.BorderLayout.NORTH);

        pnlFolderData.setLayout(new java.awt.GridBagLayout());

        txtNewFolder.setColumns(200);
        txtNewFolder.setToolTipText("A name for the new folder underneath the displayed parent");
        txtNewFolder.setMinimumSize(new java.awt.Dimension(200, 20));
        txtNewFolder.setName("newLocalDirectoryName"); // NOI18N
        txtNewFolder.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        pnlFolderData.add(txtNewFolder, gridBagConstraints);

        getContentPane().add(pnlFolderData, java.awt.BorderLayout.CENTER);

        pnlBottom.setMaximumSize(null);
        pnlBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_192_circle_remove.png"))); // NOI18N
        btnCancel.setMnemonic('c');
        btnCancel.setText(org.openide.util.NbBundle.getMessage(NewLocalDirectoryDialog.class, "Cancel")); // NOI18N
        btnCancel.setToolTipText("Cancel the create operation");
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlBottom.add(btnCancel);

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_193_circle_ok.png"))); // NOI18N
        btnOK.setMnemonic('o');
        btnOK.setText(org.openide.util.NbBundle.getMessage(NewLocalDirectoryDialog.class, "CreateNewFolder")); // NOI18N
        btnOK.setToolTipText("Rename the file");
        btnOK.setName("btnOk"); // NOI18N
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        pnlBottom.add(btnOK);

        getContentPane().add(pnlBottom, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btnCancelActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
		dispose();
	}// GEN-LAST:event_btnCancelActionPerformed

	private void btnOKActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKActionPerformed
		processNew();
	}// GEN-LAST:event_btnOKActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlFolderData;
    private javax.swing.JTextField txtNewFolder;
    // End of variables declaration//GEN-END:variables
	private void processNew() {
		// add the new folder to irods, add to the tree, and scroll the tree
		// into view

		if (txtNewFolder.getText().isEmpty()) {
			txtNewFolder.setBackground(Color.red);
			idrop.showMessageFromOperation("please enter a new folder name");
			return;
		}

		final NewLocalDirectoryDialog thisDialog = this;

		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				log.info("adding new folder named:{}", txtNewFolder.getText());
				thisDialog.setCursor(Cursor
						.getPredefinedCursor(Cursor.WAIT_CURSOR));
				try {

					StringBuilder sb = new StringBuilder();
					sb.append(parentDirectory);
					sb.append('/');
					sb.append(txtNewFolder.getText());
					String newDirPath = sb.toString();

					File newDir = new File(newDirPath);

					boolean created = newDir.mkdirs();

					if (!created) {
						log.info("could not create new folder in:{}",
								newDirPath);
						idrop.showMessageFromOperation("directory could not be created");
						thisDialog.setCursor(Cursor
								.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
						return;
					}

					log.info("new file was created, adding as a node in the local tree");
					LocalFileNode newLocalNode = new LocalFileNode(newDir);
					LocalFileSystemModel localFileSystemModel = (LocalFileSystemModel) localFileTree
							.getModel();
					if (parentNode.isCached()) {
						localFileSystemModel.insertNodeInto(newLocalNode,
								parentNode, parentNode.getChildCount());
					} else {
						parentNode.lazyLoadOfChildrenOfThisNode();
					}

					TreePath scrollToPath = new TreePath(newLocalNode.getPath());
					localFileTree.expandPath(scrollToPath);

					localFileTree.scrollPathToVisible(scrollToPath);
					thisDialog.setCursor(Cursor
							.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
					idrop.showMessageFromOperation("new local folder created");

				} catch (Exception ex) {
					Logger.getLogger(NewLocalDirectoryDialog.class.getName())
							.log(Level.SEVERE, null, ex);
					idrop.showIdropException(ex);
				}

				thisDialog.dispose();
			}
		});
	}

	/**
	 * Register a listener for the enter event, so login can occur.
	 */
	private void registerKeystrokeListener() {

		KeyStroke enter = KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_ENTER, 0);
		Action enterAction = new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 426777698063028685L;

			@Override
			public void actionPerformed(final ActionEvent e) {
				processNew();
			}
		};
		btnOK.registerKeyboardAction(enterAction, enter,
				JComponent.WHEN_IN_FOCUSED_WINDOW);

	}
}
