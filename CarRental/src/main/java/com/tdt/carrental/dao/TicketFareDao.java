package com.tdt.carrental.dao;

import java.util.List;

import com.tdt.carrental.model.TicketFare;

public interface TicketFareDao {
	public abstract boolean registrationTicketFare(TicketFare ticketFare);

	public abstract List<TicketFare> listTicketFare();

	public abstract Boolean updateTicketFare(TicketFare ticketFare);

	public abstract TicketFare getTicketFare(int id);
}
