package com.cognizant.week5;

public class UserEntity {
    private int id;
    private String name;
    private String email;
    private int age;

    public UserEntity(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-10s | Email: %-20s | Age: %d", id, name, email, age);
    }
}