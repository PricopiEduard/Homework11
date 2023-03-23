package com.example.week_11.homework.controller;

import com.example.week_11.homework.entity.AccommodationEntity;
import com.example.week_11.homework.service.AccommodationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
    private final AccommodationService service;

    public AccommodationController(AccommodationService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAccommodation(@Valid @RequestBody List<AccommodationEntity> accommodationEntities)
    {
        List<Long> addedIds = new ArrayList<>(service.addAccommodations(accommodationEntities));
        return new ResponseEntity<>("Accommodation has been added " + addedIds, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllAccommodations()
    {
        List<AccommodationEntity> accommodationEntities = new ArrayList<>(service.getAllAccommodations());
        return new ResponseEntity<>("Accommodations : " + accommodationEntities, HttpStatus.OK);
    }

   @GetMapping("allRoomsPrices")
   public ResponseEntity<String> getAllRoomsPrices()
   {
       List<String> roomPrices = service.getAllRoomsPrices();
       return new ResponseEntity<>(roomPrices.toString(), HttpStatus.OK);
   }
}
