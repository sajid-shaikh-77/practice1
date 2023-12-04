import java.util.Observable;
import java.util.Observer;

class WeatherData extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

class Display implements Observer {

    private WeatherData weatherData;

    public Display(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            display(weatherData.getTemperature(), weatherData.getHumidity(), weatherData.getPressure());
        }
    }

    public void display(float temperature, float humidity, float pressure) {
        System.out.println(
                "Temperature: " + temperature + "F, Humidity: " + humidity + "%, Pressure: " + pressure + "hPa");
    }
}

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        Display display1 = new Display(weatherData);
        Display display2 = new Display(weatherData);

        // Simulate weather measurements changes
        weatherData.setMeasurements(75.0f, 60.0f, 30.4f);
        weatherData.setMeasurements(80.0f, 65.0f, 31.5f);
    }
}
