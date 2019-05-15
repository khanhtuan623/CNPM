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

import com.tdt.carrental.model.Customer;
import com.tdt.carrental.model.Schedule;

@Repository
@Transactional
public class CustomerDaoImp implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean registrationCustomer(Customer cus) {
		try {
			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			Customer customerRes=new Customer();
			customerRes.setTel(cus.getTel());
			customerRes.setFullName(cus.getFullName());
			customerRes.setAddress(cus.getAddress());
			customerRes.setEmail(cus.getEmail());
			customerRes.setIdNumber(cus.getIdNumber());
			session.save(customerRes);
			// session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public List<Customer> listCustomer() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
	      Root<Customer> root = cq.from(Customer.class);
	      cq.select(root);
	      Query<Customer> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public Boolean updateCustomer(Customer cus) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(cus);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public Customer getCustomer(String tel) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Customer model = session.byId(Customer.class).load(tel);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteCustomer(String tel) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Customer model = session.byId(Customer.class).load(tel);
			session.delete(model);
		} catch (Exception e) {
			e.getMessage();
		}
				
	}

}
