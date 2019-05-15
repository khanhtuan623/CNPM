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

import com.tdt.carrental.model.Car;
import com.tdt.carrental.model.Schedule;

@Repository
@Transactional
public class ScheduleDaoImp implements ScheduleDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public boolean registrationSchedule(Schedule schedule) {
		try {
			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			Schedule registrationSchedule=new Schedule();
			registrationSchedule.setNameChannel(schedule.getNameChannel());
			registrationSchedule.setSpace(schedule.getSpace());
			registrationSchedule.setNumber(schedule.getNumber());
			registrationSchedule.setTimeOfDeparture(schedule.getTimeOfDeparture());
			registrationSchedule.setArrivalTime(schedule.getArrivalTime());
			registrationSchedule.setIdCar(schedule.getIdCar());
			session.save(registrationSchedule);
			// session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public List<Schedule> listSchedule() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Schedule> cq = cb.createQuery(Schedule.class);
	      Root<Schedule> root = cq.from(Schedule.class);
	      cq.select(root);
	      Query<Schedule> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public Boolean updateSchedule(Schedule schedule) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(schedule);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public Schedule getSchedule(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Schedule model = session.byId(Schedule.class).load(id);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteSchedule(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Schedule model = session.byId(Schedule.class).load(id);
			session.delete(model);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
