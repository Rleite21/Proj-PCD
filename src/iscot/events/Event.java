package iscot.events;

import java.io.Serializable;

import iscot.enums.Areas;
import iscot.enums.Type;

public abstract class Event implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Type type;
    private final Areas area;

    public Event(Type type, Areas area) {
        this.type = type;
        this.area = area;
    }

    public Type getType() {
        return type;
    }

    public Areas getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Event [type=" + type + ", area=" + area + "]";
    }
}