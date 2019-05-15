package com.tdt.carrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdt.carrental.dao.DriverDao;
import com.tdt.carrental.model.Driver;

@Service
@Transactional
public class DriverServicesImp implements DriverSevices {

	@Autowired
	private DriverDao driverDao;
	
	@Override
	public boolean signUp(Driver driver) {
		// TODO Auto-generated method stub
		return this.driverDao.signUp(driver);
	}

	@Override
	public List<Driver> listDriver() {
		// TODO Auto-generated method stub
		return this.driverDao.listDriver();
	}

	@Override
	public Boolean updateDriver(Driver driver) {
		// TODO Auto-generated method stub
		return this.driverDao.updateDriver(driver);
	}

	@Override
	public Driver getDriver(Long id) {
		// TODO Auto-generated method stub
		return this.driverDao.getDriver(id);
	}

	@Override
	public void deleterDriver(Long id) {
			this.driverDao.deleteDriver(id);		
	}

}
