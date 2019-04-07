package com.tdt.carrental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdt.carrental.dao.ShoppingCartDao;
import com.tdt.carrental.model.ShoppingCart;

@Service
@Transactional
public class ShoppingCartServicesImp implements ShoppingCartServices {

	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	@Override
	public boolean registrationShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.registrationShoppingCart(shoppingCart);
	}

	@Override
	public List<ShoppingCart> listShoppingCart() {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.listShoppingCart();
	}

	@Override
	public Boolean updateShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.updateShoppingCart(shoppingCart);
	}

	@Override
	public ShoppingCart getShoppingCart(int id) {
		// TODO Auto-generated method stub
		return this.shoppingCartDao.getShoppingCart(id);
	}

}
