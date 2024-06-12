package com.eventmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventmanagement.model.Event;
import com.eventmanagement.service.EventService;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }
    @GetMapping("/organizer/{organizerId}")
    public List<Event> getEventsByOrganizer(@PathVariable Long organizerId) {
        return eventService.getEventsByOrganizer(organizerId);
    }

    @PutMapping("/update")
    public Event updateEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }
    
    @GetMapping("/search")
    public List<Event> searchEvents(@RequestParam String keyword) {
        return eventService.searchEvents(keyword);
    }
    
    
}
