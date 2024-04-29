package com.example.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.event.model.*;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}