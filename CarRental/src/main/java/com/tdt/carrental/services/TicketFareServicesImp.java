package com.tdt.carrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdt.carrental.dao.TicketFareDao;
import com.tdt.carrental.model.TicketFare;

@Service
@Transactional
public class TicketFareServicesImp implements TicketFareServices {

	@Autowired
	private TicketFareDao ticketFareDao;
	@Override
	public boolean registrationTicketFare(TicketFare ticketFare) {
		// TODO Auto-generated method stub
		return this.ticketFareDao.registrationTicketFare(ticketFare);
	}

	@Override
	public List<TicketFare> listTicketFare() {
		// TODO Auto-generated method stub
		return this.ticketFareDao.listTicketFare();
	}

	@Override
	public Boolean updateTicketFare(TicketFare ticketFare) {
		// TODO Auto-generated method stub
		return this.ticketFareDao.updateTicketFare(ticketFare);
	}

	@Override
	public TicketFare getTicketFare(int id) {
		// TODO Auto-generated method stub
		return this.ticketFareDao.getTicketFare(id);
	}

	@Override
	public void deleteTicketFare(int id) {
		this.ticketFareDao.deleteTicketFare(id);
		
	}

}
