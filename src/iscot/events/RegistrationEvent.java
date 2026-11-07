package iscot.events;

import iscot.enums.Areas;
import iscot.enums.Type;

public class RegistrationEvent extends Event {
    private static final long serialVersionUID = 1L;

    public RegistrationEvent(Type type, Areas area) {
        super(type, area);
    }

    @Override
    public String toString() {
        return "RegistrationEvent [type=" + getType() + ", area=" + getArea() + "]";
    }
}