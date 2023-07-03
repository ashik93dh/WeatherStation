package Observer;

import Interface.DisplayElement;
import Subject.Subject;
import Subject.WeatherData;

public class HeatIndexDisplay implements Observer,DisplayElement {
    float temperature;
    float humidity;
    float pressure;
    private Subject weatherData;

    public HeatIndexDisplay(Subject weatherData) {
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        float heatIndex=calculateHeatIndex();
        System.out.println("Heat Index is : "+heatIndex);
    }
    public float calculateHeatIndex(){
        float T=this.temperature;
        float RH=this.humidity;
        float h= (float) ((16.923 + 1.85212 * Math.pow(10,-1) * T + 5.37941 * RH) - (1.00254 * Math.pow(10,-1) * T
                        * RH )+ (9.41695 * Math.pow(10,-3) * Math.pow(T,2) + 7.28898 * Math.pow(10,-3)* Math.pow(RH,2) + 3.45372 * Math.pow(10,-4)
                        * Math.pow(T,2) * RH )- (8.14971 * Math.pow(10,-4) * T * Math.pow(RH,2)) +( 1.02102 * Math.pow(10,-5)* Math.pow(T,2) * Math.pow(RH,2)) -
                        (3.8646 * Math.pow(10,-5) * Math.pow(T,3) + 2.91583 * Math.pow(10,-5)* Math.pow(RH,3)) + (1.42721 * Math.pow(10,6)* Math.pow(T,3) * RH
                        + 1.97483 * Math.pow(10,-7)* T * Math.pow(RH,3)) - (2.18429 * Math.pow(10,-8) * Math.pow(T,3) * Math.pow(RH,2) + 8.43296 *
                        Math.pow(10,-10) * Math.pow(T,2) * Math.pow(RH,3)) - (4.81975 * Math.pow(10,-11)  * Math.pow(T,3) * Math.pow(RH,3)));
        return h;
    }


    @Override
    public void update(float temp, float hum, float pres) {
        this.temperature=temp;
        this.humidity=hum;
        this.pressure=pres;
        display();
    }
}
