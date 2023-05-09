package com.event.service;

import com.event.exception.EventException;
import com.event.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    public Event addEvent(Event event);

    public Event updateEvent(Event event,Integer eventId) throws EventException;

    public String deleteEvent(Integer eventId) throws EventException;

    public Event getEventById(Integer eventId) throws EventException;

    public List<Event> getEventByPages(String type, Integer pageSize, Integer pageNo);



}
