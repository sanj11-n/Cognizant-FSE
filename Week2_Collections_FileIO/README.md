# Cognizant FSE Training - Week 2: Database & JDBC

This repository contains the completed hands-on exercises for Week 2, focusing on PostgreSQL database setup, Java Database Connectivity (JDBC), and transactional safety management.

---

## 🛠️ Exercises Implemented

### 1. Database Setup & CRUD Operations (`DatabaseManager.java`)
* **Goal:** Establish a baseline database table structure and perform standard data insertions and read operations.
* **Features:** Connects via JDBC driver, dynamically executes basic data management statements, and safely fetches data records.

### 2. Transaction Management & Validation (`TransactionManager.java`)
* **Goal:** Secure database operations with strict data validation boundaries using manual commits and rollbacks.
* **Features:** Disables `autoCommit`, validates salary parameters, commits authentic data, and initiates a clean data recovery sequence (`rollback`) when bad input is caught.

---

## 📸 Execution Verification Screenshots

### Core Database Queries Execution
![Database Setup Output](screenshots/ex1.png)

### Transaction Validation Handling (Commit & Rollback)
![Transaction Flow Output](screenshots/ex2.png)