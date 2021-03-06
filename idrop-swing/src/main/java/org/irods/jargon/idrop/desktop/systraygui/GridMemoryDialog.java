/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.irods.jargon.conveyor.core.ConveyorBusyException;
import org.irods.jargon.conveyor.core.ConveyorExecutionException;
import org.irods.jargon.conveyor.core.GridAccountService;
import org.irods.jargon.core.connection.AuthScheme;
import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.connection.auth.AuthResponse;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.IRODSFileSystem;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.GridInfoTableModel;
import org.irods.jargon.idrop.desktop.systraygui.viscomponents.MetadataTableModel;
import org.irods.jargon.idrop.exceptions.IdropException;
import org.irods.jargon.idrop.exceptions.IdropRuntimeException;
import org.irods.jargon.transfer.dao.domain.GridAccount;
import org.openide.util.Exceptions;
import org.slf4j.LoggerFactory;

/**
 *
 * @author lisa
 */
public class GridMemoryDialog extends javax.swing.JDialog implements
        ListSelectionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1908366053493367650L;
    private GridMemoryDialog dialog;
    private final IDROPCore idropCore;
    public static org.slf4j.Logger log = LoggerFactory
            .getLogger(MetadataTableModel.class);

    /**
     * Creates new form GridMemoryDialog
     */
    // public GridMemoryDialog(java.awt.Frame parent, boolean modal, final
    // IDROPCore idropCore, final iDrop idrop) {
    public GridMemoryDialog(final java.awt.Frame parent, final boolean modal,
            final IDROPCore idropCore, final IRODSAccount savedAccount) {
        super(parent, modal);
        log.info("GridMemoryDialog()");
        initComponents();
        this.idropCore = idropCore;
        initGridInfoTable();
        getRootPane().setDefaultButton(btnLogin);
    }

    private void initGridInfoTable() {
        log.info("initGridInfoTable()");
        dialog = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                dialog.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                try {
                    GridAccountService gridAccountService = idropCore
                            .getConveyorService().getGridAccountService();
                    List<GridAccount> gridAccounts = null;
                    log.info("listing all grid accounts:()");
                    gridAccounts = gridAccountService.findAll();

                    GridInfoTableModel gridInfoTableModel = new GridInfoTableModel(
                            gridAccounts);

                    tableGridInfo.setModel(gridInfoTableModel);
                    tableGridInfo.getSelectionModel().addListSelectionListener(
                            dialog);
                    tableGridInfo.validate();
                } catch (ConveyorExecutionException ex) {
                    Logger.getLogger(GridMemoryDialog.class.getName()).log(
                            Level.SEVERE, null, ex);
                }

                tableGridInfo.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(final MouseEvent evt) {
                        if (evt.getClickCount() == 2) {
                            log.info("processing as login");
                            processLogin();

                        }
                    }
                });

                dialog.setCursor(Cursor
                        .getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    private void updateGridInfoDeleteBtnStatus(final int selectedRowCount) {
        // delete button should only be enabled when there is a tableGridInfo
        // selection
        btnDeleteGridInfo.setEnabled(selectedRowCount > 0);
    }

    private void updateLoginBtnStatus(final int selectedRowCount) {
        // delete button should only be enabled when there is a tableGridInfo
        // selection
        btnLogin.setEnabled(selectedRowCount > 0);
        btnEdit.setEnabled(selectedRowCount > 0);
    }

    private boolean processLogin() {

        IRODSAccount irodsAccount = null;
        GridAccount loginAccount = null;

        int row = tableGridInfo.getSelectedRow();
        if (row < 0) {
            return false;
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        // get selected grid account
        GridInfoTableModel tm = (GridInfoTableModel) tableGridInfo.getModel();

        GridAccount gridTableData = tm.getRow(row);
        loginAccount = getStoredGridAccountFromGridTableData(gridTableData);

        if (loginAccount != null) {
            try {
                irodsAccount = idropCore.getConveyorService()
                        .getGridAccountService()
                        .irodsAccountForGridAccount(loginAccount);
            } catch (ConveyorExecutionException ex) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                Logger.getLogger(GridMemoryDialog.class.getName()).log(
                        Level.SEVERE, null, ex);
                MessageManager
                        .showError(
                                this,
                                "Cannot retrieve irods account from selected grid account.",
                                "Login Error");
                return false;
            }

            AuthScheme scheme = loginAccount.getAuthScheme();
            if ((scheme != null) && (scheme.equals(AuthScheme.PAM.name()))) {
                irodsAccount.setAuthenticationScheme(AuthScheme.PAM);
            }

            IRODSFileSystem irodsFileSystem = null;

            /*
             * getting userAO will attempt the login
             */
            try {
                irodsFileSystem = idropCore.getIrodsFileSystem();
                AuthResponse authResponse = irodsFileSystem
                        .getIRODSAccessObjectFactory()
                        .authenticateIRODSAccount(irodsAccount);
                idropCore.setIrodsAccount(authResponse
                        .getAuthenticatedIRODSAccount());
                try {
                    idropCore.getIdropConfigurationService().saveLogin(
                            irodsAccount);
                    idropCore.setIrodsAccount(irodsAccount);
                } catch (IdropException ex) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    throw new IdropRuntimeException(
                            "error saving irodsAccount", ex);
                }
                dispose();
            } catch (JargonException ex) {
                if (ex.getMessage().indexOf("Connection refused") > -1) {
                    Logger.getLogger(GridMemoryDialog.class.getName()).log(
                            Level.SEVERE, null, ex);
                    MessageManager.showError(this,
                            "Cannot connect to the server, is it down?",
                            "Login Error");

                    return false;
                } else if (ex.getMessage().indexOf("Connection reset") > -1) {
                    Logger.getLogger(GridMemoryDialog.class.getName()).log(
                            Level.SEVERE, null, ex);
                    MessageManager.showError(this,
                            "Cannot connect to the server, is it down?",
                            "Login Error");

                    return false;
                } else if (ex.getMessage().indexOf(
                        "io exception opening socket") > -1) {
                    Logger.getLogger(GridMemoryDialog.class.getName()).log(
                            Level.SEVERE, null, ex);
                    MessageManager.showError(this,
                            "Cannot connect to the server, is it down?",
                            "Login Error");

                    return false;
                } else {
                    Logger.getLogger(GridMemoryDialog.class.getName()).log(
                            Level.SEVERE, null, ex);
                    MessageManager
                            .showError(
                                    this,
                                    "Login error - unable to log in, or invalid user id.",
                                    "Login Error");

                    return false;
                }
            } finally {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                if (irodsFileSystem != null) {
                    irodsFileSystem.closeAndEatExceptions();
                }
            }
        } else {
            MessageManager.showError(this,
                    "Cannot connect to the server, is grid account valid?",
                    "Login Error");
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            return false;
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        return true;
    }

    // Use the Grid Account data retrieved from the GridInfoTable to retrieve
    // the full record from the DB
    GridAccount getStoredGridAccountFromGridTableData(
            final GridAccount gridTableData) {
        IRODSAccount irodsAccount = null;
        GridAccount storedGridAccount = null;

        if (gridTableData != null) {
            try {
                irodsAccount = IRODSAccount.instance(gridTableData.getHost(),
                        0, gridTableData.getUserName(), new String(),
                        new String(), gridTableData.getZone(), new String());
            } catch (JargonException ex) {
                Logger.getLogger(GridMemoryDialog.class.getName()).log(
                        Level.SEVERE, null, ex);
                MessageManager.showError(this,
                        "Cannot retrieve grid account information.",
                        "Retrieve Grid Account Information");
            }

            try {
                storedGridAccount = idropCore.getConveyorService()
                        .getGridAccountService()
                        .findGridAccountByIRODSAccount(irodsAccount);
            } catch (ConveyorExecutionException ex) {
                Logger.getLogger(GridMemoryDialog.class.getName()).log(
                        Level.SEVERE, null, ex);
                MessageManager.showError(this,
                        "Cannot retrieve grid account information.",
                        "Retrieve Grid Account Information");
            }
        }

        return storedGridAccount;
    }

    // ListSelectionListener methods
    @Override
    public void valueChanged(final ListSelectionEvent lse) {
        int selectedRowCount = 0;

        if (!lse.getValueIsAdjusting()) {
            selectedRowCount = tableGridInfo.getSelectedRowCount();
            updateGridInfoDeleteBtnStatus(selectedRowCount);
            updateLoginBtnStatus(selectedRowCount);
        }
    }

    // end ListSelectionListener methods
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlGridInfoTable = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableGridInfo = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnAddGridInfo = new javax.swing.JButton();
        btnDeleteGridInfo = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        pnlActions = new javax.swing.JPanel();
        pnlActionsButtons = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.title")); // NOI18N
        setName("gridMemoryDialog"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 300));

        pnlGridInfoTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 10, 2, 10));
        pnlGridInfoTable.setPreferredSize(new java.awt.Dimension(600, 150));
        pnlGridInfoTable.setLayout(new java.awt.BorderLayout());

        jScrollPane3.setMinimumSize(null);

        tableGridInfo.setMaximumSize(null);
        tableGridInfo.setMinimumSize(null);
        tableGridInfo.setName("gridTable"); // NOI18N
        tableGridInfo.setPreferredSize(null);
        jScrollPane3.setViewportView(tableGridInfo);

        pnlGridInfoTable.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel7.setPreferredSize(new java.awt.Dimension(568, 50));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        jPanel7.setLayout(flowLayout1);

        jPanel9.setLayout(new java.awt.GridBagLayout());

        btnAddGridInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_006_user_add.png"))); // NOI18N
        btnAddGridInfo.setMnemonic('+');
        btnAddGridInfo.setText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.btnAddGrid.text")); // NOI18N
        btnAddGridInfo.setToolTipText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.btnAddGrid.toolTipText")); // NOI18N
        btnAddGridInfo.setMaximumSize(null);
        btnAddGridInfo.setMinimumSize(null);
        btnAddGridInfo.setName("btnAddGrid"); // NOI18N
        btnAddGridInfo.setPreferredSize(new java.awt.Dimension(110, 37));
        btnAddGridInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGridInfoActionPerformed(evt);
            }
        });
        jPanel9.add(btnAddGridInfo, new java.awt.GridBagConstraints());

        btnDeleteGridInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_007_user_remove.png"))); // NOI18N
        btnDeleteGridInfo.setMnemonic('-');
        btnDeleteGridInfo.setText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.btnDeleteGrid.text")); // NOI18N
        btnDeleteGridInfo.setToolTipText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.btnDeleteGrid.toolTipText")); // NOI18N
        btnDeleteGridInfo.setEnabled(false);
        btnDeleteGridInfo.setMaximumSize(null);
        btnDeleteGridInfo.setMinimumSize(null);
        btnDeleteGridInfo.setName("btnDeleteGrid"); // NOI18N
        btnDeleteGridInfo.setPreferredSize(new java.awt.Dimension(120, 37));
        btnDeleteGridInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteGridInfoActionPerformed(evt);
            }
        });
        jPanel9.add(btnDeleteGridInfo, new java.awt.GridBagConstraints());

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_030_pencil.png"))); // NOI18N
        btnEdit.setMnemonic('E');
        btnEdit.setText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.btnEditGrid.text")); // NOI18N
        btnEdit.setToolTipText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.btnEditGrid.toolTipText")); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.setMaximumSize(null);
        btnEdit.setMinimumSize(null);
        btnEdit.setName("btnEditGrid"); // NOI18N
        btnEdit.setPreferredSize(new java.awt.Dimension(110, 37));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel9.add(btnEdit, new java.awt.GridBagConstraints());

        jPanel7.add(jPanel9);

        pnlGridInfoTable.add(jPanel7, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlGridInfoTable, java.awt.BorderLayout.CENTER);

        pnlActions.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 10, 2, 10));
        pnlActions.setLayout(new java.awt.GridBagLayout());

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_192_circle_remove.png"))); // NOI18N
        btnCancel.setMnemonic('C');
        btnCancel.setText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "Cancel")); // NOI18N
        btnCancel.setToolTipText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.btnCancel.toolTipText")); // NOI18N
        btnCancel.setActionCommand(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "Cancel")); // NOI18N
        btnCancel.setName("btnCancel"); // NOI18N
        btnCancel.setPreferredSize(new java.awt.Dimension(110, 37));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlActionsButtons.add(btnCancel);

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_204_unlock.png"))); // NOI18N
        btnLogin.setMnemonic('L');
        btnLogin.setText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "GridMemoryDialog.btnLogIn.text")); // NOI18N
        btnLogin.setToolTipText(org.openide.util.NbBundle.getMessage(GridMemoryDialog.class, "Login.tooltip")); // NOI18N
        btnLogin.setEnabled(false);
        btnLogin.setMaximumSize(null);
        btnLogin.setMinimumSize(null);
        btnLogin.setName("btnLogIn"); // NOI18N
        btnLogin.setPreferredSize(new java.awt.Dimension(90, 37));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlActionsButtons.add(btnLogin);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.9;
        pnlActions.add(pnlActionsButtons, gridBagConstraints);

        getContentPane().add(pnlActions, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddGridInfoActionPerformed(
            final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddGridInfoActionPerformed
        CreateGridInfoDialog createGridInfoDialog = new CreateGridInfoDialog(
                null, true, idropCore);

        createGridInfoDialog.setLocation((int) this.getLocation().getX(),
                (int) this.getLocation().getY());
        createGridInfoDialog.setVisible(true);

        IRODSAccount irodsAccount = createGridInfoDialog.getGridInfo();

        // first remove this user's entry from table if there is one
        if (irodsAccount != null) {
            try {
                GridInfoTableModel tm = (GridInfoTableModel) tableGridInfo
                        .getModel();
                tm.deleteRow(irodsAccount);

                // now add to table
                tm.addRow(irodsAccount);
            } catch (JargonException ex) {
                Logger.getLogger(GridMemoryDialog.class.getName()).log(
                        Level.SEVERE, null, ex);
                MessageManager.showError(this,
                        "Addition of grid account failed.",
                        "Create Grid Account");
            }
        }
    }// GEN-LAST:event_btnAddGridInfoActionPerformed

    private void btnDeleteGridInfoActionPerformed(
            final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteGridInfoActionPerformed

        int ans = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete a grid account?",
                "Delete Grid Account", JOptionPane.YES_NO_OPTION);

        if (ans == JOptionPane.YES_OPTION) {

            int[] selectedRows = tableGridInfo.getSelectedRows();
            int numRowsSelected = selectedRows.length;

            // have to remove rows in reverse
            for (int i = numRowsSelected - 1; i >= 0; i--) {
                int selectedRow = selectedRows[i];
                if (selectedRow >= 0) {
                    try {
                        GridInfoTableModel model = (GridInfoTableModel) tableGridInfo
                                .getModel();
                        try {
                            // delete grid account from service
                            idropCore
                                    .getConveyorService()
                                    .getGridAccountService()
                                    .deleteGridAccount(
                                            model.getRow(selectedRow));

                            // then remove from table
                            model.deleteRow(selectedRow);

                        } catch (ConveyorBusyException ex) {
                            Logger.getLogger(GridMemoryDialog.class.getName())
                                    .log(Level.SEVERE, null, ex);
                            MessageManager
                                    .showError(
                                            this,
                                            "Transfer for this grid account is currently in progess.\nPlease try again later.",
                                            "Delete Grid Account");
                        } catch (ConveyorExecutionException ex) {
                            Logger.getLogger(GridMemoryDialog.class.getName())
                                    .log(Level.SEVERE, null, ex);
                            MessageManager.showError(this,
                                    "Deletion of grid account failed.",
                                    "Delete Grid Account");
                        }

                    } catch (JargonException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
            }
        }
    }// GEN-LAST:event_btnDeleteGridInfoActionPerformed

    private void btnLoginActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoginActionPerformed
        if (processLogin()) {
            dispose();
        }
    }// GEN-LAST:event_btnLoginActionPerformed

    private void btnCancelActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }// GEN-LAST:event_btnCancelActionPerformed

    private void btnEditActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        int row = tableGridInfo.getSelectedRow();

        if (row == -1) {
            MessageManager.showWarning(this,
                    "No grid selected, please select a grid");
        }

        GridInfoTableModel model = (GridInfoTableModel) tableGridInfo
                .getModel();
        GridAccount gridTableData = model.getRow(row);
        GridAccount gridAccount = getStoredGridAccountFromGridTableData(gridTableData);
        EditGridInfoDialog editGridInfoDialog = new EditGridInfoDialog(
                // null, true, idropCore, gridAccount, idrop);
                null, true, idropCore, gridAccount);

        editGridInfoDialog.setLocation((int) dialog.getLocation().getX(),
                (int) dialog.getLocation().getY());
        editGridInfoDialog.setVisible(true);
    }// GEN-LAST:event_btnEditActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddGridInfo;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeleteGridInfo;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlActions;
    private javax.swing.JPanel pnlActionsButtons;
    private javax.swing.JPanel pnlGridInfoTable;
    private javax.swing.JTable tableGridInfo;
    // End of variables declaration//GEN-END:variables
}
