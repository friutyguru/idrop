/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.protovalues.FilePermissionEnum;
import org.irods.jargon.core.pub.IRODSFileSystem;
import org.irods.jargon.core.pub.UserAO;
import org.irods.jargon.core.pub.domain.User;
import org.irods.jargon.core.pub.domain.UserFilePermission;
import org.openide.util.Exceptions;

/**
 *
 * @author lisa
 */
public class AddPermissionsDialog extends javax.swing.JDialog implements ActionListener {
    
    IRODSFileSystem irodsFileSystem;
    IRODSAccount irodsAccount;
    boolean isCollection;
    UserFilePermission permissionToAdd = null;

    /**
     * Creates new form AddPermissionsDialog
     */
    public AddPermissionsDialog(javax.swing.JDialog parent,
            boolean modal,
            IRODSFileSystem irodsFileSystem,
            IRODSAccount irodsAccount) {
        super(parent, modal);
        initComponents();
        
        this.irodsFileSystem = irodsFileSystem;
        this.irodsAccount = irodsAccount;
        
        
        cbPermissionsPermission.addItem("READ");
        cbPermissionsPermission.addItem("WRITE");
        cbPermissionsPermission.addItem("OWN");

        List<User> users = null;
        try {
            UserAO userAO = irodsFileSystem.getIRODSAccessObjectFactory().getUserAO(irodsAccount);
            users = userAO.findAll();
            Collections.sort(users, new Comparator<User>() {
                @Override
                public int compare(final User object1, final User object2) {
                    return object1.getName().compareTo(object2.getName());
                }
            } );
 
            for (User user: users) {
                cbPermissionsUserName.addItem(user.getNameWithZone());
            }
        } catch (JargonException ex) {
            Exceptions.printStackTrace(ex);
        }
        cbPermissionsPermission.addActionListener(this);
        cbPermissionsUserName.addActionListener(this);
        
        updateAddButtonStatus();
    }
    
    private void updateAddButtonStatus() {
        btnPermissionsAdd.setEnabled((cbPermissionsUserName.getSelectedIndex() >= 0) &&
                                      (cbPermissionsPermission.getSelectedIndex() >= 0));
    }
    
    public UserFilePermission getPermissionToAdd() {
        return this.permissionToAdd;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        updateAddButtonStatus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlPermissionEdit = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        cbPermissionsUserName = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        cbPermissionsPermission = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnPermissionsCancel = new javax.swing.JButton();
        btnPermissionsAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(AddPermissionsDialog.class, "AddPermissionsDialog.title")); // NOI18N
        setBackground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(460, 180));

        pnlMain.setLayout(new java.awt.BorderLayout());

        pnlPermissionEdit.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 8, 20, 8));
        pnlPermissionEdit.setPreferredSize(new java.awt.Dimension(527, 200));
        pnlPermissionEdit.setLayout(new java.awt.BorderLayout());

        jLabel31.setText(org.openide.util.NbBundle.getMessage(AddPermissionsDialog.class, "AddPermissionsDialog.jLabel31.text")); // NOI18N
        jLabel31.setPreferredSize(new java.awt.Dimension(120, 16));
        jPanel3.add(jLabel31);

        cbPermissionsUserName.setMinimumSize(new java.awt.Dimension(60, 27));
        cbPermissionsUserName.setPreferredSize(new java.awt.Dimension(260, 27));
        jPanel3.add(cbPermissionsUserName);

        pnlPermissionEdit.add(jPanel3, java.awt.BorderLayout.NORTH);

        jLabel32.setText(org.openide.util.NbBundle.getMessage(AddPermissionsDialog.class, "AddPermissionsDialog.jLabel32.text")); // NOI18N
        jLabel32.setPreferredSize(new java.awt.Dimension(120, 16));
        jPanel4.add(jLabel32);

        cbPermissionsPermission.setPreferredSize(new java.awt.Dimension(260, 27));
        jPanel4.add(cbPermissionsPermission);

        pnlPermissionEdit.add(jPanel4, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlPermissionEdit, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 6, 1));
        jPanel1.setPreferredSize(new java.awt.Dimension(525, 40));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(200, 34));
        jPanel2.setRequestFocusEnabled(false);

        btnPermissionsCancel.setText(org.openide.util.NbBundle.getMessage(AddPermissionsDialog.class, "AddPermissionsDialog.btnPermissionsCancel.text")); // NOI18N
        btnPermissionsCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermissionsCancelActionPerformed(evt);
            }
        });
        jPanel2.add(btnPermissionsCancel);

        btnPermissionsAdd.setText(org.openide.util.NbBundle.getMessage(AddPermissionsDialog.class, "AddPermissionsDialog.btnPermissionsAdd.text")); // NOI18N
        btnPermissionsAdd.setActionCommand(org.openide.util.NbBundle.getMessage(AddPermissionsDialog.class, "AddPermissionsDialog.btnPermissionsAdd.actionCommand")); // NOI18N
        btnPermissionsAdd.setEnabled(false);
        btnPermissionsAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermissionsAddActionPerformed(evt);
            }
        });
        jPanel2.add(btnPermissionsAdd);

        jPanel1.add(jPanel2, java.awt.BorderLayout.EAST);

        pnlMain.add(jPanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPermissionsAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermissionsAddActionPerformed
        
        String selectedPermission = (String)cbPermissionsPermission.getSelectedItem();
        String tmpSelectedUser = (String)cbPermissionsUserName.getSelectedItem();
        String selectedUser = null;

        // probably have to remve #zone from user name
        int idx = tmpSelectedUser.indexOf("#");
        if (idx >= 0) {
            selectedUser = tmpSelectedUser.substring(0, idx);
        }
        else {
            selectedUser = tmpSelectedUser;
        }
        
        try {
            UserAO userAO = irodsFileSystem.getIRODSAccessObjectFactory().getUserAO(irodsAccount);
            User user = userAO.findByName(tmpSelectedUser);

            permissionToAdd = new UserFilePermission(
                    selectedUser,
                    user.getId(),
                    FilePermissionEnum.valueOf(selectedPermission),
                    user.getUserType(),
                    user.getZone());
        } catch (JargonException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_btnPermissionsAddActionPerformed

    private void btnPermissionsCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermissionsCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnPermissionsCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPermissionsAdd;
    private javax.swing.JButton btnPermissionsCancel;
    private javax.swing.JComboBox cbPermissionsPermission;
    private javax.swing.JComboBox cbPermissionsUserName;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPermissionEdit;
    // End of variables declaration//GEN-END:variables

}