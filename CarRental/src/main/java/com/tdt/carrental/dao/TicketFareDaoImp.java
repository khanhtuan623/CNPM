package com.tdt.carrental.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tdt.carrental.model.Schedule;
import com.tdt.carrental.model.TicketFare;

@Repository
@Transactional
public class TicketFareDaoImp implements TicketFareDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean registrationTicketFare(TicketFare ticketFare) {
		try {
			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			TicketFare registrationTicketFare=new TicketFare();
			registrationTicketFare.setIdSchedule(ticketFare.getIdSchedule());
			registrationTicketFare.setStartingPost(ticketFare.getStartingPost());
			registrationTicketFare.setDestination(ticketFare.getDestination());
			registrationTicketFare.setPrice(ticketFare.getPrice());
			registrationTicketFare.setNote(ticketFare.getNote());
			session.save(registrationTicketFare);
			// session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public List<TicketFare> listTicketFare() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<TicketFare> cq = cb.createQuery(TicketFare.class);
	      Root<TicketFare> root = cq.from(TicketFare.class);
	      cq.select(root);
	      Query<TicketFare> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public Boolean updateTicketFare(TicketFare ticketFare) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(ticketFare);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public TicketFare getTicketFare(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			TicketFare model = session.byId(TicketFare.class).load(id);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

}
