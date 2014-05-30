/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

/**
 *
 * @author iRoma
 */
import java.awt.*; 
import java.awt.event.*; 
import java.io.File;
import java.io.IOException;
import javax.swing.*; 


public class OpenFile extends JFrame implements ActionListener{ 

private JButton open; 

OpenFile (){ 
super(); 
setSize(400,300); 
setVisible(true); 
setDefaultCloseOperation(EXIT_ON_CLOSE); 
setLayout(new FlowLayout()); 

open = new JButton("OPEN"); 
add(open); 
open.addActionListener(this); 
validate(); 

} 

public void actionPerformed(ActionEvent ae){ 

try { 
Process p=Runtime.getRuntime().exec("C://downloadJSP//qqq.doc" ); //enter file path 

} catch (Exception e) { 
// TODO Auto-generated catch block	
e.printStackTrace(); 
} 

} 

public static void main(String args[]){ 
try {
     if (Desktop.isDesktopSupported()) {
       Desktop.getDesktop().open(new File("C://downloadJSP//qqq.doc"));
     }
   } catch (IOException ioe) {
     ioe.printStackTrace();
  }
} 

} 