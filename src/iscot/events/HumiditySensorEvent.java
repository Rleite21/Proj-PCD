package iscot.events;
import iscot.enums.Areas;

public class HumiditySensorEvent extends SensorEvent {
    private double humidity;

    public HumiditySensorEvent(Areas area, double humidity) {
        super(area);
        this.humidity = humidity;
    }

    public double getHumidity() { return humidity; }

    @Override
    public String toString() { 
        return "HumiditySensorEvent [humidity=" + humidity + ", area=" + getArea() + ", getType()=" + getType() + "]"; 
    }
}