package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.OrderiDAO;
import com.niit.shoppingbackend.dto.Order;
import com.niit.shoppingbackend.dto.Orderitem;

@Repository("orderiDAO")
@Transactional
public class OrderiDAOImpl implements OrderiDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Orderitem get(int id) {
		return sessionFactory.getCurrentSession().get(Orderitem.class, Integer.valueOf(id));
	}

	@Override
	public List<Orderitem> list() {
		String selectActiveOrder = "FROM Orderitem WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveOrder);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(Orderitem orderitem) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(orderitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean update(Orderitem orderitem) {
		try {
			
			sessionFactory.getCurrentSession().update(orderitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Orderitem orderitem) {
		orderitem.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().update(orderitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
