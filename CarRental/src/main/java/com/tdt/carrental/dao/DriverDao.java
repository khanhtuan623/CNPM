package com.tdt.carrental.dao;

import java.util.List;

import com.tdt.carrental.model.Driver;

public interface DriverDao {
	public abstract boolean signUp(Driver driver);

	public abstract List<Driver> listDriver();

	public abstract Boolean updateDriver(Driver driver);
	public abstract Driver getDriver(Long id);

}
