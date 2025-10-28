package com.gametracker.db;

import com.gametracker.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * UserDAO (Data Access Object)
 * This class handles all database operations (CRUD) for the User table.
 */
public class UserDAO {

    /**
     * Validates a user's login credentials against the database.
     *
     * @param username The username entered
     * @param password The password entered
     * @return A User object if login is successful, null otherwise.
     * @throws SQLException
     */
    public User validateLogin(String username, String password) throws SQLException {
        // SQL query to find a user with matching username and password
        // NOTE: Storing passwords in plain text is insecure. In a real app,
        // you would hash the password (e.g., with bcrypt) and compare the hash.
        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
        
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                // If a record is found, rs.next() will be true
                if (rs.next()) {
                    // Create a User object from the database data
                    return extractUserFromResultSet(rs);
                } else {
                    // No matching user found
                    return null;
                }
            }
        }
    }

    /**
     * Helper method to create a User object from a ResultSet.
     */
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("user_id");
        String username = rs.getString("username");
        String email = rs.getString("email");
        String phoneNo = rs.getString("phone_no");
        LocalDate regDate = rs.getDate("registration_date").toLocalDate();
        String password = rs.getString("password");
        
        return new User(id, username, email, phoneNo, regDate, password);
    }
    
    // TODO: You can add more methods here later, like:
    // public List<User> getAllUsers() throws SQLException { ... }
    // public void addUser(User user) throws SQLException { ... }
    // public void updateUser(User user) throws SQLException { ... }
    // public void deleteUser(int userId) throws SQLException { ... }
}
