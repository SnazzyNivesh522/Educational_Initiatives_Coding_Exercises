public class DataDisplayer implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;
    private Sensor sensor;

    

    public DataDisplayer(Sensor sensor) {
        this.sensor = sensor;
        sensor.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    private void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity" + " and " + pressure + " Pa(Pascals) pressure");
    }
    
}
