package com.example.week_11.homework.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity(name = "accommodation")
public class AccommodationEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String type;

    String bed_type;

    int max_guests;

    String description;

    @OneToMany(mappedBy = "accommodation", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Room_fareEntity> Room_fares;
}
