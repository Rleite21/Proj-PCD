package iscot.events;

import iscot.enums.Areas;

public class AreaIrrigationOrderEvent extends HighLevelOrderEvent {
    private static final long serialVersionUID = 1L;

    private final boolean state;

    public AreaIrrigationOrderEvent(Areas area, boolean state) {
        super(area);
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    @Override
    public String toString() {
        return "AreaIrrigationOrderEvent [state=" + state + ", area=" + getArea() + "]";
    }
}