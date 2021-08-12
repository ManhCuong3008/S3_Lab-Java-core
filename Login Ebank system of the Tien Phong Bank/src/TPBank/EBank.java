/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TPBank;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author asus
 */
public class EBank {

    private static final Scanner SC = new Scanner(System.in);
    // show menu 
    public static void showMenu() {
        System.out.println("------Login Program------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
    }

    public static int getChoice(Locale language, int min, int max) {
        int number;
        while (true) {
            System.out.println("Please choice one options: ");
            try {
                number = Integer.parseInt(SC.nextLine());
                if (number < min || number > max) {
                    System.out.println("Number out of range, enter number in range [" + min + "-" + max + "]");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                getMessageLanguage(language, "errorCheckInputIntLimit");
            }
        }
    }

    private static void getMessageLanguage(Locale language, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("Language/" + language, language);
        String message = bundle.getString(key);
        System.out.println(message);
    }

    private static String getAccountNumber(Locale language) {
        String accountNumber = "";
        while (true) {
            accountNumber = SC.nextLine();
            if (accountNumber.trim().isEmpty()) {
                getMessageLanguage(language, "errCheckInputAccountEmpty");
                continue;
            }
            if (!accountNumber.matches("^\\d{10}$")) {
                getMessageLanguage(language, "errCheckInputAccount");
                continue;
            }
            return accountNumber;
        }
    }

    private static String getPassowrd(Locale language) {
        String password = "";
        while (true) {
            password = SC.nextLine();
            // check if password empty
            if (password.trim().isEmpty()) {
                getMessageLanguage(language, "errCheckInputPasswordEmpty");
                continue;
            }
            Pattern p = Pattern.compile("^[0-9a-zA-Z]{8,31}$");
            Pattern pDigit = Pattern.compile("^[0-9a-zA-Z]*[0-9]+[0-9a-zA-Z]*$");
            Pattern pAlpha = Pattern.compile("^[0-9a-zA-Z]*[a-zA-Z]+[0-9a-zA-Z]*$");
            // check if lenght of password less 8 character or more 31 character
            if (p.matcher(password).find()) {
                // check if password has least one character is digit and alpha
                if (pDigit.matcher(password).find() && pAlpha.matcher(password).find()) {
                    return password;
                } else {
                    getMessageLanguage(language, "errCheckAlphanumericPassword");
                }
            } else {
                getMessageLanguage(language, "errCheckLengthPassword");
            }
        }
    }

    private static String generateCaptcha() {
        String alphanumeric = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String captcha = new String();
        Random rd = new Random();
        for (int i = 0; i < 6; i++) {
            captcha += alphanumeric.charAt(rd.nextInt(alphanumeric.length() - 1)) + "";
        }
        return captcha;
    }

    private static boolean checkCaptcha(Locale language, String captchaGenerate) {
        getMessageLanguage(language, "enterCaptcha");
        String captcha = SC.nextLine();
        if (captcha.trim().isEmpty()) {
            getMessageLanguage(language, "errCaptchaEmpty");
            return false;
        }
        for (int i = 0; i < captcha.length(); i++) {
            if (!captchaGenerate.contains(captcha.charAt(i) + "")) {
                getMessageLanguage(language, "errCaptchaIncorrect");
                return false;
            }
        }
        return true;
    }

    public static void login(Locale language) {
        Map<String, String> listAccount = new HashMap<String, String>();
        listAccount.put("0123456789", "123456ab");
        listAccount.put("999999999", "sieunhangao20");
        getMessageLanguage(language, "enterAccountNumber");
        String accountNumber = getAccountNumber(language);
        getMessageLanguage(language, "enterPassword");
        String password = getPassowrd(language);
        String tempCaptcha = generateCaptcha();
        System.out.println("Captcha:" + tempCaptcha);
        while (true) {
            if (checkCaptcha(language, tempCaptcha)) {
                // check if account exist in list data
                if (listAccount.get(accountNumber) != null) {
                    if (listAccount.get(accountNumber).equals(password)) {
                        getMessageLanguage(language,"loginSuccess");
                        break;
                    } else {
                        getMessageLanguage(language,"loginFail");
                        break;
                    }
                } else {
                    getMessageLanguage(language,"loginFail");
                    break;
                }
            }
        }
    }
}
