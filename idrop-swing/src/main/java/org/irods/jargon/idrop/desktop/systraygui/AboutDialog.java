/*
 * Created on Oct 8, 2010, 7:54:33 AM
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import org.irods.jargon.core.utils.JargonVersion;
import org.irods.jargon.idrop.desktop.systraygui.utils.Version;

/**
 *
 * @author mikeconway
 */
public class AboutDialog extends javax.swing.JDialog {

    /**
     *
     */
    private static final long serialVersionUID = 2532724831957628628L;

    /**
     * Creates new form AboutDialog
     */
    public AboutDialog(final java.awt.Frame parent, final boolean modal) {
        super(parent, modal);
        initComponents();
        registerKeystrokeListener();

        this.lblJargonVersion.setText(JargonVersion.VERSION + " | " + JargonVersion.BUILD_TIME);
        this.lblIdropVersion.setText(Version.VERSION + " | " + Version.BUILD_TIME);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed"
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlInfo = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblJargonVersionLabel = new javax.swing.JLabel();
        lblJargonVersion = new javax.swing.JLabel();
        lblIdropVersionLabel = new javax.swing.JLabel();
        lblIdropVersion = new javax.swing.JLabel();
        lblSplash = new javax.swing.JLabel();
        pnlItems = new javax.swing.JPanel();
        pnlButtons = new javax.swing.JPanel();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("iDrop - About");
        setName("dlgAbout"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));

        pnlInfo.setName("pnlInfo"); // NOI18N
        pnlInfo.setLayout(new java.awt.GridBagLayout());

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTitle.setText("iDrop Desktop Transfer Manager");
        lblTitle.setName("lblTitle"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 14, 0);
        pnlInfo.add(lblTitle, gridBagConstraints);

        lblJargonVersionLabel.setText("Jargon Version:");
        lblJargonVersionLabel.setName("lblJargonVersion"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        pnlInfo.add(lblJargonVersionLabel, gridBagConstraints);

        lblJargonVersion.setText("jLabel2");
        lblJargonVersion.setName("jargonVersion"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        pnlInfo.add(lblJargonVersion, gridBagConstraints);

        lblIdropVersionLabel.setText("iDrop Version:");
        lblIdropVersionLabel.setName("lblIdropVersion"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        pnlInfo.add(lblIdropVersionLabel, gridBagConstraints);

        lblIdropVersion.setText("jLabel2");
        lblIdropVersion.setName("idropVersion"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 7, 0, 0);
        pnlInfo.add(lblIdropVersion, gridBagConstraints);

        lblSplash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/images/iDrop.png"))); // NOI18N
        lblSplash.setName("lblSplash"); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 32, 0);
        pnlInfo.add(lblSplash, gridBagConstraints);

        pnlItems.setName("pnlItems"); // NOI18N
        pnlItems.setLayout(new java.awt.GridLayout(0, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(21, 21, 21, 21);
        pnlInfo.add(pnlItems, gridBagConstraints);

        getContentPane().add(pnlInfo, java.awt.BorderLayout.CENTER);

        pnlButtons.setName("pnlButtons"); // NOI18N
        pnlButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_193_circle_ok.png"))); // NOI18N
        btnOK.setMnemonic('O');
        btnOK.setText("OK");
        btnOK.setName("btnOK"); // NOI18N
        btnOK.setPreferredSize(new java.awt.Dimension(90, 37));
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKPressed(evt);
            }
        });
        pnlButtons.add(btnOK);

        getContentPane().add(pnlButtons, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKPressed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOKPressed
        disposeOfAbout();
    }// GEN-LAST:event_btnOKPressed

    private void disposeOfAbout() {
        dispose();
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
            private static final long serialVersionUID = -2548141664399058996L;

            @Override
            public void actionPerformed(final ActionEvent e) {
                disposeOfAbout();
            }
        };
        btnOK.registerKeyboardAction(enterAction, enter,
                JComponent.WHEN_IN_FOCUSED_WINDOW);

    }

    JLabel lblProjectHomeLink;
    JLabel lblProjectTrackerLink;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel lblIdropVersion;
    private javax.swing.JLabel lblIdropVersionLabel;
    private javax.swing.JLabel lblJargonVersion;
    private javax.swing.JLabel lblJargonVersionLabel;
    private javax.swing.JLabel lblSplash;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JPanel pnlItems;
    // End of variables declaration//GEN-END:variables
}
