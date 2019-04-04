package com.tdt.carrental.services;

import java.util.List;

import com.tdt.carrental.model.User;

public interface UserServices {
	public abstract boolean signUp(User signUp);
	public abstract Boolean checkLogIn(User user);
	public abstract List<User> listUser();
}
