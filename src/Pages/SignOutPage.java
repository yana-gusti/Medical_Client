/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import static Pages.SignInPage.signOutPage;
import static medical.client.Main.signInPage;
import services.DBConnection;
import services.UserServices;
import services.Users;

/**
 *
 * @author iRoma
 */
public class SignOutPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */
    public SignOutPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        firstName = new javax.swing.JTextField();
        confirmPass = new javax.swing.JTextField();
        signOut = new javax.swing.JButton();
        lastName = new javax.swing.JTextField();
        birthday = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();
        email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        MainPanel.setBackground(new java.awt.Color(204, 255, 204));

        firstName.setForeground(new java.awt.Color(153, 153, 153));
        firstName.setText("Ім'я");
        firstName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstNameMouseClicked(evt);
            }
        });

        confirmPass.setForeground(new java.awt.Color(153, 153, 153));
        confirmPass.setText("Підтвердження паролю");
        confirmPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmPassMouseClicked(evt);
            }
        });
        confirmPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassActionPerformed(evt);
            }
        });

        signOut.setText("Реєстрація");
        signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutActionPerformed(evt);
            }
        });

        lastName.setForeground(new java.awt.Color(153, 153, 153));
        lastName.setText("Прізвище");
        lastName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lastNameMouseClicked(evt);
            }
        });
        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });

        birthday.setForeground(new java.awt.Color(153, 153, 153));
        birthday.setText("Дата народження");
        birthday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                birthdayMouseClicked(evt);
            }
        });
        birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayActionPerformed(evt);
            }
        });

        pass.setForeground(new java.awt.Color(153, 153, 153));
        pass.setText("Пароль");
        pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passMouseClicked(evt);
            }
        });
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        cancel.setText("Відмінити");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/9.png"))); // NOI18N

        email.setForeground(new java.awt.Color(153, 153, 153));
        email.setText("Email");
        email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                emailMouseClicked(evt);
            }
        });
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(errorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(confirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(birthday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(268, 268, 268))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassActionPerformed

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameActionPerformed

    private void birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdayActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void firstNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstNameMouseClicked
        firstName.setText("");
    }//GEN-LAST:event_firstNameMouseClicked

    private void lastNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastNameMouseClicked
        lastName.setText("");
    }//GEN-LAST:event_lastNameMouseClicked

    private void birthdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_birthdayMouseClicked
        birthday.setText("");
    }//GEN-LAST:event_birthdayMouseClicked

    private void passMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passMouseClicked
        pass.setText("");
    }//GEN-LAST:event_passMouseClicked

    private void confirmPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPassMouseClicked
        confirmPass.setText("");
    }//GEN-LAST:event_confirmPassMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        signOutPage.setVisible(false); 
        signInPage.setVisible(true);
        
    }//GEN-LAST:event_cancelActionPerformed

    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        String first_name = firstName.getText();
        String last_name = lastName.getText();
        String e_mail = email.getText();
        String password = pass.getText();
        String pass_confirm = confirmPass.getText();
        String birth_day = birthday.getText();
        
        Users user=null;
        if(first_name!=null && last_name!=null && e_mail!=null && password!=null && pass_confirm!=null){
        if(password.equals(pass_confirm)){
        user = new Users(null, first_name, last_name, birth_day, e_mail, password);
            UserServices.addUser(user);
        System.out.println("user was added");
        signOutPage.setVisible(false);
        signInPage = new SignInPage();
        signInPage.setVisible(true);
        }else{
            errorLabel.setText("Пароль не співпадає з підтвердженням паролю!");
        }
        }else{
            errorLabel.setText("Всі поля обов'язкові для заповнення!");
        }
        
    }//GEN-LAST:event_signOutActionPerformed

    private void emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_emailMouseClicked

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignOutPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignOutPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignOutPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignOutPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignOutPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    public javax.swing.JTextField birthday;
    public javax.swing.JButton cancel;
    public javax.swing.JTextField confirmPass;
    public javax.swing.JTextField email;
    public javax.swing.JLabel errorLabel;
    public javax.swing.JTextField firstName;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField lastName;
    public javax.swing.JTextField pass;
    public javax.swing.JButton signOut;
    // End of variables declaration//GEN-END:variables
}
