/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Utils.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Henrique
 */
public class UpdateUser extends javax.swing.JFrame {
    
    int id;
    
    public UpdateUser(String[] values) {
        initComponents();
        
        id = Integer.parseInt(values[0]);
        UpdateLabel.setText("Update book " + values[1]);
        NameTextField.setText(values[1]);
        EmailTextField.setText(values[2]);
        PasswordTextField.setText(values[3]);
        ProfileComboBox.setSelectedItem(values[4]);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InsertPanel = new javax.swing.JPanel();
        UpdateLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        EmailTextField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JTextField();
        ProfileLabel = new javax.swing.JLabel();
        ProfileComboBox = new javax.swing.JComboBox<>();
        ProfileHelpLabel = new javax.swing.JLabel();
        ApplyButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UpdateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UpdateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UpdateLabel.setText("Update user");

        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameLabel.setText("Name");

        EmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        EmailLabel.setText("Email");

        PasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PasswordLabel.setText("Password");

        ProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ProfileLabel.setText("Profile");

        ProfileComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "5" }));

        ProfileHelpLabel.setText("1 - Client, 5 - Admin");

        ApplyButton.setText("Apply");
        ApplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InsertPanelLayout = new javax.swing.GroupLayout(InsertPanel);
        InsertPanel.setLayout(InsertPanelLayout);
        InsertPanelLayout.setHorizontalGroup(
            InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertPanelLayout.createSequentialGroup()
                .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InsertPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmailLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PasswordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProfileLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(InsertPanelLayout.createSequentialGroup()
                                .addComponent(ApplyButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
                                .addComponent(CancelButton))
                            .addComponent(NameTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PasswordTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmailTextField)
                            .addGroup(InsertPanelLayout.createSequentialGroup()
                                .addComponent(ProfileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ProfileHelpLabel)))))
                .addContainerGap())
        );
        InsertPanelLayout.setVerticalGroup(
            InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertPanelLayout.createSequentialGroup()
                .addComponent(UpdateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ProfileLabel)
                    .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ProfileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProfileHelpLabel)))
                .addGap(18, 18, 18)
                .addGroup(InsertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ApplyButton)
                    .addComponent(CancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InsertPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InsertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        Utils.OpenNewWindow(new Users(), this);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void ApplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyButtonActionPerformed
        String name = NameTextField.getText();
        String email = EmailTextField.getText();
        String password = PasswordTextField.getText();
        String profile = (String) ProfileComboBox.getSelectedItem();

        String[] data = {name, email, password, profile};
        
        if(name.equals("") || email.equals("") || password.equals("") || profile.equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields", "All fields are required", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(Utils.ModifyUser(id, data)) {
            JOptionPane.showMessageDialog(null, "Registry updated successfully!", "", JOptionPane.INFORMATION_MESSAGE);
            Utils.OpenNewWindow(new Users(), this);
        } else {
            JOptionPane.showMessageDialog(null, "There was an error!", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ApplyButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApplyButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JPanel InsertPanel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JTextField PasswordTextField;
    private javax.swing.JComboBox<String> ProfileComboBox;
    private javax.swing.JLabel ProfileHelpLabel;
    private javax.swing.JLabel ProfileLabel;
    private javax.swing.JLabel UpdateLabel;
    // End of variables declaration//GEN-END:variables
}
