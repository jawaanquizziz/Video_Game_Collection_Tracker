package com.gametracker;

import com.gametracker.controller.LoginViewController;
import com.gametracker.controller.MainViewController;
import com.gametracker.db.DatabaseUtil;
import com.gametracker.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private Scene loginScene;
    private Scene mainScene;
    
    private User loggedInUser;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Video Game Collection Tracker");

        // First, test the database connection
        DatabaseUtil.testConnection();

        // Load and show the login view first
        showLoginView();
    }

    /**
     * Loads and displays the Login screen.
     */
    public void showLoginView() {
        try {
            // Load the login FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/gametracker/view/LoginView.fxml"));
            Parent root = loader.load();
            
            // Give the controller a reference to this MainApp
            LoginViewController controller = loader.getController();
            controller.setMainApp(this);

            loginScene = new Scene(root);
            // Apply the stylesheet
            loginScene.getStylesheets().add(getClass().getResource("/com/gametracker/view/styles.css").toExternalForm());
            
            primaryStage.setScene(loginScene);
            primaryStage.setTitle("Game Tracker Login");
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Failed to load LoginView.fxml");
            e.printStackTrace();
        }
    }
    
    /**
     * Loads and displays the Main application view after successful login.
     * @param user The user who has logged in.
     */
    public void showMainView(User user) {
        this.loggedInUser = user;
        try {
            // Load the main FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/gametracker/view/MainView.fxml"));
            Parent root = loader.load();
            
            // Give the controller a reference to this MainApp and the logged-in user
            MainViewController controller = loader.getController();
            controller.setMainApp(this);
            controller.setLoggedInUser(user);
            
            mainScene = new Scene(root);
            // Apply the stylesheet
            mainScene.getStylesheets().add(getClass().getResource("/com/gametracker/view/styles.css").toExternalForm());
            
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Video Game Collection Tracker");
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Failed to load MainView.fxml");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during startup.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

