# 🎮 Video Game Collection Tracker

[![GitHub license](https://img.shields.io/github/license/jawaanquizziz/Video_Game_Collection_Tracker?style=for-the-badge&color=007EC6)](https://github.com/jawaanquizziz/Video_Game_Collection_Tracker/blob/main/LICENSE)
[![GitHub stars](https://img.shields.io/github/stars/jawaanquizziz/Video_Game_Collection_Tracker?style=for-the-badge&color=FFD700&logo=github)](https://github.com/jawaanquizziz/Video_Game_Collection_Tracker/stargazers)
[![GitHub forks](https://img.shields.io/github/forks/jawaanquizziz/Video_Game_Collection_Tracker?style=for-the-badge&color=9C27B0&logo=github)](https://github.com/jawaanquizziz/Video_Game_Collection_Tracker/network/members)
[![JavaFX](https://img.shields.io/badge/JavaFX-21%2B-blue.svg?style=for-the-badge&logo=openjdk)](https://openjfx.io/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0%2B-orange.svg?style=for-the-badge&logo=mysql)](https://www.mysql.com/)

A modern, secure desktop application built with **JavaFX** and **MySQL** to manage your personal video game collection.

---

## 🎬 Live Demo (Animation)

The best way to show off a desktop app is with a short GIF!

You can use a free tool like [**ShareX**](https://getsharex.com/) (Windows) or [**GIPHY Capture**](https://giphy.com/apps/giphycapture) (Mac) to record your screen and create a GIF.

**\[TODO: Replace this block with your own GIF!\]**
![App Demo GIF Placeholder](https://placehold.co/800x450/333/FFF?text=Your+App+Demo+GIF+Here%0A(Login+%2D%3E+View+Collection+%2D%3E+Logout))

**How to add your GIF:**

1.  Record a short GIF of you logging in, viewing the collection, and logging out.
2.  Upload the GIF to your GitHub repository (you can even just drag and drop it into an "Issue" comment to get a URL).
3.  Copy the URL of the uploaded GIF.
4.  Paste the URL into the `README.md` file, replacing the placeholder above.

---

## ✨ Features

* **Secure User Login:** Authenticate users against a MySQL database.
* **Elegant UI:** A clean, modern, and dark-themed UI built with JavaFX and styled with CSS.
* **Collection Management:** View, add, edit, and delete games in your personal collection (future feature).
* **Database Browsing:** View master lists of all games and platforms in the database (future feature).
* **Logout:** Securely log out to return to the login screen.

---

## 🛠️ Technologies Used

* **Frontend:** JavaFX 21
* **Backend:** Java 21+ (JDBC)
* **Database:** MySQL 8.0+
* **Build Tool:** Apache Maven
* **Project Management:** Git & GitHub

---

## 🚦 Getting Started

Follow these instructions to get the project running on your local machine.

### 1. Prerequisites

* **Java Development Kit (JDK) 21** or higher.
* **Apache Maven** (for building and running).
* **MySQL Server 8.0** or higher.
* A MySQL client like **MySQL Workbench** to run the schema script.

### 2. Database Setup

1.  **Start your MySQL Server.**
2.  Open your MySQL client (e.g., MySQL Workbench) and connect to your server.
3.  Open the `schema.sql` file (from this project's root folder) and **run the entire script**. This will create the `game_tracker_db` database, all tables, and a test user.
4.  **Add a Test User (if schema doesn't include one):**
    ```sql
    -- Run this in your MySQL client if you need a user to log in
    USE game_tracker_db;
    INSERT INTO User (username, email, phone_no, registration_date, password)
    VALUES ('testuser', 'test@example.com', '1234567890', '2025-01-01', 'testpass');
    ```

### 3. Configure Credentials

**This is the most important step!**

1.  Go to `src/main/java/com/gametracker/db/DatabaseUtil.java`.
2.  Change the `DB_USER` and `DB_PASSWORD` variables to match your MySQL username and password.
    ```java
    // ...
    private static final String DB_USER = "root"; // Or your MySQL username
    private static final String DB_PASSWORD = "your_password_here"; // <-- CHANGE THIS!
    // ...
    ```
3.  The `.gitignore` file will **prevent this file from being uploaded to GitHub**, keeping your password safe.

### 4. Run the Application

1.  Open your command prompt (`cmd`) or terminal.
2.  Navigate to the project's root folder (where `pom.xml` is).
3.  Run the following Maven command:
    ```bash
    mvn clean javafx:run
    ```
4.  The application will launch. Log in with the user you created (e.g., `testuser` / `testpass`).

---

## 📂 Project Structure

Here is the complete file directory for the project:

VideoGameTracker/
├── .gitignore          # Tells Git to ignore files (like your password file)
├── pom.xml             # Maven build and dependency file
├── README.md           # Your project's documentation
├── schema.sql          # The MySQL database creation script
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── gametracker/
        │           ├── controller/
        │           │   ├── LoginViewController.java
        │           │   └── MainViewController.java
        │           ├── db/
        │           │   ├── DatabaseUtil.java  (Contains your password)
        │           │   └── UserDAO.java
        │           ├── model/
        │           │   ├── CollectionItem.java
        │           │   ├── Game.java
        │           │   ├── Platform.java
        │           │   └── User.java
        │           └── MainApp.java           # Main application entry point
        │
        └── resources/
            └── com/
                └── gametracker/
                    └── view/
                        ├── LoginView.fxml
                        ├── MainView.fxml
                        └── styles.css
