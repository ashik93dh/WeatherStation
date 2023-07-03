import Observer.CurrentConditionsDisplay;
import Observer.HeatIndexDisplay;
import Observer.StatisticsDisplay;
import Subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData=new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay=new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay=new StatisticsDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay=new HeatIndexDisplay(weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);

    }
}