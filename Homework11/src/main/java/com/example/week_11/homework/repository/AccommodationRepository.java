package com.example.week_11.homework.repository;

import com.example.week_11.homework.entity.AccommodationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends CrudRepository<AccommodationEntity, Long>
{
}
