public class SmartLight extends SmartDevice {
    public SmartLight(Communication communication) {
        super(communication);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on the Smart light");
        communication.sendCommand("Light ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the Smart light");
        communication.sendCommand("Light off");
    }


}
