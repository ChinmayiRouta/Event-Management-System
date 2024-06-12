package com.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eventmanagement.model.Ticket;
import com.eventmanagement.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody Ticket ticket) {
        return ticketService.purchaseTicket(ticket);
    }
}
