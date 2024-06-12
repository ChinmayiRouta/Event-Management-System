package com.eventmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eventmanagement.model.Ticket;
import com.eventmanagement.repository.TicketRepository;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket purchaseTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
