package com.gametracker.controller;

import com.gametracker.MainApp;
import com.gametracker.model.User;
import com.gametracker.db.UserDAO; // Make sure UserDAO.java exists in the db package

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class LoginViewController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;

    private MainApp mainApp;
    private UserDAO userDAO; // This declaration will now work

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     */
    @FXML
    private void initialize() {
        // Now we can create the UserDAO
        this.userDAO = new UserDAO();
        errorLabel.setVisible(false);
    }

    /**
     * Sets the main application instance. This is called by MainApp.
     * @param mainApp the main application
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Called when the user clicks the login button.
     */
    @FXML
    private void handleLoginButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showError("Username and password are required.");
            return;
        }
        
        // --- This is the REAL database login code ---
        try {
            User user = userDAO.validateLogin(username, password);
            if (user != null) {
                // Login successful
                mainApp.showMainView(user);
            } else {
                // Login failed
                showError("Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showError("Database error. Please try again.");
        }
    }

    /**
     * Helper method to display an error message on the login screen.
     * @param message The error message to display.
     */
    private void showError(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
}

