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
import com.tdt.carrental.model.Driver;

@Repository
@Transactional
public class CarDaoImp implements CarDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean signUp(Car car) {
		try {
			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			Car carSignUp=new Car();
			carSignUp.setIdCar(car.getIdCar());
			carSignUp.setDriver1(car.getDriver1());
			carSignUp.setDriver2(car.getDriver2());
			carSignUp.setOther(car.getOther());
			session.save(carSignUp);
			// session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public List<Car> listCar() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Car> cq = cb.createQuery(Car.class);
	      Root<Car> root = cq.from(Car.class);
	      cq.select(root);
	      Query<Car> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public Boolean updateCar(Car car) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(car);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public Car getCar(String id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Car model = session.byId(Car.class).load(id);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}
}
