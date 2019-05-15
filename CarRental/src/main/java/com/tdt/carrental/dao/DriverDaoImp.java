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
public class DriverDaoImp implements DriverDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean signUp(Driver driver) {
		try {
			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			Driver driverSignUp=new Driver();
			driverSignUp.setNameDriver(driver.getNameDriver());
			driverSignUp.setTel(driver.getTel());
			driverSignUp.setOther(driver.getOther());
			driverSignUp.setExp(driver.getExp());
			session.save(driver);
			// session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public List<Driver> listDriver() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Driver> cq = cb.createQuery(Driver.class);
	      Root<Driver> root = cq.from(Driver.class);
	      cq.select(root);
	      Query<Driver> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public Boolean updateDriver(Driver driver) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(driver);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public Driver getDriver(Long idDriver) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Driver model = session.byId(Driver.class).load(idDriver);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteDriver(Long id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Driver model = session.byId(Driver.class).load(id);
			session.delete(model);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
