package com.cognizant.week3;

import java.util.HashMap;
import java.util.Map;

// 1. Component Interface
interface DataRepository {
    void save(String data);
}

// 2. Concrete Database Component (A Managed Bean)
class SQLRepository implements DataRepository {
    @Override
    public void save(String data) {
        System.out.println("[DATABASE INFO] Successfully persisted record to SQL: " + data);
    }
}

// 3. Simple Simulated Spring IoC Container
class MiniApplicationContext {
    private final Map<String, Object> beanRegistry = new HashMap<>();

    public MiniApplicationContext() {
        // Automatically discover and register components (Bean Initialization)
        beanRegistry.put("dataRepository", new SQLRepository());
    }

    // Retrieve beans safely from the container registry (Inversion of Control)
    public Object getBean(String name) {
        return beanRegistry.get(name);
    }
}

// 4. Main Execution Class
public class SpringIoCContainer {
    public static void main(String[] args) {
        System.out.println("=== Week 3: Exercise 2 - Simulated IoC Container ===");

        // Initialize our lightweight IoC container environment
        MiniApplicationContext context = new MiniApplicationContext();

        // Application requests the bean via loose string coupling rather than 'new SQLRepository()'
        DataRepository repository = (DataRepository) context.getBean("dataRepository");

        if (repository != null) {
            System.out.println("[IoC CONTAINER] Bean successfully retrieved from context registry.");
            repository.save("Week 3 Core Spring Assignment Data");
        } else {
            System.err.println("[ERROR] Failed to locate bean registration.");
        }
    }
}

