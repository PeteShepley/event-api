package com.peteshepley.events;

import java.time.LocalDateTime;

public record Event(String id, String title, LocalDateTime date) {
}
