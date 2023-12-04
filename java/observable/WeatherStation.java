/* 
 * 
 * Write a JAVA Program to implement built-in support (java.util.Observable) Weather station 
 * with members temperature, humidity, pressure and methods mesurmentsChanged(), setMesurment(),
 * getTemperature(), getHumidity(), getPressure()   
 * 
 * 
 */

package observable;

public class WeatherStation {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditions = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

		weatherData.setMeasurements(80, 65, 30.4f);
		weatherData.setMeasurements(82, 70, 29.2f);
		weatherData.setMeasurements(78, 90, 29.2f);
	}
}
