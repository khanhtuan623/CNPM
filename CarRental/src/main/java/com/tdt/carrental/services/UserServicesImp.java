package com.tdt.carrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdt.carrental.dao.UserDao;
import com.tdt.carrental.model.User;

@Service
@Transactional
public class UserServicesImp implements UserServices {

	@Autowired
	private UserDao userDao;
	
	@Override
	public Boolean checkLogIn(User user) {
		// TODO Auto-generated method stub
		return this.userDao.checkLogIn(user);
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return this.userDao.listUser();
	}

	@Override
	public boolean signUp(User signUp) {
		// TODO Auto-generated method stub
		return this.userDao.signUp(signUp);
	}

}
