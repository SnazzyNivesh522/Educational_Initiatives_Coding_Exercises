public class WiFiCommunication implements Communication {
    @Override
    public void sendCommand(String command) {
        System.out.println("Sending command through WiFi: " + command);
    }
    
}
