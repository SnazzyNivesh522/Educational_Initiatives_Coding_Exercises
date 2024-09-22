public class BridgePatternSmartHome {
    public static void main(String[] args) {
        // Create devices with different communication methods
        SmartDevice lightWithWiFi = new SmartLight(new WiFiCommunication());
        SmartDevice thermostatWithBluetooth = new SmartThermostat(new BluetoothCommunication());
        SmartDevice speakerWithZigbee = new SmartSpeaker(new ZigBeeCommunication());

        // Turn on and off the devices
        lightWithWiFi.turnOn();
        lightWithWiFi.turnOff();

        System.out.println();

        thermostatWithBluetooth.turnOn();
        thermostatWithBluetooth.turnOff();

        System.out.println();

        speakerWithZigbee.turnOn();
        speakerWithZigbee.turnOff();
    }
}
