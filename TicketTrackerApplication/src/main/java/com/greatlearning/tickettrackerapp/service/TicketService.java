package com.greatlearning.tickettrackerapp.service;

import java.util.List;

import com.greatlearning.tickettrackerapp.entity.TicketTracker;

public interface TicketService {

	List<TicketTracker> getAllTickets();

	TicketTracker getTicketByID(int id);

	void saveTicket(TicketTracker ticket);

	int deleteByTicketId(int id);

	List<TicketTracker> searchTickets(String query);

}
