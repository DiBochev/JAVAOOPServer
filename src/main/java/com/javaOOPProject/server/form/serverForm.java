/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server.form;

import com.javaOOPProject.server.Server;
import com.javaOOPProject.server.XMLManager;
import com.javaOOPProject.server.messages.ServerGUIMessages;
import com.javaOOPProject.server.registeredClients.RegisteredClients;
import com.javaOOPProject.server.registeredClients.RegisteredClients.Client;
import com.javaOOPProject.server.regularExpressions.RegularExpressions;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.xml.bind.JAXBException;

/**
 *
 * @author fgg12
 */
public class serverForm extends javax.swing.JFrame {

    private final Server server = new Server();
    private Thread startServerThread;
    private RegisteredClients registratedUsers;
    private final String PATH_TO_DATA = "data\\\\registeredClients.xml";
    

    /**
     * Creates new form serverForm
     */

    public serverForm() {
        initComponents();
        this.errorLabel.setVisible(false);
        this.startedServerNotificationLabel.setVisible(false);
        this.stoppedServerNotificationLabel.setVisible(false);
        this.serverStopButton.setEnabled(false);
        this.TabbedPanel.setEnabled(false);
        setEnableFields(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startServerButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        startedServerNotificationLabel = new javax.swing.JLabel();
        serverStopButton = new javax.swing.JButton();
        stoppedServerNotificationLabel = new javax.swing.JLabel();
        TabbedPanel = new javax.swing.JTabbedPane();
        addNewUserPanel = new javax.swing.JPanel();
        usernameLabelNewUserTap = new javax.swing.JLabel();
        usernameTextFieldNewUserTap = new javax.swing.JTextField();
        passwordLabelNewUserTap = new javax.swing.JLabel();
        firstPasswordFieldNewUserTap = new javax.swing.JPasswordField();
        reEnterPasswordLabelNewUserTap = new javax.swing.JLabel();
        reEnterPasswordFieldNewUserTap = new javax.swing.JPasswordField();
        permissionCheckBoxNewUserTap = new javax.swing.JCheckBox();
        addUserButtonNewUserTap = new javax.swing.JButton();
        allUsersPanel = new javax.swing.JPanel();
        userNameTextField = new javax.swing.JTextField();
        usernameLabelAllUsers = new javax.swing.JLabel();
        reEnterPasswordLabelAllUsers = new javax.swing.JLabel();
        passwordLabelAllUsers = new javax.swing.JLabel();
        permissionCheckBoxAllUsers = new javax.swing.JCheckBox();
        changeUserButtonAllUsers = new javax.swing.JButton();
        nextUserButton = new javax.swing.JButton();
        previousUserButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startServerButton.setText("Start Server");
        startServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerButtonActionPerformed(evt);
            }
        });

        errorLabel.setText("Error");

        startedServerNotificationLabel.setText("Started");

        serverStopButton.setText("Stop Server");
        serverStopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverStopButtonActionPerformed(evt);
            }
        });

        stoppedServerNotificationLabel.setText("Stopped");

        usernameLabelNewUserTap.setText("Username:");

        usernameTextFieldNewUserTap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldNewUserTapActionPerformed(evt);
            }
        });

        passwordLabelNewUserTap.setText("Password:");

        reEnterPasswordLabelNewUserTap.setText("Re enter password:");

        permissionCheckBoxNewUserTap.setText("permission to crypt cards ");

        addUserButtonNewUserTap.setText("Add User");
        addUserButtonNewUserTap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonNewUserTapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addNewUserPanelLayout = new javax.swing.GroupLayout(addNewUserPanel);
        addNewUserPanel.setLayout(addNewUserPanelLayout);
        addNewUserPanelLayout.setHorizontalGroup(
            addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewUserPanelLayout.createSequentialGroup()
                .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(permissionCheckBoxNewUserTap))
                            .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(reEnterPasswordLabelNewUserTap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reEnterPasswordFieldNewUserTap, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addNewUserPanelLayout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                    .addComponent(usernameLabelNewUserTap)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(usernameTextFieldNewUserTap, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(addNewUserPanelLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(passwordLabelNewUserTap)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(firstPasswordFieldNewUserTap, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(addNewUserPanelLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(addUserButtonNewUserTap)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        addNewUserPanelLayout.setVerticalGroup(
            addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewUserPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabelNewUserTap)
                    .addComponent(usernameTextFieldNewUserTap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabelNewUserTap)
                    .addComponent(firstPasswordFieldNewUserTap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addNewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reEnterPasswordLabelNewUserTap)
                    .addComponent(reEnterPasswordFieldNewUserTap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(permissionCheckBoxNewUserTap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(addUserButtonNewUserTap)
                .addGap(45, 45, 45))
        );

        TabbedPanel.addTab("Add New user", addNewUserPanel);

        usernameLabelAllUsers.setText("Username:");

        reEnterPasswordLabelAllUsers.setText("Re enter password:");

        passwordLabelAllUsers.setText("Password:");

        permissionCheckBoxAllUsers.setText("permission to crypt cards ");
        permissionCheckBoxAllUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionCheckBoxAllUsersActionPerformed(evt);
            }
        });

        changeUserButtonAllUsers.setText("Change User");
        changeUserButtonAllUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUserButtonAllUsersActionPerformed(evt);
            }
        });

        nextUserButton.setText("Next User");
        nextUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextUserButtonActionPerformed(evt);
            }
        });

        previousUserButton.setText("Previous User");
        previousUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousUserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout allUsersPanelLayout = new javax.swing.GroupLayout(allUsersPanel);
        allUsersPanel.setLayout(allUsersPanelLayout);
        allUsersPanelLayout.setHorizontalGroup(
            allUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allUsersPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(permissionCheckBoxAllUsers)
                .addGap(162, 162, 162))
            .addGroup(allUsersPanelLayout.createSequentialGroup()
                .addGroup(allUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(allUsersPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(allUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameLabelAllUsers)
                            .addComponent(reEnterPasswordLabelAllUsers)
                            .addGroup(allUsersPanelLayout.createSequentialGroup()
                                .addComponent(previousUserButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(passwordLabelAllUsers)))
                        .addGap(18, 18, 18)
                        .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(nextUserButton))
                    .addGroup(allUsersPanelLayout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(changeUserButtonAllUsers)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        allUsersPanelLayout.setVerticalGroup(
            allUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allUsersPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(allUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabelAllUsers))
                .addGap(18, 18, 18)
                .addGroup(allUsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabelAllUsers)
                    .addComponent(nextUserButton)
                    .addComponent(previousUserButton))
                .addGap(19, 19, 19)
                .addComponent(reEnterPasswordLabelAllUsers)
                .addGap(18, 18, 18)
                .addComponent(permissionCheckBoxAllUsers)
                .addGap(44, 44, 44)
                .addComponent(changeUserButtonAllUsers)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        TabbedPanel.addTab("All users", allUsersPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(serverStopButton)
                                    .addComponent(stoppedServerNotificationLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startedServerNotificationLabel)
                                    .addComponent(startServerButton)))
                            .addComponent(TabbedPanel))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startServerButton)
                    .addComponent(serverStopButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startedServerNotificationLabel)
                    .addComponent(stoppedServerNotificationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerButtonActionPerformed
        //read all user from the XML file
        Thread temp = new Thread(){
            public void run(){
                try {
                    registratedUsers = XMLManager.loadData(PATH_TO_DATA);
                    showRegistratedUser(registratedUsers.getFirstClient());
                } catch (JAXBException | IOException  ex) {
                    errorLabel.setText(ServerGUIMessages.CANNOT_LOAD_FILE_WITH_USERS.getMessage());
                    errorLabel.setVisible(true);
                    ex.printStackTrace();
                }
            }
        };
        temp.start();   
        try {
            temp.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            errorLabel.setText(ServerGUIMessages.CANNOT_LOAD_FILE_WITH_USERS.getMessage());
            errorLabel.setVisible(true);
        }
        
        errorLabel.setVisible(false);
        setEnableFields(true);
        this.startServerThread = new Thread() {
            @Override
            public void run() {
                try {
                    server.start();
                } catch (IOException ex) {
                    Logger.getLogger(serverForm.class.getName()).log(Level.SEVERE, null, ex);
                    errorLabel.setText(ServerGUIMessages.ERROR_STARTING_SERVER.getMessage());
                    errorLabel.setVisible(true);
                    startServerButton.setEnabled(false);
                }
            }
        };
        this.startServerThread.start();

        startServerButton.setEnabled(false);
        serverStopButton.setEnabled(true);
        startedServerNotificationLabel.setText(ServerGUIMessages.SERVER_IS_STARTED.getMessage());
        startedServerNotificationLabel.setVisible(true);
        stoppedServerNotificationLabel.setVisible(false);
    }//GEN-LAST:event_startServerButtonActionPerformed

    private void serverStopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverStopButtonActionPerformed
        setEnableFields(false);
        try {
            this.startServerThread.setDaemon(true);
            server.stop();
        } catch (IOException ex) {
            ex.printStackTrace();
        }catch (IllegalThreadStateException e){
        }
        startServerButton.setEnabled(true);
        serverStopButton.setEnabled(false);
        startedServerNotificationLabel.setVisible(false);
        stoppedServerNotificationLabel.setText(ServerGUIMessages.SERVER_IS_STOPPED.getMessage());
        stoppedServerNotificationLabel.setVisible(true);
        
    }//GEN-LAST:event_serverStopButtonActionPerformed

    private void changeUserButtonAllUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserButtonAllUsersActionPerformed
        errorLabel.setVisible(false);
        if (validator(userNameTextField, RegularExpressions.VALIDATE_USERNAME.getRegex(), ServerGUIMessages.WRONG_FORMAT_USERNAME.getMessage())) {
            Thread temp = new Thread(){
                public void run(){
                    registratedUsers.getCurrentClient().setPermissionForCrypt(permissionCheckBoxAllUsers.isSelected());
                    try {
                        XMLManager.parceToXMLString(registratedUsers, PATH_TO_DATA);
                    } catch (JAXBException ex) {
                        ex.printStackTrace();
                        errorLabel.setText(ServerGUIMessages.ERROR_SAVING_CHANGES.getMessage());
                        errorLabel.setVisible(true);
                    } catch (FileNotFoundException ex) {
                        errorLabel.setText(ServerGUIMessages.CANNOT_FIND_FILE_TO_SAVE.getMessage());
                        errorLabel.setVisible(true);
                        ex.printStackTrace();
                    }
                }
            };
            temp.start();
            try {
                temp.join();
            } catch (InterruptedException ex) {
                errorLabel.setText(ServerGUIMessages.ERROR_SAVING_CHANGES.getMessage());
                errorLabel.setVisible(true);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_changeUserButtonAllUsersActionPerformed

    private void addUserButtonNewUserTapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonNewUserTapActionPerformed
        errorLabel.setVisible(false);
        if (!validator(usernameTextFieldNewUserTap, RegularExpressions.VALIDATE_USERNAME.getRegex(), ServerGUIMessages.WRONG_FORMAT_USERNAME.getMessage())) {
            return;
        }
        if (!validator(firstPasswordFieldNewUserTap, RegularExpressions.VALIDATE_PASSWORD.getRegex(), ServerGUIMessages.WRONG_FORMAT_PASSWORD.getMessage())) {
            return;
        }
        if (!firstPasswordFieldNewUserTap.getText().equals(reEnterPasswordFieldNewUserTap.getText())) {
            errorLabel.setText(ServerGUIMessages.PASSWORDS_NOT_MATCH.getMessage());
            errorLabel.setVisible(true);
            return;
        }
        
        registratedUsers.addClient(usernameTextFieldNewUserTap.getText(), firstPasswordFieldNewUserTap.getText(), permissionCheckBoxNewUserTap.isSelected());
        
        Thread temp = new Thread(){
                public void run(){
                    try {
                        XMLManager.parceToXMLString(registratedUsers, PATH_TO_DATA);
                    } catch (JAXBException ex) {
                        ex.printStackTrace();
                        errorLabel.setText(ServerGUIMessages.ERROR_SAVING_CHANGES.getMessage());
                        errorLabel.setVisible(true);
                    } catch (FileNotFoundException ex) {
                        errorLabel.setText(ServerGUIMessages.CANNOT_FIND_FILE_TO_SAVE.getMessage());
                        errorLabel.setVisible(true);
                        ex.printStackTrace();
                    }
                }
            };
            temp.start();
            try {
                temp.join();
            } catch (InterruptedException ex) {
                errorLabel.setText(ServerGUIMessages.ERROR_SAVING_CHANGES.getMessage());
                errorLabel.setVisible(true);
                ex.printStackTrace();
            }
    }//GEN-LAST:event_addUserButtonNewUserTapActionPerformed

    private void usernameTextFieldNewUserTapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldNewUserTapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldNewUserTapActionPerformed

    private void permissionCheckBoxAllUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionCheckBoxAllUsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permissionCheckBoxAllUsersActionPerformed

    private void nextUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextUserButtonActionPerformed
        showRegistratedUser(registratedUsers.getNextClient());
    }//GEN-LAST:event_nextUserButtonActionPerformed

    private void previousUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousUserButtonActionPerformed
        showRegistratedUser(registratedUsers.getPreviousClient());
    }//GEN-LAST:event_previousUserButtonActionPerformed

    private void showRegistratedUser(Client client){
        userNameTextField.setText(client.getUsername());
        permissionCheckBoxAllUsers.setSelected(client.isPermissionForCrypt());
    }
    
    private void setEnableFields(boolean choise){
        this.TabbedPanel.setEnabled(choise);
        
        this.usernameLabelNewUserTap.setEnabled(choise);
        this.passwordLabelNewUserTap.setEnabled(choise);
        this.reEnterPasswordLabelNewUserTap.setEnabled(choise);
        
        this.userNameTextField.setEnabled(choise);
        this.firstPasswordFieldNewUserTap.setEnabled(choise);
        this.reEnterPasswordFieldNewUserTap.setEnabled(choise);
        this.addUserButtonNewUserTap.setEnabled(choise);
        this.permissionCheckBoxNewUserTap.setEnabled(choise);
        
        this.usernameLabelAllUsers.setEnabled(choise);
        this.passwordLabelAllUsers.setEnabled(choise);
        this.reEnterPasswordLabelAllUsers.setEnabled(choise);
        
        this.usernameTextFieldNewUserTap.setEnabled(choise);
        this.changeUserButtonAllUsers.setEnabled(choise);
        this.permissionCheckBoxAllUsers.setEnabled(choise);
    }

      private boolean validator(JTextField field, String regex, String massage) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(field.getText());
        if (!matcher.matches()) {
            errorLabel.setText(massage);
            errorLabel.setVisible(true);
        }
        return matcher.matches();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPanel;
    private javax.swing.JPanel addNewUserPanel;
    private javax.swing.JButton addUserButtonNewUserTap;
    private javax.swing.JPanel allUsersPanel;
    private javax.swing.JButton changeUserButtonAllUsers;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JPasswordField firstPasswordFieldNewUserTap;
    private javax.swing.JButton nextUserButton;
    private javax.swing.JLabel passwordLabelAllUsers;
    private javax.swing.JLabel passwordLabelNewUserTap;
    private javax.swing.JCheckBox permissionCheckBoxAllUsers;
    private javax.swing.JCheckBox permissionCheckBoxNewUserTap;
    private javax.swing.JButton previousUserButton;
    private javax.swing.JPasswordField reEnterPasswordFieldNewUserTap;
    private javax.swing.JLabel reEnterPasswordLabelAllUsers;
    private javax.swing.JLabel reEnterPasswordLabelNewUserTap;
    private javax.swing.JButton serverStopButton;
    private javax.swing.JButton startServerButton;
    private javax.swing.JLabel startedServerNotificationLabel;
    private javax.swing.JLabel stoppedServerNotificationLabel;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel usernameLabelAllUsers;
    private javax.swing.JLabel usernameLabelNewUserTap;
    private javax.swing.JTextField usernameTextFieldNewUserTap;
    // End of variables declaration//GEN-END:variables
}
