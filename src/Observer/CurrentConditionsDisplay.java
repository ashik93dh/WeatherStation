package Observer;

import Interface.DisplayElement;
import Subject.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
    float temperature;
    float humidity;
    float pressure;
    private Subject weatherData;
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float hum, float pres) {
        this.temperature=temp;
        this.humidity=hum;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions : " + temperature+"F and " +humidity+"% humidity");
    }
}
