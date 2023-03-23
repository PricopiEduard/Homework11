package com.example.week_11.homework.repository;

import com.example.week_11.homework.entity.AccommodationEntity;
import com.example.week_11.homework.entity.Room_fareEntity;
import lombok.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Room_fareRepository extends CrudRepository<Room_fareEntity, Long>
{
}
