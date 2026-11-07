package iscot.events;
import iscot.enums.Areas;

public class TemperatureSensorEvent extends SensorEvent {
    private double temperature;

    public TemperatureSensorEvent(Areas area, double temperature) {
        super(area);
        this.temperature = temperature;
    }

    public double getTemperature() { return temperature; }

    @Override
    public String toString() { 
        return "TemperatureSensorEvent [temperature=" + temperature + ", area=" + getArea() + ", getType()=" + getType() + "]"; 
    }
}