/*
 * PreferencesDialog.java
 *
 * Created on Nov 23, 2010, 2:58:18 PM
 */
package org.irods.jargon.idrop.desktop.systraygui;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.irods.jargon.core.connection.IRODSAccount;
import org.irods.jargon.core.exception.JargonException;
import org.irods.jargon.core.pub.UserAO;
import org.irods.jargon.transfer.exception.CannotUpdateTransferInProgressException;
import org.slf4j.LoggerFactory;

/**
 * Dialog that can manage preferences
 * 
 * @author mikeconway
 */
public class ChangePasswordDialog extends javax.swing.JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7844926246702788428L;
	private final iDrop idrop;
	public static org.slf4j.Logger log = LoggerFactory
			.getLogger(ChangePasswordDialog.class);

	/** Creates new form PreferencesDialog */
	public ChangePasswordDialog(final iDrop idrop, final JDialog parent,
			final boolean modal) {
		super(parent, modal);
		this.idrop = idrop;
		initComponents();
		setUpPasswordPanel();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		pnlCurrentGrid = new javax.swing.JPanel();
		lblHostLabel = new javax.swing.JLabel();
		lblHost = new javax.swing.JLabel();
		lblPortLabel = new javax.swing.JLabel();
		lblPort = new javax.swing.JLabel();
		lblZoneLabel = new javax.swing.JLabel();
		lblZone = new javax.swing.JLabel();
		lblResourceLabel = new javax.swing.JLabel();
		lblResource = new javax.swing.JLabel();
		lblUserNameLabel = new javax.swing.JLabel();
		lblUserName = new javax.swing.JLabel();
		pnlPasswords = new javax.swing.JPanel();
		lblNewPassword = new javax.swing.JLabel();
		passwdNewPassword = new javax.swing.JPasswordField();
		lblConfirmPassword = new javax.swing.JLabel();
		passwdConfirmPassword = new javax.swing.JPasswordField();
		pnlPasswordButtons = new javax.swing.JPanel();
		btnUpdatePassword = new javax.swing.JButton();
		btnCancel = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("iDrop - Change Password");
		setAlwaysOnTop(true);
		setMinimumSize(new java.awt.Dimension(551, 400));

		pnlCurrentGrid.setLayout(new java.awt.GridBagLayout());

		lblHostLabel.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblHostLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlCurrentGrid.add(lblHostLabel, gridBagConstraints);

		lblHost.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblHost.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlCurrentGrid.add(lblHost, gridBagConstraints);

		lblPortLabel.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblPortLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlCurrentGrid.add(lblPortLabel, gridBagConstraints);

		lblPort.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblPort.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlCurrentGrid.add(lblPort, gridBagConstraints);

		lblZoneLabel.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblZoneLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlCurrentGrid.add(lblZoneLabel, gridBagConstraints);

		lblZone.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblZone.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlCurrentGrid.add(lblZone, gridBagConstraints);

		lblResourceLabel.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblResourceLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlCurrentGrid.add(lblResourceLabel, gridBagConstraints);

		lblResource.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblResource.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlCurrentGrid.add(lblResource, gridBagConstraints);

		lblUserNameLabel.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblUserNameLabel.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
		pnlCurrentGrid.add(lblUserNameLabel, gridBagConstraints);

		lblUserName.setText(org.openide.util.NbBundle.getMessage(
				ChangePasswordDialog.class,
				"IDROPConfigurationPanel.lblUserName.text")); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
		pnlCurrentGrid.add(lblUserName, gridBagConstraints);

		pnlPasswords.setLayout(new java.awt.GridBagLayout());

		lblNewPassword.setText("New password:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		pnlPasswords.add(lblNewPassword, gridBagConstraints);

		passwdNewPassword.setColumns(15);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		pnlPasswords.add(passwdNewPassword, gridBagConstraints);

		lblConfirmPassword.setText("Confirm password:");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		pnlPasswords.add(lblConfirmPassword, gridBagConstraints);

		passwdConfirmPassword.setColumns(15);
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		pnlPasswords.add(passwdConfirmPassword, gridBagConstraints);

		btnUpdatePassword.setMnemonic('P');
		btnUpdatePassword.setText("Update Password");
		btnUpdatePassword
				.setToolTipText("Change the current password to the new values");
		btnUpdatePassword
				.addActionListener(new java.awt.event.ActionListener() {
					@Override
					public void actionPerformed(
							final java.awt.event.ActionEvent evt) {
						btnUpdatePasswordActionPerformed(evt);
					}
				});
		pnlPasswordButtons.add(btnUpdatePassword);

		btnCancel.setMnemonic('c');
		btnCancel.setText("Cancel");
		btnCancel.setToolTipText("Cancel the password change");
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(final java.awt.event.ActionEvent evt) {
				btnCancelActionPerformed(evt);
			}
		});
		pnlPasswordButtons.add(btnCancel);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		pnlPasswords.add(pnlPasswordButtons, gridBagConstraints);

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 5;
		gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
		gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
		pnlCurrentGrid.add(pnlPasswords, gridBagConstraints);

		getContentPane().add(pnlCurrentGrid, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void btnCancelActionPerformed(final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
		dispose();
	}// GEN-LAST:event_btnCancelActionPerformed

	private void btnUpdatePasswordActionPerformed(
			final java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnUpdatePasswordActionPerformed

		log.info("changing password, doing edits first");
		initializePasswordColors();

		if (passwdNewPassword.getPassword().length == 0) {
			passwdNewPassword.setBackground(Color.red);
		}

		if (passwdConfirmPassword.getPassword().length == 0) {
			passwdConfirmPassword.setBackground(Color.red);
		}

		if (passwdNewPassword.getPassword().length == 0
				|| passwdConfirmPassword.getPassword().length == 0) {
			JOptionPane.showMessageDialog(idrop,
					"New or confirm password is missing");
			return;
		}

		String newPassword = new String(passwdNewPassword.getPassword());
		String confirmPassword = new String(passwdConfirmPassword.getPassword());

		if (newPassword.equals(confirmPassword)) {
			// passwords match
		} else {
			passwdNewPassword.setBackground(Color.red);
			passwdConfirmPassword.setBackground(Color.red);
			JOptionPane.showMessageDialog(this,
					"New and confirm password do not match");
			return;
		}

		log.info("edits pass, updating password");
		try {
			log.info("check queue for any jobs for the account, these have the old password.");
			IRODSAccount irodsAccount = idrop.getIrodsAccount();

			idrop.getiDropCore().getTransferManager()
					.updatePassword(irodsAccount, newPassword);
			UserAO userAO = idrop.getiDropCore().getIrodsFileSystem()
					.getIRODSAccessObjectFactory()
					.getUserAO(idrop.getIrodsAccount());
			userAO.changeAUserPasswordByThatUser(irodsAccount.getUserName(),
					irodsAccount.getPassword(), newPassword);
			log.info("password changed, resetting iRODS Account");
			IRODSAccount newAccount = new IRODSAccount(irodsAccount.getHost(),
					irodsAccount.getPort(), irodsAccount.getUserName(),
					newPassword, irodsAccount.getHomeDirectory(),
					irodsAccount.getZone(),
					irodsAccount.getDefaultStorageResource());
			idrop.setIrodsAccount(newAccount);
			idrop.reinitializeForChangedIRODSAccount();
			JOptionPane.showMessageDialog(this, "Password was changed");

		} catch (CannotUpdateTransferInProgressException ex) {
			JOptionPane
					.showMessageDialog(
							this,
							"Transfers for this account are pending, this account can not be changed until completed and purged");
			return;
		} catch (JargonException ex) {
			Logger.getLogger(ChangePasswordDialog.class.getName()).log(
					Level.SEVERE, null, ex);
		} finally {
			idrop.getiDropCore().closeIRODSConnection(
					idrop.getiDropCore().getIrodsAccount());
			dispose();
		}
	}// GEN-LAST:event_btnUpdatePasswordActionPerformed

	private void setUpPasswordPanel() {
		IRODSAccount account = idrop.getIrodsAccount();
		lblHost.setText(account.getHost());
		lblPort.setText(String.valueOf(account.getPort()));
		lblZone.setText(account.getZone());
		lblResource.setText(account.getZone());
		lblUserName.setText(account.getUserName());
		initializePasswordColors();
	}

	private void initializePasswordColors() {
		passwdNewPassword.setBackground(Color.white);
		passwdConfirmPassword.setBackground(Color.white);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnUpdatePassword;
	private javax.swing.JLabel lblConfirmPassword;
	private javax.swing.JLabel lblHost;
	private javax.swing.JLabel lblHostLabel;
	private javax.swing.JLabel lblNewPassword;
	private javax.swing.JLabel lblPort;
	private javax.swing.JLabel lblPortLabel;
	private javax.swing.JLabel lblResource;
	private javax.swing.JLabel lblResourceLabel;
	private javax.swing.JLabel lblUserName;
	private javax.swing.JLabel lblUserNameLabel;
	private javax.swing.JLabel lblZone;
	private javax.swing.JLabel lblZoneLabel;
	private javax.swing.JPasswordField passwdConfirmPassword;
	private javax.swing.JPasswordField passwdNewPassword;
	private javax.swing.JPanel pnlCurrentGrid;
	private javax.swing.JPanel pnlPasswordButtons;
	private javax.swing.JPanel pnlPasswords;
	// End of variables declaration//GEN-END:variables
}
