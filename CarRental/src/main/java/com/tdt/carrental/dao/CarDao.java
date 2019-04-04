package com.tdt.carrental.dao;

import java.util.List;

import com.tdt.carrental.model.Car;
import com.tdt.carrental.model.Driver;

public interface CarDao {
	public abstract boolean signUp(Car car);

	public abstract List<Car> listCar();

	public abstract Boolean updateCar(Car car);

	public abstract Car getCar(String id);
}
