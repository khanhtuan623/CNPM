package com.tdt.carrental.dao;

import java.util.List;

import com.tdt.carrental.model.Customer;

public interface CustomerDao {
	public abstract boolean registrationCustomer(Customer cus);

	public abstract List<Customer> listCustomer();

	public abstract Boolean updateCustomer(Customer cus);

	public abstract Customer getCustomer(String tel);
}
