/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import Model.UserDAO;
import View.LoginView;
import javax.swing.JOptionPane;

public class LoginController {

    private LoginView view;
    private UserDAO userDAO;

    public LoginController() {
        this.userDAO = new UserDAO();
    }

    public LoginController(LoginView view) {
        this.view = view;
        this.userDAO = new UserDAO();
    }

    public void authenticateUser() {
        if (view == null) return;

        String username = view.getUsername();
        String password = view.getPassword();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please enter all fields!");
            return;
        }

        User user = userDAO.checkLogin(username, password);

        if (user != null) {
            JOptionPane.showMessageDialog(view, "Login Successful! Role: " + user.getRole());

            if (user.getRole().equalsIgnoreCase("Manager")) {
                new View.ManagerDashboard().setVisible(true);
            } else if (user.getRole().equalsIgnoreCase("Cashier")) {
                new View.CashierDashboard().setVisible(true);
            }
            view.dispose();
        } else {
            JOptionPane.showMessageDialog(view, "Invalid Username or Password!");
        }
    }

    public boolean registerUser(String username, String password, String role) {
        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }
        
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setRole(role);

        return userDAO.addUser(newUser);
    }
}