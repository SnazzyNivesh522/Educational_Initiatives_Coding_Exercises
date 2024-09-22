public class SmartSpeaker extends SmartDevice {
    public SmartSpeaker(Communication communication) {
        super(communication);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on the Smart speaker");
        communication.sendCommand("Speaker ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the Smart speaker");
        communication.sendCommand("Speaker off");
    }
}
