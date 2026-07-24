# Cognizant FSE Training - Week 5: Spring Data JPA & Validation

This repository tracks the implementation modules for Week 5, highlighting domain validation structures, constraint intercept engines, and transactional repository queries.

---

## 🛠️ Components Implemented

### 1. Data Model Mapping Entity (`UserEntity.java`)
* Reflects domain configurations, mimicking structural constraints (`@NotBlank`, `@Email`, and `@Min`).

### 2. Validation Handler Interceptor (`ValidatorEngine.java`)
* Checks fields against system constraints and drops unverified payloads safely.

### 3. Spring Data Query Access Layer (`UserRepository.java`)
* Manages standard repository data flows, handling automated save operations and custom search parameters.

### 4. System Execution Controller (`SpringDataApplication.java`)
* Main processing hub verifying validation error paths and live persistence transactions.

---

## 📸 Endpoint Verification Output

### Simulated Validation Operations & Custom Finder Logs
![Week 5 Verification](../screenshots/ex2.png)