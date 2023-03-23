package com.example.week_11.homework.service;

import com.example.week_11.homework.entity.Room_fareEntity;
import com.example.week_11.homework.repository.Room_fareRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Room_fareService {

    private final Room_fareRepository room_fareRepository;

    public Room_fareService(Room_fareRepository room_fareRepository) {
        this.room_fareRepository = room_fareRepository;
    }

    public List<Long> addRoom_fare(List<Room_fareEntity> room_fareEntities) {
        List<Long> addedIds = new ArrayList<>();
        for(Room_fareEntity room_fareEntity : room_fareEntities)
        {
            addedIds.add(room_fareEntity.getId());
            room_fareRepository.save(room_fareEntity);
        }
        return addedIds;
    }

    public List<Room_fareEntity> getAllRoom_fares()
    {
        List<Room_fareEntity> room_fareEntityList = new ArrayList<>();
        Iterable<Room_fareEntity> room_fareEntities = room_fareRepository.findAll();
        room_fareEntities.forEach(room_fareEntityList::add);

        return room_fareEntityList;
    }
}


