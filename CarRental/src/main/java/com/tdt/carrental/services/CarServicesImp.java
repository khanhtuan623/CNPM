package com.tdt.carrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdt.carrental.dao.CarDao;
import com.tdt.carrental.model.Car;

@Service
@Transactional
public class CarServicesImp implements CarServices{

	@Autowired
	private CarDao carDao;
	
	@Override
	public boolean signUp(Car car) {
		// TODO Auto-generated method stub
		return this.carDao.signUp(car);
	}

	@Override
	public List<Car> listCar() {
		// TODO Auto-generated method stub
		return this.carDao.listCar();
	}

	@Override
	public Boolean updateCar(Car car) {
		// TODO Auto-generated method stub
		return this.carDao.updateCar(car);
	}

	@Override
	public Car getCar(String id) {
		// TODO Auto-generated method stub
		return this.carDao.getCar(id);
	}

}
