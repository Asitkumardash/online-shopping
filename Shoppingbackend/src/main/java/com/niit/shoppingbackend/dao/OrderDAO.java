package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Order;

public interface OrderDAO {

	Order get(int id);
	List<Order> list();
	boolean add(Order order);
	boolean update(Order order);
	boolean delete(Order order);
	
}
