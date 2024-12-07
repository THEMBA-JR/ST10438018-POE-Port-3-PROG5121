/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class User {
     private static final Map<String, String[]> userData = new HashMap<>();

    public static void registerUser() {
        String user = JOptionPane.showInputDialog("Create a Username:");
        while (user == null || user.trim().isEmpty() || userData.containsKey(user)) {
            if (userData.containsKey(user)) {
                user = JOptionPane.showInputDialog("This username is taken. Please choose a new one:");
            } else {
                user = JOptionPane.showInputDialog("Username cannot be empty. Please try again:");
            }
        }

        String fname = JOptionPane.showInputDialog("Enter Your First Name:");
        while (fname == null || fname.trim().isEmpty()) {
            fname = JOptionPane.showInputDialog("First Name cannot be empty. Enter again:");
        }

        String lname = JOptionPane.showInputDialog("Enter Your Last Name:");
        while (lname == null || lname.trim().isEmpty()) {
            lname = JOptionPane.showInputDialog("Last Name cannot be empty. Enter again:");
        }

        String pass = JOptionPane.showInputDialog("Create a Password:");
        while (pass == null || pass.trim().isEmpty()) {
            pass = JOptionPane.showInputDialog("Password cannot be empty. Try again:");
        }

        userData.put(user, new String[]{fname, lname, pass});
        JOptionPane.showMessageDialog(null, "Registration complete! You can now log in.");
    }

    public static String[] signInUser() {
        if (userData.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No registered users found. Please register first.");
            return null;
        }

        String user = JOptionPane.showInputDialog("Enter Username:");
        String pass = JOptionPane.showInputDialog("Enter Password:");

        if (userData.containsKey(user) && userData.get(user)[2].equals(pass)) {
            return userData.get(user); // Return user details if login is successful
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect username or password. Please try again.");
            return null;
        }
    }
}
