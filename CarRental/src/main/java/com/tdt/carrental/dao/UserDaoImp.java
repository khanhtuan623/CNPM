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

import com.tdt.carrental.model.User;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean checkLogIn(User user) {
		for(User userDB:this.listUser()) {
			if(userDB.getUserName().equals(user.getUserName())&&userDB.getPassWord().equals(user.getPassWord()))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> listUser() {
		Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<User> cq = cb.createQuery(User.class);
	      Root<User> root = cq.from(User.class);
	      cq.select(root);
	      Query<User> query = session.createQuery(cq);
	      return query.getResultList();
	}

	@Override
	public boolean signUp(User signUp) {
		try {
			Session session = sessionFactory.getCurrentSession();
			// session.beginTransaction();
			User user=new User();
			user.setUserName(signUp.getUserName());
			user.setPassWord(signUp.getPassWord());
			user.setEmail(signUp.getEmail());
			user.setFullName(signUp.getFullName());
			session.save(user);
			// session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

}
