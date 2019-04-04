package com.tdt.carrental.services;

import java.util.List;

import com.tdt.carrental.model.Car;

public interface CarServices {
	public abstract boolean signUp(Car car);

	public abstract List<Car> listCar();

	public abstract Boolean updateCar(Car car);

	public abstract Car getCar(String id);
}
