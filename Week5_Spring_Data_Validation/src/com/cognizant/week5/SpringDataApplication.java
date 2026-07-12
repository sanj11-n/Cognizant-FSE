package com.cognizant.week5;

import java.util.Optional;

public class SpringDataApplication {
    public static void main(String[] args) {
        System.out.println("⚡ Booting Simulated Spring Boot Data Management Service Engine...");
        System.out.println("Connection established to internal H2 InMemory Schema Engine...\n");

        UserRepository userRepo = new UserRepository();

        System.out.println("=== TRACKING SCENARIO 1: View Initial Seed Data Summary ===");
        userRepo.findAll().forEach(u -> System.out.println(" -> " + u));
        System.out.println("----------------------------------------------------------------\n");

        System.out.println("=== TRACKING SCENARIO 2: Post Invalid Entity (Negative Test Case) ===");
        UserEntity invalidUser = new UserEntity(3, "", "wrong-email-format", 16);
        if (ValidatorEngine.validateUser(invalidUser)) {
            userRepo.save(invalidUser);
        } else {
            System.out.println("[Controller Layer] Rejected 400 Bad Request Payload. Record dropped.");
        }
        System.out.println("----------------------------------------------------------------\n");

        System.out.println("=== TRACKING SCENARIO 3: Post Valid Entity (Positive Test Case) ===");
        UserEntity validUser = new UserEntity(4, "Charlie", "charlie@web.com", 21);
        if (ValidatorEngine.validateUser(validUser)) {
            userRepo.save(validUser);
        }
        System.out.println("----------------------------------------------------------------\n");

        System.out.println("=== TRACKING SCENARIO 4: Execute JPA Custom ID Finder Query ===");
        Optional<UserEntity> searchResult = userRepo.findById(4);
        if (searchResult.isPresent()) {
            System.out.println(" -> Entity Record Located: " + searchResult.get());
        } else {
            System.out.println(" -> 404 Entity Not Found.");
        }
        System.out.println("================================================================");
    }
}