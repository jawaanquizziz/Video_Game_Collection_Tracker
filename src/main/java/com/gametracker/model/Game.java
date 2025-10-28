package com.gametracker.model;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Game {

    private final IntegerProperty gameId;
    private final StringProperty title;
    private final DoubleProperty price;
    private final ObjectProperty<LocalDate> releaseDate;
    private final StringProperty publisher;
    private final StringProperty status;
    private final StringProperty developer;
    private final StringProperty genre;

    public Game(int gameId, String title, double price, LocalDate releaseDate, 
                String publisher, String status, String developer, String genre) {
        this.gameId = new SimpleIntegerProperty(gameId);
        this.title = new SimpleStringProperty(title);
        this.price = new SimpleDoubleProperty(price);
        this.releaseDate = new SimpleObjectProperty<>(releaseDate);
        this.publisher = new SimpleStringProperty(publisher);
        this.status = new SimpleStringProperty(status);
        this.developer = new SimpleStringProperty(developer);
        this.genre = new SimpleStringProperty(genre);
    }

    // --- Getters and Property Getters ---

    public int getGameId() {
        return gameId.get();
    }

    public IntegerProperty gameIdProperty() {
        return gameId;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate.get();
    }

    public ObjectProperty<LocalDate> releaseDateProperty() {
        return releaseDate;
    }

    public String getPublisher() {
        return publisher.get();
    }

    public StringProperty publisherProperty() {
        return publisher;
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public String getDeveloper() {
        return developer.get();
    }

    public StringProperty developerProperty() {
        return developer;
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    // Override toString() for better display in ComboBoxes
    @Override
    public String toString() {
        return getTitle();
    }
}
