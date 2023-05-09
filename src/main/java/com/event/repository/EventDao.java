package com.event.repository;

import com.event.model.Event;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDao extends JpaRepository<Event,Integer> {
    public List<Event> findByTypeContaining(String type, Pageable pageable);
}
