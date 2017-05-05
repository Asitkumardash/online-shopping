package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.Order;
import com.niit.shoppingbackend.dto.UserTable;

public class OrderTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static OrderDAO orderDAO;
	
	private Order order;
	
	private static AddressDAO addressDAO;
	
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		orderDAO = (OrderDAO) context.getBean("orderDAO");
		
	}
	

	
	@Test
	public void testCRUDCategory() {
		//add operation
		order =new Order();
		
		UserTable user = userDAO.get(6);
		order.setUser(user);
		
		Address address = addressDAO.get(5);
		order.setAddress(address);
		order.setAmount(10000);
		order.setOrdered(false);
		order.setActive(true);
		//category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a cart inside the table",true,orderDAO.add(order));
		
		order =new Order();
		
		order.setUser(user);
		order.setAddress(address);
		order.setAmount(20000);
		order.setOrdered(false);
		order.setActive(true);
		//category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a cart inside the table",true,orderDAO.add(order));
		
		//fetchaing and updating
		order = orderDAO.get(2);
		
		order.setAmount(25000);
	
		assertEquals("Successfully updated a cart in the table",true,orderDAO.update(order));
		
		//delete the category
		order = orderDAO.get(2);
		assertEquals("Successfully deleted a cart in the table",true,orderDAO.delete(order));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a cart from the table",1,orderDAO.list().size());
		
	}
}
