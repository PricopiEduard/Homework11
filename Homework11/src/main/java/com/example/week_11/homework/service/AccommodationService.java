package com.example.week_11.homework.service;

import com.example.week_11.homework.entity.AccommodationEntity;
import com.example.week_11.homework.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccommodationService
{
    private final AccommodationRepository accommodationRepository;

    public AccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public List<Long> addAccommodations(List<AccommodationEntity> accommodationEntities) {
        List<Long> addedIds = new ArrayList<>();
        for(AccommodationEntity accommodationEntity : accommodationEntities)
        {
            addedIds.add(accommodationEntity.getId());
            accommodationRepository.save(accommodationEntity);
        }
        return addedIds;
    }

    public List<AccommodationEntity> getAllAccommodations()
    {
        List<AccommodationEntity> accommodationEntitiesList = new ArrayList<>();
        Iterable<AccommodationEntity> accommodationEntities = accommodationRepository.findAll();
        accommodationEntities.forEach(accommodationEntitiesList::add);

        return accommodationEntitiesList;
    }

    public List<String> getAllRoomsPrices()
    {
        List<String> roomsAndPrices = new ArrayList<>();
        Iterable<AccommodationEntity> accommodationEntities = accommodationRepository.findAll();
        accommodationEntities.forEach(accommodationEntity -> roomsAndPrices.add(accommodationEntity.getType()
                + accommodationEntity.getRoom_fares().toString() ));
        return roomsAndPrices;
    }
}
