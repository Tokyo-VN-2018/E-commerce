package com.onlinestore.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "username")
	private User user;
	
	private Date orderdate;
	@Column(nullable=false, columnDefinition = "bit default 0")
	private boolean status;
	private double amount;
	private String customer;
	private String phone;
	private String address;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<OrderItem> orderitems  = new HashSet<>();
	
	public void setOrderID(int order_id) {
		this.order_id=order_id;
	}
	public int getOrderID() {
		return order_id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setOrderDate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Date getOrderDate() {
		return orderdate;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean getStatus() {
		return status;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmount() {
		return amount;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomer() {
		return customer;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
}