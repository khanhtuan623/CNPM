package com.tdt.carrental.services;

import java.util.List;

import com.tdt.carrental.model.Driver;

public interface DriverSevices {
	public abstract boolean signUp(Driver driver);

	public abstract List<Driver> listDriver();
	
	public abstract Boolean updateDriver(Driver driver);

	public abstract Driver getDriver(Long id);

}
