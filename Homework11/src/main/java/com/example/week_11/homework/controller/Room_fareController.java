package com.example.week_11.homework.controller;

import com.example.week_11.homework.entity.AccommodationEntity;
import com.example.week_11.homework.entity.Room_fareEntity;
import com.example.week_11.homework.service.Room_fareService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room_fare")
public class Room_fareController {

    private final Room_fareService service;

    public Room_fareController(Room_fareService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addRoom_fare(@Valid @RequestBody List<Room_fareEntity> room_fareEntities)
    {
        List<Long> addedIds = new ArrayList<>(service.addRoom_fare(room_fareEntities));
        return new ResponseEntity<>("Room_fare has been added " + addedIds, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllRoom_fares()
    {
        List<Room_fareEntity> room_fareEntities = new ArrayList<>(service.getAllRoom_fares());
        return new ResponseEntity<>("Room_fares : " + room_fareEntities, HttpStatus.OK);
    }


}
