package com.eventmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long organizerId;
    private String title;
    private String description;
    private String date;
    private String time;
    private String location;
    private String ticketInfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrganizerId() {
		return organizerId;
	}
	public void setOrganizerId(Long organizerId) {
		this.organizerId = organizerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTicketInfo() {
		return ticketInfo;
	}
	public void setTicketInfo(String ticketInfo) {
		this.ticketInfo = ticketInfo;
	}
	
    // Getters and Setters
    
    
}
