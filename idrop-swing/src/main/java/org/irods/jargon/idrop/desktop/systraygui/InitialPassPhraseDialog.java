/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.irods.jargon.conveyor.core.ConveyorExecutionException;
import org.irods.jargon.transfer.exception.PassPhraseInvalidException;

/**
 * 
 * @author lisa
 */
public class InitialPassPhraseDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7747139565320723806L;
	private final IDROPCore idropCore;
	private boolean validated = false;

	/**
	 * Creates new form InitialPassPhraseDialog
	 */
	public InitialPassPhraseDialog(final java.awt.Frame parent,
			final boolean modal, final IDROPCore idropCore) {
		super(parent, modal);
		this.idropCore = idropCore;
		initComponents();
		makeTextAreaLikeLabel();

		// make the okay button defulat so you can just enter
		// pass phrase and hit return
		getRootPane().setDefaultButton(btnOkay);
	}

	private void makeTextAreaLikeLabel() {

		txtAreaWelcomeLabel.setEditable(false);
		txtAreaWelcomeLabel.setCursor(null);
		txtAreaWelcomeLabel.setOpaque(false);
		txtAreaWelcomeLabel.setFocusable(false);
		txtAreaWelcomeLabel.setFont(UIManager.getFont("Label.font"));
		txtAreaWelcomeLabel.setWrapStyleWord(true);
		txtAreaWelcomeLabel.setLineWrap(true);
	}

	public boolean isValidated() {
		return validated;
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

		jPanel1 = new javax.swing.JPanel();
		txtAreaWelcomeLabel = new javax.swing.JTextArea();
		jPanel2 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtPassPhrase = new javax.swing.JPasswordField();
		jLabel2 = new javax.swing.JLabel();
		txtVerifyPassPhrase = new javax.swing.JPasswordField();
		jPanel3 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		btnCancel = new javax.swing.JButton();
		btnOkay = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class, "InitialPassPhraseDialog.title")); // NOI18N
		setPreferredSize(new java.awt.Dimension(600, 300));

		jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 14,
				4, 14));
		jPanel1.setPreferredSize(new java.awt.Dimension(0, 96));
		jPanel1.setLayout(new java.awt.BorderLayout());

		txtAreaWelcomeLabel.setEditable(false);
		txtAreaWelcomeLabel.setBackground(new java.awt.Color(238, 238, 238));
		txtAreaWelcomeLabel.setColumns(20);
		txtAreaWelcomeLabel.setRows(5);
		txtAreaWelcomeLabel.setText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.txtAreaWelcomeLabel.text")); // NOI18N
		txtAreaWelcomeLabel.setPreferredSize(new java.awt.Dimension(470, 90));
		jPanel1.add(txtAreaWelcomeLabel, java.awt.BorderLayout.CENTER);

		getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

		jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 14, 4,
				14));
		jPanel2.setLayout(new java.awt.GridBagLayout());

		jLabel1.setText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.jLabel1.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		jPanel2.add(jLabel1, gridBagConstraints);

		txtPassPhrase.setText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.txtPassPhrase.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 0.1;
		jPanel2.add(txtPassPhrase, gridBagConstraints);

		jLabel2.setText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.jLabel2.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		jPanel2.add(jLabel2, gridBagConstraints);

		txtVerifyPassPhrase.setText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.txtVerifyPassPhrase.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.weightx = 0.1;
		jPanel2.add(txtVerifyPassPhrase, gridBagConstraints);

		getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

		jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 14, 8,
				14));
		jPanel3.setLayout(new java.awt.BorderLayout());

		jPanel4.setLayout(new java.awt.BorderLayout());
		jPanel3.add(jPanel4, java.awt.BorderLayout.WEST);

		jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1,
				1));
		jPanel5.setLayout(new java.awt.BorderLayout());

		btnCancel
				.setIcon(new javax.swing.ImageIcon(
						getClass()
								.getResource(
										"/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_192_circle_remove.png"))); // NOI18N
		btnCancel.setMnemonic('c');
		btnCancel.setText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.btnCancel.text")); // NOI18N
		btnCancel.setToolTipText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.btnCancel.toolTipText")); // NOI18N
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnCancelActionPerformed(evt);
			}
		});
		jPanel5.add(btnCancel, java.awt.BorderLayout.WEST);

		btnOkay.setIcon(new javax.swing.ImageIcon(
				getClass()
						.getResource(
								"/org/irods/jargon/idrop/desktop/systraygui/images/glyphicons_193_circle_ok.png"))); // NOI18N
		btnOkay.setMnemonic('o');
		btnOkay.setText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.btnOkay.text")); // NOI18N
		btnOkay.setToolTipText(org.openide.util.NbBundle.getMessage(
				InitialPassPhraseDialog.class,
				"InitialPassPhraseDialog.btnOkay.toolTipText")); // NOI18N
		btnOkay.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnOkayActionPerformed(evt);
			}
		});
		jPanel5.add(btnOkay, java.awt.BorderLayout.EAST);

		jPanel3.add(jPanel5, java.awt.BorderLayout.EAST);

		getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnCancelActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
		dispose();
	}// GEN-LAST:event_btnCancelActionPerformed

	private void btnOkayActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOkayActionPerformed

		String passPhrase = new String(txtPassPhrase.getPassword());

		// make sure pass phrase is entered
		if ((passPhrase == null) || (passPhrase.length() <= 0)) {
			JOptionPane.showMessageDialog(this, "Please enter a pass phrase.",
					"Initialize Pass Phrase", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// check to make sure pass phrases match
		if (!passPhrase.equals(new String(txtVerifyPassPhrase.getPassword()))) {
			JOptionPane.showMessageDialog(this,
					"Pass phrases do not match. Please try again.",
					"Initialize Pass Phrase", JOptionPane.ERROR_MESSAGE);
			return;
		}
		try {
			idropCore.getConveyorService().validatePassPhrase(passPhrase);
		} catch (PassPhraseInvalidException ex) {
			Logger.getLogger(InitialPassPhraseDialog.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(this,
					"Pass phrase format is invalid. Please try again.",
					"Initialize Pass Phrase", JOptionPane.ERROR_MESSAGE);
			return;
		} catch (ConveyorExecutionException ex) {
			Logger.getLogger(InitialPassPhraseDialog.class.getName()).log(
					Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(this,
					"Creation of pass phrase failed.",
					"Initialize Pass Phrase", JOptionPane.ERROR_MESSAGE);
			return;
		}

		JOptionPane.showMessageDialog(this,
				"Pass phrase created successfully.", "Initialize Pass Phrase",
				JOptionPane.INFORMATION_MESSAGE);
		validated = true;
		dispose();
	}// GEN-LAST:event_btnOkayActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnOkay;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JTextArea txtAreaWelcomeLabel;
	private javax.swing.JPasswordField txtPassPhrase;
	private javax.swing.JPasswordField txtVerifyPassPhrase;
	// End of variables declaration//GEN-END:variables
}
