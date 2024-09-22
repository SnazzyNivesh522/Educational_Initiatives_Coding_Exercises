public class WeatherStation {
    public static void main(String[] args) {
        EnvironmentSensor sensor = new EnvironmentSensor();
        DataDisplayer displayer = new DataDisplayer(sensor);
        sensor.setMeasurements(80f, 65f, 30.4f);
        sensor.setMeasurements(82f, 70f, 29.2f);
        sensor.setMeasurements(78f, 90f, 29.2f);
    }

}
