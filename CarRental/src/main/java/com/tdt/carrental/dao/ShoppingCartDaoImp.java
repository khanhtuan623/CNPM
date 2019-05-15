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
import com.tdt.carrental.model.ShoppingCart;

@Repository
@Transactional
public class ShoppingCartDaoImp implements ShoppingCartDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean registrationShoppingCart(ShoppingCart shoppingCart) {
		try {
			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			ShoppingCart shoppingCartRegis=new ShoppingCart();
			
			shoppingCartRegis.setIdTicket(shoppingCart.getIdTicket());
			shoppingCartRegis.setTel(shoppingCart.getTel());
			shoppingCartRegis.setChair(shoppingCart.getChair());
			shoppingCartRegis.setTotal(shoppingCart.getTotal());
			shoppingCartRegis.setDateOfDeparture(shoppingCart.getDateOfDeparture());
			shoppingCartRegis.setIdMethod(shoppingCart.getIdMethod());
			shoppingCartRegis.setStatus(shoppingCart.getStatus());
			session.save(shoppingCart);
			// session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public List<ShoppingCart> listShoppingCart() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<ShoppingCart> cq = cb.createQuery(ShoppingCart.class);
	      Root<ShoppingCart> root = cq.from(ShoppingCart.class);
	      cq.select(root);
	      Query<ShoppingCart> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public Boolean updateShoppingCart(ShoppingCart shoppingCart) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(shoppingCart);
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
			// TODO: handle exception
		}
	}

	@Override
	public ShoppingCart getShoppingCart(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			ShoppingCart model = session.byId(ShoppingCart.class).load(id);
			return model;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public void deleteShoppingCart(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			ShoppingCart model = session.byId(ShoppingCart.class).load(id);
			session.delete(model);
		} catch (Exception e) {
			e.getMessage();
		}
		
	}

}
