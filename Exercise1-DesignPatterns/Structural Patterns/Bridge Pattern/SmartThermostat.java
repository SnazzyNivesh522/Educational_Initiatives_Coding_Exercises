public class SmartThermostat extends SmartDevice {
    public SmartThermostat(Communication communication) {
        super(communication);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on the Smart thermostat");
        communication.sendCommand("Thermostat ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the Smart thermostat");
        communication.sendCommand("Thermostat off");
    }
    
}
