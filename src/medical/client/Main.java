/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medical.client;

import Pages.SignInPage;

/**
 *
 * @author iRoma
 */
public class Main {
    public static SignInPage signInPage;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        signInPage = new SignInPage();
        signInPage.setVisible(true);
    }
    
}
