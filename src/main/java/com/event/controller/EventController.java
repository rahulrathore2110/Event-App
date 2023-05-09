package com.event.controller;

import com.event.exception.EventException;
import com.event.model.Event;
import com.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/app")
public class EventController {

    @Autowired
    private EventService eventService;


    @PostMapping("/events")
    public ResponseEntity<Event> addEventHandler(@RequestBody Event event) {
        Event addEvent = this.eventService.addEvent(event);
        return new ResponseEntity<Event>(addEvent, HttpStatus.CREATED);
    }

    @PutMapping("/events/{eventId}")
    public ResponseEntity<Event> updateEventHandler(@RequestBody Event event,
                                                    @PathVariable Integer eventId) throws EventException {
        Event addEvent = this.eventService.updateEvent(event,eventId);
        return new ResponseEntity<Event>(addEvent, HttpStatus.CREATED);
    }

    @DeleteMapping("/events/{eventId}")
    public ResponseEntity<String> deleteEventHandler( @PathVariable Integer eventId) throws EventException {
        String deleteEvent = this.eventService.deleteEvent(eventId);
        return new ResponseEntity<String>(deleteEvent, HttpStatus.CREATED);
    }

    @GetMapping("/event")
    public ResponseEntity<Event> getEventByIdHandler(@RequestParam("id") Integer eventId) throws EventException {
        Event eventById = this.eventService.getEventById(eventId);
        return new ResponseEntity<Event>(eventById, HttpStatus.CREATED);
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event> > getEventByPageNoHandler(@RequestParam("type") String type,
                                                         @RequestParam("limit") Integer PageSize,
                                                         @RequestParam("page") Integer pageNo) throws EventException {
        List<Event> eventByPages = this.eventService.getEventByPages(type, PageSize, pageNo);
        return new ResponseEntity<List<Event> >(eventByPages, HttpStatus.CREATED);
    }





}
