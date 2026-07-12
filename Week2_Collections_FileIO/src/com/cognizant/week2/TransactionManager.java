package com.cognizant.week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManager {

    // Pulling the exact same working connection configuration from Exercise 1
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "sanjana"; // Matches your Mac profile username
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        System.out.println("=== Running Week 2 Advanced Transaction Exercise ===\n");

        // Test 1: Trying to save a valid employee (Should succeed and save)
        saveEmployeeWithValidation("Karan Johar", "Cloud Architect", 85000.00);

        System.out.println("\n--------------------------------------------------\n");

        // Test 2: Trying to save an invalid employee (Should catch error and rollback)
        saveEmployeeWithValidation("Invalid User", "Tester", -1200.00);
    }

    public static void saveEmployeeWithValidation(String name, String role, double salary) {
        String insertSQL = "INSERT INTO Employees (name, role, salary) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. Establish connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Turn off Auto-Commit to take manual control of the transaction
            conn.setAutoCommit(false);

            // 3. Prepare the SQL Statement
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, name);
            pstmt.setString(2, role);
            pstmt.setDouble(3, salary);

            // Execute the operation locally
            pstmt.executeUpdate();
            System.out.println("[STEP 1] Database operation executed locally for: " + name);

            // 4. Perform Business Logic Validation
            if (salary <= 0) {
                // Throwing an exception triggers our rollback logic automatically
                throw new IllegalArgumentException("Salary cannot be zero or negative! Provided: " + salary);
            }

            // 5. If validation passes, commit the changes to the database permanently
            conn.commit();
            System.out.println("[SUCCESS] Transaction Committed successfully! Data saved for " + name);

        } catch (Exception e) {
            System.out.println("[ERROR DETECTED] Reason: " + e.getMessage());

            // 6. Roll back the operation completely if anything went wrong
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("[ROLLBACK] Transaction rolled back cleanly. No data was modified.");
                } catch (SQLException ex) {
                    System.err.println("Failed to rollback transaction: " + ex.getMessage());
                }
            }
        } finally {
            // Clean up resources cleanly
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}