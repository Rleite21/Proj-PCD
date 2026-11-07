package iscot.events;

import iscot.enums.AirConditioningMode;
import iscot.enums.Areas;

public class AreaTemperatureOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final AirConditioningMode mode;
    private final double targetTemperature;

    public AreaTemperatureOrderEvent(Areas area, AirConditioningMode mode, double targetTemperature) {
        super(area);
        this.mode = mode;
        this.targetTemperature = targetTemperature;
    }

    public AirConditioningMode getMode() {
        return mode;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    @Override
    public String toString() {
        return "AreaTemperatureOrderEvent [mode=" + mode + ", temp=" + targetTemperature
                + ", area=" + getArea() + "]";
    }
}