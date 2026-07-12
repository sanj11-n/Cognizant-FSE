package com.cognizant.week3;

class DatabaseConnectionBean {
    private String connectionString;

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
        System.out.println("[LIFECYCLE Step 1] Properties Injected: Connection string set to -> " + connectionString);
    }

    public void customInit() {
        System.out.println("[LIFECYCLE Step 2] Init-Method Triggered: Successfully opened active database pool connection.");
    }

    public void executeQuery() {
        // Actively using the variable here clears the code analysis warnings
        System.out.println("[LIFECYCLE Step 3] Business Action: Fetching secure FSE training telemetry from target database: " + connectionString);
    }

    public void customDestroy() {
        System.out.println("[LIFECYCLE Step 4] Destroy-Method Triggered: Flushing pools and closing database connections cleanly.");
    }
}

public class BeanLifecycleManager {
    public static void main(String[] args) {
        System.out.println("=== Week 3: Exercise 4 - Bean Lifecycle Context ===");
        System.out.println("\n--- [CONTAINER STARTUP] ---");
        DatabaseConnectionBean dbBean = new DatabaseConnectionBean();
        dbBean.setConnectionString("jdbc:postgresql://localhost:5432/cognizant_fse");
        dbBean.customInit();

        System.out.println("\n--- [BEAN IS READY FOR USE] ---");
        dbBean.executeQuery();

        System.out.println("\n--- [CONTAINER SHUTDOWN] ---");
        dbBean.customDestroy();
        System.out.println("Container stopped completely.");
    }
}