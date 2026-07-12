# Cognizant FSE Training - Week 4: Spring Boot & REST APIs

This repository tracks the implementation modules for Week 4, focusing on Spring Boot ecosystem architecture, REST Controller endpoint handling, and basic entity CRUD simulators.

---

## 🛠️ Components Implemented

### 1. Data Model (`Product.java`)
* Core domain object encapsulating product variables (ID, Name, Price) with standardized data mappings.

### 2. REST API Controller Service (`ProductRestController.java`)
* In-memory repository handling operations for data transactions:
    * **GET:** Fetches available product list records.
    * **POST:** Injects and validates new entries.
    * **DELETE:** Locates and evicts entries cleanly.

### 3. Context Driver Core (`SpringBootRestApplication.java`)
* Entry layer bootstrapper initialization sequence mapping endpoints sequentially for tracking output.

---

## 📸 Endpoint Verification Output

### Simulated CRUD API Transactions
![Week 4 Verification](../../../screenshots/ex1.png)