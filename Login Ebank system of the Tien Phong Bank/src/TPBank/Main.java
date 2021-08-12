/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPBank;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author asus
 */
public class Main {

    public static void main(String[] args) {
        Locale vietnamese = new Locale("vi");
        Locale english = new Locale("en");
        int yourChoice;
        // loop until user want to exit
        while (true) {
            EBank.showMenu();
            yourChoice = EBank.getChoice(english, 1, 3);
            switch (yourChoice) {
                case 1:
                    EBank.login(vietnamese);
                    break;
                case 2:
                    EBank.login(english);
                    break;
                case 3:
                    return;
            }
        }
    }
    
}
