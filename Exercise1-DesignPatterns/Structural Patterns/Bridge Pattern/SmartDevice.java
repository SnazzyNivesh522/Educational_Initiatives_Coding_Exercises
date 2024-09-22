abstract class SmartDevice {
    protected Communication communication;

    public SmartDevice(Communication communication) {
        this.communication = communication;
    }

    public abstract void turnOn();
    public abstract void turnOff();

}
