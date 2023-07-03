package Observer;

import Interface.DisplayElement;
import Subject.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {
    float temperature;
    float humidity;
    float pressure;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }
    @Override
    public void display() {
        System.out.println("AVG temperature "+temperature);
    }

    @Override
    public void update(float temp, float hum, float pres) {
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        display();
    }
}
