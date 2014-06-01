/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import static Pages.ProfilePage.changeGraphicPage;
import static Pages.SignInPage.signOutPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static medical.client.Main.signInPage;
import services.DBConnection;
import services.Graphic;
import services.UserServices;
import services.Users;

/**
 *
 * @author iRoma
 */
public class ChangeGraphicPage extends javax.swing.JFrame {
    public static ProfilePage profilePage;

    /**
     * Creates new form LoginPage
     */
    public ChangeGraphicPage() {
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
        monday = new javax.swing.JTextField();
        createBtn = new javax.swing.JButton();
        tuesday = new javax.swing.JTextField();
        wednesday = new javax.swing.JTextField();
        friday = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        thursday = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        MainPanel.setBackground(new java.awt.Color(204, 255, 204));

        monday.setForeground(new java.awt.Color(153, 153, 153));
        monday.setText("Понеділок");
        monday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mondayMouseClicked(evt);
            }
        });

        createBtn.setText("Створити");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        tuesday.setForeground(new java.awt.Color(153, 153, 153));
        tuesday.setText("Вівторок");
        tuesday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tuesdayMouseClicked(evt);
            }
        });
        tuesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesdayActionPerformed(evt);
            }
        });

        wednesday.setForeground(new java.awt.Color(153, 153, 153));
        wednesday.setText("Середа");
        wednesday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wednesdayMouseClicked(evt);
            }
        });
        wednesday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesdayActionPerformed(evt);
            }
        });

        friday.setForeground(new java.awt.Color(153, 153, 153));
        friday.setText("П'ятниця");
        friday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fridayMouseClicked(evt);
            }
        });
        friday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fridayActionPerformed(evt);
            }
        });

        cancel.setText("Відмінити");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/9.png"))); // NOI18N

        thursday.setForeground(new java.awt.Color(153, 153, 153));
        thursday.setText("Четвер");
        thursday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thursdayMouseClicked(evt);
            }
        });
        thursday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursdayActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                            .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tuesday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(friday, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(wednesday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(thursday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(errorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(monday, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(wednesday, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(thursday, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(friday, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tuesdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuesdayActionPerformed

    private void wednesdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wednesdayActionPerformed

    private void fridayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fridayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fridayActionPerformed

    private void mondayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mondayMouseClicked
        monday.setText("");
    }//GEN-LAST:event_mondayMouseClicked

    private void tuesdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tuesdayMouseClicked
        tuesday.setText("");
    }//GEN-LAST:event_tuesdayMouseClicked

    private void wednesdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wednesdayMouseClicked
        wednesday.setText("");
    }//GEN-LAST:event_wednesdayMouseClicked

    private void fridayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fridayMouseClicked
        friday.setText("");
    }//GEN-LAST:event_fridayMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        signOutPage.setVisible(false); 
        signInPage.setVisible(true);
        
    }//GEN-LAST:event_cancelActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        String mon = monday.getText();
        String tue = tuesday.getText();
        String thu = thursday.getText();
        String fri = friday.getText();
        String wed = wednesday.getText();
        String userName=SignInPage.user.getE_mail();
        ArrayList<String> array= DBConnection.getAllUserName();
        System.out.println(array);
        if(array.contains(userName)){
            DBConnection.UpdateGraphic(mon, tue, wed, thu, fri);
        }else{
        Graphic graph=null;
        if(mon!=null && tue!=null && wed!=null && thu!=null && fri!=null ){
        
        graph = new Graphic(null, null, mon, tue, wed, thu, fri);
        
            UserServices.addGraphic(graph);
        
        
        }else{
            errorLabel.setText("Всі поля обов'язкові для заповнення!");
        }
        System.out.println("graphic was added");
        }
        changeGraphicPage.setVisible(false);
        profilePage = new ProfilePage();
        profilePage.setVisible(true);
       
        

    }//GEN-LAST:event_createBtnActionPerformed

    private void thursdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thursdayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_thursdayMouseClicked

    private void thursdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thursdayActionPerformed

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
            java.util.logging.Logger.getLogger(ChangeGraphicPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeGraphicPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeGraphicPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeGraphicPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeGraphicPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    public javax.swing.JButton cancel;
    public javax.swing.JButton createBtn;
    public javax.swing.JLabel errorLabel;
    public javax.swing.JTextField friday;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField monday;
    public javax.swing.JTextField thursday;
    public javax.swing.JTextField tuesday;
    public javax.swing.JTextField wednesday;
    // End of variables declaration//GEN-END:variables
}
