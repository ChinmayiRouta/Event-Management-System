package com.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eventmanagement.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
