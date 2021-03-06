/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import javax.swing.JOptionPane;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.protovalues.FilePermissionEnum;
import org.irods.jargon.core.pub.CollectionAO;
import org.irods.jargon.core.pub.DataObjectAO;
import org.irods.jargon.core.pub.IRODSFileSystem;
import org.irods.jargon.core.pub.domain.UserFilePermission;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.PermissionsTableModel;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lisa
 */
public class EditPermissionsDialog extends javax.swing.JDialog {

    /**
     *
     */
    private static final long serialVersionUID = -8326176232950853930L;
    private final IRODSFileSystem irodsFileSystem;
    private final IRODSAccount irodsAccount;
    private final boolean isCollection;
    private final int selectedRow;
    private final String selectedObjectFullPath;
    private final PermissionsTableModel tableModel;
    private final UserFilePermission permissionToUpdate;
    public static org.slf4j.Logger log = LoggerFactory
            .getLogger(EditMetaDataDialog.class);

    /**
     * Creates new form EditPermissionsDialog
     */
    public EditPermissionsDialog(final javax.swing.JDialog parent,
            final boolean modal, final int selectedRow,
            final String selectedObjectFullPath,
            final UserFilePermission permissionToUpdate,
            final boolean isCollection, final IRODSFileSystem irodsFileSystem,
            final IRODSAccount irodsAccount, final PermissionsTableModel model) {

        super(parent, modal);
        initComponents();

        this.irodsFileSystem = irodsFileSystem;
        this.irodsAccount = irodsAccount;
        this.selectedRow = selectedRow;
        this.isCollection = isCollection;
        this.selectedObjectFullPath = selectedObjectFullPath;
        tableModel = model;
        this.permissionToUpdate = permissionToUpdate;

        initData();
    }

