package iscot.events;
import iscot.enums.Areas;

public class AreaLightingOrderEvent extends HighLevelOrderEvent {
    private boolean state;

    public AreaLightingOrderEvent(Areas area, boolean state) {
        super(area);
        this.state = state;
    }

    public boolean isState() { return state; }

    @Override
    public String toString() { 
        return "AreaLightingOrderMessage [state=" + state + ", area=" + getArea() + ", getType()=" + getType() + "]"; 
    }
}