/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prld.poe;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class PRLDPOE {

    /**
     * @param args the command line arguments
     */
   public static boolean isLoggedIn = false;
    public static boolean loginUser = false;

    public static void main(String[] args) {
        boolean OkUsername = false;
        boolean OkPassword = false;
        String username = "";
        String password = "";
        String name;
        String surname;

        Scanner scan = new Scanner(System.in);

        System.out.println("enter your name:");
        name = scan.nextLine();
        System.out.println("enter your surname:");
        surname = scan.nextLine();

        // Loop until a valid username is entered
        while (!OkUsername) {
            System.out.println("Input a username (no longer than 5 characters with an underscore): ");
            username = scan.nextLine();
            OkUsername = CheckUserName(username);
            if (!OkUsername) {
                System.out.println("Invalid username. Please try again.");
            }
        }

        // Loop until a valid password is entered
        while (!OkPassword) {
            System.out.println("Input a password with CapitalLetter, SpecialCharacter, Number and is no less than 8 chracters: ");
            password = scan.nextLine();
            OkPassword = checkPasswordComplexity(password);
            if (!OkPassword) {
                System.out.println("Invalid password. Please try again.");
            }
        }

        registerUser(OkUsername, OkPassword);
        System.out.println("Login phase");
        loginUser(name, surname, password, username);

        isLoggedIn(loginUser);
    }

    public static boolean CheckUserName(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkPasswordComplexity(String password) {
        boolean num = false;
        boolean capitalLetter = false;
        boolean special = false;
        String specialCharacters = "!@#$%^&*( )-+=_{}[]:<>?/";

        if (password.length() <= 7) {
            System.out.println("password too short");
            return false;
        }

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                num = true;
            }
            if (Character.isUpperCase(c)) {
                capitalLetter = true;
            }
            if (specialCharacters.contains(String.valueOf(c))) {
                special = true;
            }
        }

        if (num && capitalLetter && special) {
            return true;
        } else {
            return false;
        }
    }

    public static void registerUser(boolean OkUsername, boolean OkPassword) {
        if (OkUsername && OkPassword) {
            System.out.println("User successfully registered.");
        } else {
            System.out.println("Registration failed. Please check username and password.");
        }
    }

    public static boolean loginUser(String name, String surname, String password, String username) {
        Scanner scan = new Scanner(System.in);
        String inputUsername;
        String inputPassword;

        System.out.println("Enter username:");
        inputUsername = scan.nextLine();
        System.out.println("Enter password:");
        inputPassword = scan.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            loginUser = true;
            System.out.println("welcome " + name + " " + surname);
        } else {
            System.out.println("Incorrect username or password.");
        }
        return loginUser;
    }

    public static boolean isLoggedIn(boolean log) {
        if (log) {
            System.out.println("User is logged in.");
            isLoggedIn = true;
        } else {
            System.out.println("User loggin failed.");
        }
        return isLoggedIn;
    }
}
