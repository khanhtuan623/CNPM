package com.tdt.carrental.dao;

import java.util.List;

import com.tdt.carrental.model.User;

public interface UserDao {
	public abstract boolean signUp(User signUp);
	public abstract Boolean checkLogIn(User user);
	public abstract List<User> listUser();
}
