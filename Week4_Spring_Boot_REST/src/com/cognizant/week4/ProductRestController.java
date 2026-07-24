package com.cognizant.week4;

import java.util.ArrayList;
import java.util.List;

public class ProductRestController {
    // In-memory array list acting as a local database simulation
    private final List<Product> database = new ArrayList<>();

    public ProductRestController() {
        // Seed initial data records
        database.add(new Product(101, "Laptop", 899.99));
        database.add(new Product(102, "Smartphone", 499.99));
    }

    // GET Endpoint Simulation
    public List<Product> getAllProducts() {
        System.out.println("[API - GET] Fetching all items from repository context...");
        return database;
    }

    // POST Endpoint Simulation
    public String createProduct(Product newProduct) {
        database.add(newProduct);
        System.out.println("[API - POST] Successfully saved item: " + newProduct.getName());
        return "SUCCESS: Product cataloged with ID " + newProduct.getId();
    }

    // DELETE Endpoint Simulation
    public String deleteProduct(int id) {
        boolean removed = database.removeIf(product -> product.getId() == id);
        if (removed) {
            System.out.println("[API - DELETE] Evicted product record item ID: " + id);
            return "SUCCESS: Product removed.";
        }
        return "ERROR: Item ID " + id + " not found.";
    }
}