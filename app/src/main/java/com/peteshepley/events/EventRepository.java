package com.peteshepley.events;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<EventEntity, Long> {
    EventEntity findById(String id);
}
