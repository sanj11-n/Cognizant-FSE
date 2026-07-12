package com.cognizant.week5;

public class ValidatorEngine {

    public static boolean validateUser(UserEntity user) {
        System.out.println("[Validation Layer] Inspecting constraint annotations for user payload...");

        // Simulating @NotBlank
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            System.out.println(" ❌ VALIDATION ERROR: Field 'name' cannot be blank.");
            return false;
        }

        // Simulating @Email
        if (!user.getEmail().contains("@") || !user.getEmail().contains(".")) {
            System.out.println(" ❌ VALIDATION ERROR: Field 'email' must match a valid address format.");
            return false;
        }

        // Simulating @Min(18)
        if (user.getAge() < 18) {
            System.out.println(" ❌ VALIDATION ERROR: Field 'age' must be greater than or equal to 18.");
            return false;
        }

        System.out.println("  Validation Passed Successfully!");
        return true;
    }
}