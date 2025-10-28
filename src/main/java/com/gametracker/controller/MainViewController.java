package com.gametracker.controller;

import com.gametracker.MainApp;
import com.gametracker.model.CollectionItem;
import com.gametracker.model.Game;
import com.gametracker.model.Platform;
import com.gametracker.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainViewController {

    // --- References to other classes ---
    private MainApp mainApp;
    private User loggedInUser;

    // --- FXML UI Components ---

    @FXML
    private Label welcomeLabel;

    @FXML
    private Tab collectionTab;

    @FXML
    private TableView<CollectionItem> collectionTable;

    @FXML
    private TableColumn<CollectionItem, String> gameTitleColumn;

    @FXML
    private TableColumn<CollectionItem, String> platformColumn;

    @FXML
    private TableColumn<CollectionItem, String> statusColumn;

    @FXML
    private TableColumn<CollectionItem, String> purchaseDateColumn;

    @FXML
    private TableColumn<CollectionItem, Double> priceColumn;

    @FXML
    private Tab gamesTab;

    @FXML
    private TableView<Game> gameTable;

    @FXML
    private TableColumn<Game, String> titleColumn;

    @FXML
    private TableColumn<Game, String> genreColumn;

    @FXML
    private TableColumn<Game, String> developerColumn;

    @FXML
    private TableColumn<Game, String> publisherColumn;

    @FXML
    private TableColumn<Game, String> releaseDateColumn;

    @FXML
    private Tab platformsTab;

    @FXML
    private TableView<Platform> platformTable;

    @FXML
    private TableColumn<Platform, String> platformNameColumn;

    @FXML
    private TableColumn<Platform, String> manufacturerColumn;

    @FXML
    private TableColumn<Platform, Integer> platformReleaseYearColumn;

    // --- Initialization and Setup ---

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     */
    @FXML
    private void initialize() {
        // TODO: Initialize your TableView columns here
        // Example:
        // gameTitleColumn.setCellValueFactory(cellData -> cellData.getValue().gameProperty().get().titleProperty());
        // platformColumn.setCellValueFactory(cellData -> cellData.getValue().platformProperty().get().nameProperty());
        // ... and so on for all columns
        
        // TODO: Call methods to load data into the tables
        // loadCollectionData();
        // loadGamesData();
        // loadPlatformsData();
    }

    /**
     * Is called by the MainApp to give a reference back to itself.
     * This is the method that was missing.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Is called by the MainApp to set the currently logged-in user.
     * This is the other method that was missing.
     * * @param user
     */
    public void setLoggedInUser(User user) {
        this.loggedInUser = user;
        // Now we can set the welcome message
        welcomeLabel.setText("Welcome, " + user.getUsername() + "!");
    }

    // --- FXML Event Handlers ---

    /**
     * Called when the user clicks the Logout button.
     */
    @FXML
    private void handleLogoutButton() {
        // Clear the logged-in user and show the login screen
        this.loggedInUser = null;
        mainApp.showLoginView();
    }
    
    /**
     * Called when the user clicks the "Add" button on the Collection tab.
     */
    @FXML
    private void handleAddCollectionItem() {
        System.out.println("Add collection item clicked...");
        // TODO: Open a dialog to add a new collection item
    }

    /**
     * Called when the user clicks the "Edit" button on the Collection tab.
     */
    @FXML
    private void handleEditCollectionItem() {
        System.out.println("Edit collection item clicked...");
        // TODO: Open a dialog to edit the selected collection item
    }

    /**
     * Called when the user clicks the "Delete" button on the Collection tab.
     */
    @FXML
    private void handleDeleteCollectionItem() {
        System.out.println("Delete collection item clicked...");
        // TODO: Delete the selected collection item from the database
    }

    // --- Data Loading Methods ---

    /**
     * Fetches data from the database and populates the Collection table.
     */
    private void loadCollectionData() {
        // TODO:
        // 1. Create a CollectionItemDAO class.
        // 2. Call a method like: collectionItemDAO.getCollectionForUser(loggedInUser.getUserId())
        // 3. Put the results into an ObservableList.
        // 4. Set the list to the table: collectionTable.setItems(observableList);
    }
    
    // Add similar methods for loadGamesData() and loadPlatformsData()
}

