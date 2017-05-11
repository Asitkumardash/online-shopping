package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Orderitem;

public interface OrderiDAO {

	Orderitem get(int id);
	List<Orderitem> list();
	boolean add(Orderitem orderitem);
	boolean update(Orderitem orderitem);
	boolean delete(Orderitem orderitem);
	
}
