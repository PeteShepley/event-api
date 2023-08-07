package com.peteshepley.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventController {

    private final EventRepository events;

    @Autowired
    public EventController(EventRepository events) {
        this.events = events;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        List<Event> allEvents = new ArrayList<>();
        events.findAll().forEach((entity) -> {
            allEvents.add(EventConverter.toEvent(entity));
        });
        return allEvents;
    }

    @GetMapping("/events/{id}")
    public Event getEventById(@PathVariable String id) {
        EventEntity entity = events.findById(id);
        return EventConverter.toEvent(entity);
    }

    @PostMapping("/events")
    public Event createEvent() {
        EventEntity entity = new EventEntity();
        events.save(entity);
        return EventConverter.toEvent(entity);
    }

    @PutMapping("/events/{id}")
    public Event updateEvent(@PathVariable String id, @RequestBody Event event) {
        EventEntity entity = events.findById(id);
        entity.setTitle(event.title());
        entity.setDate(event.date());
        events.save(entity);
        return EventConverter.toEvent(entity);
    }

    @DeleteMapping("/events/{id}")
    public boolean deleteEvent(@PathVariable String id) {
        EventEntity entity = events.findById(id);
        events.delete(entity);
        return true;
    }
}
