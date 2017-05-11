package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Orderitem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oitemid;
	
	@OneToOne
	@JoinColumn(name="orderid")
	private Order order;
	
	@Column
	private int uid;
	
	@OneToOne
	@JoinColumn(name="pid")
	private Product product;
	
	@Column 
	private int quantity;
	
	@Column
	private long itotal;
	
	@OneToOne
	@JoinColumn(name="addid")
	private Address address;

	@Column(name="is_active")
	private boolean active = true;

	public int getOitemid() {
		return oitemid;
	}

	public void setOitemid(int oitemid) {
		this.oitemid = oitemid;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getItotal() {
		return itotal;
	}

	public void setItotal(long itotal) {
		this.itotal = itotal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Orderitem [oitemid=" + oitemid + ", order=" + order + ", uid=" + uid + ", product=" + product
				+ ", quantity=" + quantity + ", itotal=" + itotal + ", address=" + address + ", active=" + active + "]";
	}
	
	
}
