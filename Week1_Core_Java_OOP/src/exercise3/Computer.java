package exercise3;

public class Computer {
    // Attributes of our computer
    private final String CPU;
    private final String RAM;
    private final String storage;

    // Private constructor so it can only be built via the Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }

    public void showConfiguration() {
        System.out.println("Computer Config -> CPU: " + CPU + " | RAM: " + RAM + " | Storage: " + storage);
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        // The final method to deliver the custom Computer object
        public Computer build() {
            return new Computer(this);
        }
    }
}