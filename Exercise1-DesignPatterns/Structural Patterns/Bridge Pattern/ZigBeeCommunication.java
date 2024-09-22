public class ZigBeeCommunication implements Communication {
    @Override
    public void sendCommand(String command) {
        System.out.println("Sending command through ZigBee: " + command);
    }
    
}
