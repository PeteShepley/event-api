package com.peteshepley.events;

public class EventConverter {

    public static Event toEvent(EventEntity entity) {
        return new Event(entity.getId(), entity.getTitle(), entity.getDate());
    }

    public static EventEntity toEventEntity(Event event) {
        return new EventEntity(event.id(), event.title(), event.date());
    }
}
