package com.example.week_11.homework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "room_fare")
public class Room_fareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    double value;

    String season;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accommodation_id", nullable = false)
    private AccommodationEntity accommodation;
}
