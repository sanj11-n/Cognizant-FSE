package com.cognizant.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<UserEntity> databaseTable = new ArrayList<>();

    public UserRepository() {
        // Seeding database initial table entries
        databaseTable.add(new UserEntity(1, "Alice", "alice@test.com", 24));
        databaseTable.add(new UserEntity(2, "Bob", "bob@example.com", 30));
    }

    public void save(UserEntity user) {
        databaseTable.add(user);
        System.out.println("[Data Layer] Entity successfully committed to JPA context store: " + user.getName());
    }

    public List<UserEntity> findAll() {
        System.out.println("[Data Layer] Query executed: SELECT * FROM user_table;");
        return databaseTable;
    }

    public Optional<UserEntity> findById(int id) {
        System.out.println("[Data Layer] Query executed: SELECT * FROM user_table WHERE id = " + id);
        return databaseTable.stream().filter(u -> u.getId() == id).findFirst();
    }
}