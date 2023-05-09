package com.event.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Event {
    private String type;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
    private String name;
    private String tagline;
    private LocalDateTime schedule;
    private String description;
    private String image;
    private String moderator;
    private String category;
    private String subCategory;
    private Integer rigorRank;
    private List<Integer> attendees;
}
