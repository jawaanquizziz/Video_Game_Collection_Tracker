package com.gametracker.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private final IntegerProperty userId;
    private final StringProperty username;
    private final StringProperty email;
    private final StringProperty phoneNo;
    private final ObjectProperty<LocalDate> registrationDate;
    private final StringProperty password; // ADDED THIS FIELD

    /**
     * Constructor for creating a new User object.
     * @param userId
     * @param username
     * @param email
     * @param phoneNo
     * @param registrationDate
     * @param password
     */
    public User(int userId, String username, String email, String phoneNo, 
                LocalDate registrationDate, String password) { // ADDED password
        this.userId = new SimpleIntegerProperty(userId);
        this.username = new SimpleStringProperty(username);
        this.email = new SimpleStringProperty(email);
        this.phoneNo = new SimpleStringProperty(phoneNo);
        this.registrationDate = new SimpleObjectProperty<>(registrationDate);
        this.password = new SimpleStringProperty(password); // ADDED
    }

    // --- Getters and Property Getters ---

    public int getUserId() {
        return userId.get();
    }

    public IntegerProperty userIdProperty() {
        return userId;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo.get();
    }

    public StringProperty phoneNoProperty() {
        return phoneNo;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate.get();
    }

    public ObjectProperty<LocalDate> registrationDateProperty() {
        return registrationDate;
    }
    
    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    // Override toString() for better display in ComboBoxes
    @Override
    public String toString() {
        // Return username, which is more user-friendly for ComboBoxes
        return getUsername();
    }
}

