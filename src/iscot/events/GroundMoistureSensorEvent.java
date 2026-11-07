package iscot.events;
import iscot.enums.Areas;

public class GroundMoistureSensorEvent extends SensorEvent {
    private double moisture;

    public GroundMoistureSensorEvent(Areas area, double moisture) {
        super(area);
        this.moisture = moisture;
    }

    public double getMoisture() { return moisture; }

    @Override
    public String toString() { 
        return "GroundMoistureSensorEvent [moisture=" + moisture + ", area=" + getArea() + ", getType()=" + getType() + "]"; 
    }
}