package iscot.events;

import iscot.enums.Areas;

public class LightSensorEvent extends SensorEvent {
    private static final long serialVersionUID = 1L;

    private final double light;

    public LightSensorEvent(Areas area, double light) {
        super(area);
        this.light = light;
    }

    public double getLight() {
        return light;
    }

    @Override
    public String toString() {
        return "LightSensorEvent [light=" + light + ", area=" + getArea() + ", getType()=" + getType() + "]";
    }
}