package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dto.Order;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Order get(int id) {
		return sessionFactory.getCurrentSession().get(Order.class, Integer.valueOf(id));
	}

	@Override
	public List<Order> list() {
		String selectActiveOrder = "FROM Order WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveOrder);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(Order order) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(order);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Order order) {
		try {
			
			sessionFactory.getCurrentSession().update(order);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Order order) {
		order.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().update(order);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
