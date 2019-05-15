package com.tdt.carrental.services;

import java.util.List;

import com.tdt.carrental.model.Customer;

public interface CustomerServices {
	public abstract boolean registrationCustomer(Customer cus);

	public abstract List<Customer> listCustomer();

	public abstract Boolean updateCustomer(Customer cus);

	public abstract Customer getCustomer(String tel);
	
	public abstract void deleteCustomer(String tel);
}
