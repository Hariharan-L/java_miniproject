package com.example.event.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.event.model.*;
import com.example.event.repository.*;

@Service
public class EventServiceimp implements EventService {
	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public void saveEvent(Event event) {
		this.eventRepository.save(event);
	}

	@Override
	public Event getEventById(long id) {
		Optional<Event> optional = eventRepository.findById(id);
		Event event = null;
		if (optional.isPresent()) {
			event = optional.get();
		} else {
			throw new RuntimeException(" Event not found for id :: " + id);
		}
		return event;
	}

	@Override
	public void deleteEventById(long id) {
		this.eventRepository.deleteById(id);
	}

	@Override
	public Page<Event> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.eventRepository.findAll(pageable);
	}
}
