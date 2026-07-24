package com.cognizant.week4;

public class SpringBootRestApplication {
    public static void main(String[] args) {
        System.out.println("⚡ Starting Simulated Spring Boot Application Environment...");
        System.out.println("Initializing Tomcat server on port: 8080...\n");

        // 1. Initialize our API Controller bean
        ProductRestController apiController = new ProductRestController();

        System.out.println("=== TEST 1: Executing GET Request (Fetch All Products) ===");
        apiController.getAllProducts().forEach(p -> System.out.println(" -> " + p));
        System.out.println("------------------------------------------------------------\n");

        System.out.println("=== TEST 2: Executing POST Request (Add New Product) ===");
        Product newProduct = new Product(103, "Wireless Pods", 129.99);
        String postResponse = apiController.createProduct(newProduct);
        System.out.println("Response from API: " + postResponse);

        // Print database to confirm addition
        System.out.println("\nUpdated Catalog Status:");
        apiController.getAllProducts().forEach(p -> System.out.println(" -> " + p));
        System.out.println("------------------------------------------------------------\n");

        System.out.println("=== TEST 3: Executing DELETE Request (Remove Product 101) ===");
        String deleteResponse = apiController.deleteProduct(101);
        System.out.println("Response from API: " + deleteResponse);

        // Final print confirmation to match review matrix criteria
        System.out.println("\nFinal Verification Catalog Status:");
        apiController.getAllProducts().forEach(p -> System.out.println(" -> " + p));
        System.out.println("============================================================");
    }
}