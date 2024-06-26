package com.example.event.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.event.model.*;

public interface EventService {
	List<Event> getAllEvents();
	void saveEvent(Event event);
	Event getEventById(long id);
	void deleteEventById(long id);
	Page<Event> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}