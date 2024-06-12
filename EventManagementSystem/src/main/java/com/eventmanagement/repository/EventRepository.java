package com.eventmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventmanagement.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	List<Event> findByOrganizerId(Long organizerId);
	 List<Event> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
}
