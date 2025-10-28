package com.gametracker.model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CollectionItem {

    private final IntegerProperty collectionId;
    private final ObjectProperty<LocalDate> purchaseDate;
    private final StringProperty notes;
    
    // These properties will hold the *full* objects for easier display
    // You can also just use the IDs (e.g., SimpleIntegerProperty userId)
    private final ObjectProperty<User> user;
    private final ObjectProperty<Game> game;
    private final ObjectProperty<Platform> platform;

    // A "view model" constructor is often useful
    public CollectionItem(int collectionId, User user, Game game, Platform platform, 
                          LocalDate purchaseDate, String notes) {
        this.collectionId = new SimpleIntegerProperty(collectionId);
        this.user = new SimpleObjectProperty<>(user);
        this.game = new SimpleObjectProperty<>(game);
        this.platform = new SimpleObjectProperty<>(platform);
        this.purchaseDate = new SimpleObjectProperty<>(purchaseDate);
        this.notes = new SimpleStringProperty(notes);
    }

    // --- Getters and Property Getters ---

    public int getCollectionId() {
        return collectionId.get();
    }

    public IntegerProperty collectionIdProperty() {
        return collectionId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate.get();
    }

    public ObjectProperty<LocalDate> purchaseDateProperty() {
        return purchaseDate;
    }

    public String getNotes() {
        return notes.get();
    }

    public StringProperty notesProperty() {
        return notes;
    }

    public User getUser() {
        return user.get();
    }

    public ObjectProperty<User> userProperty() {
        return user;
    }

    public Game getGame() {
        return game.get();
    }

    public ObjectProperty<Game> gameProperty() {
        return game;
    }

    public Platform getPlatform() {
        return platform.get();
    }

    public ObjectProperty<Platform> platformProperty() {
        return platform;
    }

    // --- Convenience Getters for TableView ---
    // These are useful for binding table columns directly
    
    public StringProperty gameTitleProperty() {
        return new SimpleStringProperty(game.get().getTitle());
    }

    public StringProperty platformNameProperty() {
        return new SimpleStringProperty(platform.get().getName());
    }
    
    public StringProperty userNameProperty() {
        return new SimpleStringProperty(user.get().getUsername());
    }
}
