package com.tdt.carrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdt.carrental.dao.CustomerDao;
import com.tdt.carrental.model.Customer;

@Service
@Transactional
public class CustomerServicesImp implements CustomerServices {

	@Autowired
	private CustomerDao customerDao;
	@Override
	public boolean registrationCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return this.customerDao.registrationCustomer(cus);
	}

	@Override
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		return this.customerDao.listCustomer();
	}

	@Override
	public Boolean updateCustomer(Customer cus) {
		// TODO Auto-generated method stub
		return this.customerDao.updateCustomer(cus);
	}

	@Override
	public Customer getCustomer(String tel) {
		// TODO Auto-generated method stub
		return this.customerDao.getCustomer(tel);
	}

}
