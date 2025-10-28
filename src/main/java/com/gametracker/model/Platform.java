package com.gametracker.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Platform {

    private final IntegerProperty platformId;
    private final StringProperty name;
    private final StringProperty manufacturer;
    private final IntegerProperty releaseYear;

    public Platform(int platformId, String name, String manufacturer, int releaseYear) {
        this.platformId = new SimpleIntegerProperty(platformId);
        this.name = new SimpleStringProperty(name);
        this.manufacturer = new SimpleStringProperty(manufacturer);
        this.releaseYear = new SimpleIntegerProperty(releaseYear);
    }

    // --- Getters and Property Getters ---

    public int getPlatformId() {
        return platformId.get();
    }

    public IntegerProperty platformIdProperty() {
        return platformId;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer.get();
    }

    public StringProperty manufacturerProperty() {
        return manufacturer;
    }

    public int getReleaseYear() {
        return releaseYear.get();
    }

    public IntegerProperty releaseYearProperty() {
        return releaseYear;
    }

    // Override toString() for better display in ComboBoxes
    @Override
    public String toString() {
        return getName();
    }
}
