package com.tdt.carrental.services;

import java.util.List;

import com.tdt.carrental.model.ShoppingCart;

public interface ShoppingCartServices {
	public abstract boolean registrationShoppingCart(ShoppingCart shoppingCart);

	public abstract List<ShoppingCart> listShoppingCart();

	public abstract Boolean updateShoppingCart(ShoppingCart shoppingCart);

	public abstract ShoppingCart getShoppingCart(int id);
	
	public abstract void deleteShoppingCart(int id);
}
