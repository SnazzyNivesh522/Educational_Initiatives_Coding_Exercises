public class ComputerDemo {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.ComputerBuilder("Intel i5", "16GB", "512GB SSD")
                .build();
        System.out.println("\n" + basicComputer);

        Computer officeComputer = new Computer.ComputerBuilder("Intel i7", "16GB", "1TB SSD")
                .enableBluetoothAndWiFi()
                .enableTouchScreen()
                .build();
        System.out.println();
        System.out.println(officeComputer);

        Computer gamingComputer = new Computer.ComputerBuilder("Intel i9", "32GB", "1TB SSD")
                .enableGraphicsCard("NVIDIA RTX 3080")
                .enableBluetoothAndWiFi()
                .build();
        System.err.println();
        System.out.println(gamingComputer);

        
    }
}
