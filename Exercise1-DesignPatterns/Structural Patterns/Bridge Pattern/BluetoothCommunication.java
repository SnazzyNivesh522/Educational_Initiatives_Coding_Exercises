
public class BluetoothCommunication implements Communication {
    @Override
    public void sendCommand(String command) {
        System.out.println("Sending command through Bluetooth: " + command);
    }
}
