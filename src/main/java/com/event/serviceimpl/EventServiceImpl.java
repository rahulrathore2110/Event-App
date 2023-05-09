package com.event.serviceimpl;

import com.event.exception.EventException;
import com.event.model.Event;
import com.event.repository.EventDao;
import com.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    @Override
    public Event addEvent(Event event) {
        event.setSchedule(LocalDateTime.now());
        return this.eventDao.save(event);
    }


    @Override
    public Event updateEvent(Event event, Integer eventId) throws EventException {
        Event eventUpdate = this.eventDao.findById(eventId).orElseThrow(()->new EventException(
                "No event found with thid id : "+eventId));


        return this.eventDao.save(event);
    }

    @Override
    public String deleteEvent(Integer eventId) throws EventException {
        Event event = this.eventDao.findById(eventId).orElseThrow(()->new EventException("No event found with thid id : "+eventId));
        this.eventDao.delete(event);
        return "Event delete succefully with id : "+event.getUid();
    }

    @Override
    public Event getEventById(Integer eventId) throws EventException {
        Event event = this.eventDao.findById(eventId).orElseThrow(()->new EventException("No event found with thid id : "+eventId));
        return event;
    }

    @Override
    public List<Event> getEventByPages(String type, Integer pageSize, Integer pageNo) {


        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        List<Event> events = this.eventDao.findByTypeContaining(type,pageable);


        return events;
    }
}
