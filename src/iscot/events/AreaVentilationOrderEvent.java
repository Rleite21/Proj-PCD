package iscot.events;
import iscot.enums.Areas;
import iscot.enums.AirConditioningMode;

public class AreaVentilationOrderEvent extends HighLevelOrderEvent {
    private AirConditioningMode mode;

    public AreaVentilationOrderEvent(Areas area, AirConditioningMode mode) {
        super(area);
        this.mode = mode;
    }

    public AirConditioningMode getMode() { return mode; }

    @Override
    public String toString() { 
        return "AreaVentilationOrderEvent [mode=" + mode + ", area=" + getArea() + ", getType()=" + getType() + "]"; 
    }
}