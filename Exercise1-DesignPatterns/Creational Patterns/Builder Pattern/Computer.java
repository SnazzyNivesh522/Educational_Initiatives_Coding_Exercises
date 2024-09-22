public class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private boolean isGraphicsCardEnabled;
    private String gpu;
    private boolean isBluetoothEnabled;
    private boolean isWifiEnabled;
    private boolean isTouchScreenEnabled;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.gpu = builder.gpu;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isWifiEnabled = builder.isWifiEnabled;
        this.isTouchScreenEnabled = builder.isTouchScreenEnabled;
    }

    @Override
    public String toString() {
        return "Computer Configurations:\n" +
                "CPU: " + cpu + "\n" +
                "RAM: " + ram + "\n" +
                "Storage: " + storage + "\n" +
                "Graphics Card Enabled: " + isGraphicsCardEnabled + "\n" +
                "GPU: " + (gpu != null ? gpu : "N/A") + "\n" +
                "Bluetooth Enabled: " + (isBluetoothEnabled != false ? "Yes" : "No" ) + "\n" +
                "WiFi Enabled: " + (isWifiEnabled != false ? "Yes": "No") + "\n" +
                "Touch Screen Enabled: " + (isTouchScreenEnabled != false ? "Yes" : "No");
    }

    // Static Builder class
    public static class ComputerBuilder {
        private String cpu;
        private String ram;
        private String storage;

        private boolean isGraphicsCardEnabled = false;
        private String gpu = null;
        private boolean isBluetoothEnabled = false;
        private boolean isWifiEnabled = false;
        private boolean isTouchScreenEnabled = false;

        // Constructor for required parameters
        public ComputerBuilder(String cpu, String ram, String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        public ComputerBuilder enableGraphicsCard(String gpu) {
            this.isGraphicsCardEnabled = true;
            this.gpu = gpu;
            return this;
        }

        public ComputerBuilder enableBluetoothAndWiFi() {
            this.isBluetoothEnabled = true;
            this.isWifiEnabled = true;
            return this;
        }

        public ComputerBuilder enableTouchScreen() {
            this.isTouchScreenEnabled = true;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
    
}
