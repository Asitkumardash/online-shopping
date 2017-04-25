package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.CartItem;


public interface CartItemDAO {

	CartItem get(int id);
	List<CartItem> list();
	boolean add(CartItem cartitem);
	boolean update(CartItem cartitem);
	boolean delete(CartItem cartitem);
	
	List<CartItem> getByUserid(int userid);
	
	boolean productExists(int userid,int pid);
	CartItem getByPid(int userid,int pid);
	
	boolean placeOrder(CartItem cartitem);
	List<CartItem> getOrderedItems(int userid, int oid);
}