    private void initData() {

        cbPermissionsPermission.addItem("READ");
        cbPermissionsPermission.addItem("WRITE");
        cbPermissionsPermission.addItem("OWN");

        // List<User> users = null;
        // try {
        // UserAO userAO = irodsFileSystem.getIRODSAccessObjectFactory()
        // .getUserAO(irodsAccount);
        // users = userAO.findAll();
        // Collections.sort(users, new Comparator<User>() {
        // @Override
        // public int compare(final User object1, final User object2) {
        // return object1.getName().compareTo(object2.getName());
        // }
        // });
        //
        // for (User user : users) {
        // cbPermissionsUserName.addItem(user.getNameWithZone());
        // }
        // } catch (JargonException ex) {
        // log.error("cannot retrieve irods users list", ex);
        // JOptionPane.showMessageDialog(this,
        // "Cannot retrieve list of iRODS users",
        // "Edit Permissions", JOptionPane.PLAIN_MESSAGE);
        // }
        // cbPermissionsUserName.setSelectedItem(permissionToUpdate.getNameWithZone());
        lblUserName.setText(permissionToUpdate.getNameWithZone());
        cbPermissionsPermission.setSelectedItem(permissionToUpdate
                .getFilePermissionEnum().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlMain = new javax.swing.JPanel();
        pnlPermissionEdit = new javax.swing.JPanel();
        lblUserNameLabel = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        lblPermissionLabel = new javax.swing.JLabel();
        cbPermissionsPermission = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        btnPermissionsCancel = new javax.swing.JButton();
        btnPermissionsUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(EditPermissionsDialog.class, "EditPermissionsDialog.title")); // NOI18N
        setName("editSharePermissions"); // NOI18N
        setPreferredSize(new java.awt.Dimension(300, 200));

        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlPermissionEdit.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 8, 20, 8));
        pnlPermissionEdit.setPreferredSize(new java.awt.Dimension(527, 200));
        pnlPermissionEdit.setLayout(new java.awt.GridBagLayout());

        lblUserNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUserNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserNameLabel.setText(org.openide.util.NbBundle.getMessage(EditPermissionsDialog.class, "EditPermissionsDialog.lblUserName.text")); // NOI18N
        lblUserNameLabel.setName("lblUserName"); // NOI18N
        lblUserNameLabel.setPreferredSize(new java.awt.Dimension(120, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnlPermissionEdit.add(lblUserNameLabel, gridBagConstraints);

        lblUserName.setName("userName"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPermissionEdit.add(lblUserName, gridBagConstraints);

        lblPermissionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPermissionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPermissionLabel.setText(org.openide.util.NbBundle.getMessage(EditPermissionsDialog.class, "EditPermissionsDialog.lblSharePermission.text")); // NOI18N
        lblPermissionLabel.setName("lblSharePermission"); // NOI18N
        lblPermissionLabel.setPreferredSize(new java.awt.Dimension(120, 16));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        pnlPermissionEdit.add(lblPermissionLabel, gridBagConstraints);

        cbPermissionsPermission.setMinimumSize(null);
        cbPermissionsPermission.setName("comboPermission"); // NOI18N
        cbPermissionsPermission.setPreferredSize(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        pnlPermissionEdit.add(cbPermissionsPermission, gridBagConstraints);

        pnlMain.add(pnlPermissionEdit, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 6, 1));
        jPanel1.setPreferredSize(new java.awt.Dimension(525, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnPermissionsCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_192_circle_remove.png"))); // NOI18N
        btnPermissionsCancel.setMnemonic('c');
        btnPermissionsCancel.setText(org.openide.util.NbBundle.getMessage(EditPermissionsDialog.class, "Cancel")); // NOI18N
        btnPermissionsCancel.setToolTipText(org.openide.util.NbBundle.getMessage(EditPermissionsDialog.class, "EditPermissionsDialog.btnCancel.toolTipText")); // NOI18N
        btnPermissionsCancel.setActionCommand(org.openide.util.NbBundle.getMessage(EditPermissionsDialog.class, "EditPermissionsDialog.btnPermissionsCancel.actionCommand")); // NOI18N
        btnPermissionsCancel.setMaximumSize(null);
        btnPermissionsCancel.setMinimumSize(null);
        btnPermissionsCancel.setName("btnCancel"); // NOI18N
        btnPermissionsCancel.setPreferredSize(new java.awt.Dimension(110, 37));
        btnPermissionsCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermissionsCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnPermissionsCancel);

        btnPermissionsUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_193_circle_ok.png"))); // NOI18N
        btnPermissionsUpdate.setMnemonic('o');
        btnPermissionsUpdate.setText(org.openide.util.NbBundle.getMessage(EditPermissionsDialog.class, "EditGridInfoDialog.btnOk.text")); // NOI18N
        btnPermissionsUpdate.setActionCommand(org.openide.util.NbBundle.getMessage(EditPermissionsDialog.class, "EditPermissionsDialog.btnOk.actionCommand")); // NOI18N
        btnPermissionsUpdate.setMaximumSize(null);
        btnPermissionsUpdate.setMinimumSize(null);
        btnPermissionsUpdate.setName("btnOk"); // NOI18N
        btnPermissionsUpdate.setPreferredSize(new java.awt.Dimension(90, 37));
        btnPermissionsUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermissionsUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnPermissionsUpdate);

        pnlMain.add(jPanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPermissionsCancelActionPerformed(
            final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPermissionsCancelActionPerformed
        dispose();
    }// GEN-LAST:event_btnPermissionsCancelActionPerformed

    private void btnPermissionsUpdateActionPerformed(
            final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPermissionsUpdateActionPerformed
        String selectedPermission = (String) cbPermissionsPermission
                .getSelectedItem();
        String tmpSelectedUser = lblUserName.getText();
        // probably have to remove #zone from user name
        int idx = tmpSelectedUser.indexOf("#");
        if (idx >= 0) {
            tmpSelectedUser = tmpSelectedUser.substring(0, idx);
        } else {
        }

        // set updated permission type
        UserFilePermission newPermission = new UserFilePermission(
                permissionToUpdate.getUserName(),
                permissionToUpdate.getUserId(),
                FilePermissionEnum.valueOf(selectedPermission),
                permissionToUpdate.getUserType(),
                permissionToUpdate.getUserZone());

        try {
            // UserAO userAO = irodsFileSystem.getIRODSAccessObjectFactory()
            // .getUserAO(irodsAccount);
            // User user = userAO.findByName(tmpSelectedUser);
            //
            // UserFilePermission newPermission = new
            // UserFilePermission(selectedUser,
            // user.getId(),
            // FilePermissionEnum.valueOf(selectedPermission),
            // user.getUserType(), user.getZone());
            CollectionAO collectionAO = irodsFileSystem
                    .getIRODSAccessObjectFactory()
                    .getCollectionAO(irodsAccount);
            DataObjectAO dataObjectAO = irodsFileSystem
                    .getIRODSAccessObjectFactory()
                    .getDataObjectAO(irodsAccount);

            if (newPermission.getFilePermissionEnum() == FilePermissionEnum.READ) {
                if (isCollection) {
                    collectionAO.setAccessPermissionRead(
                            newPermission.getUserZone(),
                            selectedObjectFullPath,
                            newPermission.getUserName(), true);
                } else {
                    dataObjectAO
                            .setAccessPermissionRead(
                                    newPermission.getUserZone(),
                                    selectedObjectFullPath,
                                    newPermission.getUserName());
                }
            } else if (newPermission.getFilePermissionEnum() == FilePermissionEnum.WRITE) {
                if (isCollection) {
                    collectionAO.setAccessPermissionWrite(
                            newPermission.getUserZone(),
                            selectedObjectFullPath,
                            newPermission.getUserName(), true);
                } else {
                    dataObjectAO
                            .setAccessPermissionWrite(
                                    newPermission.getUserZone(),
                                    selectedObjectFullPath,
                                    newPermission.getUserName());
                }
            } else if (newPermission.getFilePermissionEnum() == FilePermissionEnum.OWN) {
                if (isCollection) {
                    collectionAO.setAccessPermissionOwn(
                            newPermission.getUserZone(),
                            selectedObjectFullPath,
                            newPermission.getUserName(), true);
                } else {
                    dataObjectAO
                            .setAccessPermissionOwn(
                                    newPermission.getUserZone(),
                                    selectedObjectFullPath,
                                    newPermission.getUserName());
                }
            }

            tableModel.updateRow(selectedRow, newPermission);

            JOptionPane.showMessageDialog(this,
                    "Permission Updated Successfully", "Update Permissions",
                    JOptionPane.PLAIN_MESSAGE);

        } catch (JargonException ex) {
            log.error("cannot update permissions", ex);
            JOptionPane.showMessageDialog(this, "Permission Update Failed",
                    "Update Permissions", JOptionPane.PLAIN_MESSAGE);
        }

        dispose();
    }// GEN-LAST:event_btnPermissionsUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPermissionsCancel;
    private javax.swing.JButton btnPermissionsUpdate;
    private javax.swing.JComboBox cbPermissionsPermission;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPermissionLabel;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserNameLabel;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPermissionEdit;
    // End of variables declaration//GEN-END:variables
}
