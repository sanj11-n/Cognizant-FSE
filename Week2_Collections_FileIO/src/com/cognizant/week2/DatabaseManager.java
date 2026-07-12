package com.cognizant.week2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseManager {

    // Default configuration for local PostgreSQL installed via Homebrew
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "sanjana";
    private static final String PASSWORD = ""; // Left empty for clean local setups

    public static void main(String[] args) {
        System.out.println("=== Running Week 2 Database Exercise ===");

        // 1. Connect and Read existing data from Exercise 1
        System.out.println("\n--- Current Employee Table Data ---");
        readEmployees();

        // 2. Insert a new record dynamically
        insertEmployee("Amit Sharma", "QA Engineer", 50000.00);

        // 3. Read data again to prove the update worked perfectly
        System.out.println("\n--- Data after adding new employee ---");
        readEmployees();
    }

    // Method to neatly display everything in the table
    public static void readEmployees() {
        String query = "SELECT id, name, role, salary FROM Employees";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println(String.format("%-5s | %-15s | %-20s | %-10s", "ID", "Name", "Role", "Salary"));
            System.out.println("------------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String role = rs.getString("role");
                double salary = rs.getDouble("salary");

                System.out.println(String.format("%-5d | %-15s | %-20s | %-10.2f", id, name, role, salary));
            }

        } catch (Exception e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    // Method to cleanly insert a record without SQL injection risks
    public static void insertEmployee(String name, String role, double salary) {
        String insertSQL = "INSERT INTO Employees (name, role, salary) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            pstmt.setString(1, name);
            pstmt.setString(2, role);
            pstmt.setDouble(3, salary);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("\n[SUCCESS] Successfully added employee: " + name);
            }

        } catch (Exception e) {
            System.err.println("Insert Failure: " + e.getMessage());
        }
    }
}