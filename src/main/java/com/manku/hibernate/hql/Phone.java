package com.manku.hibernate.hql;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {
	@Id
	private int pid;
	private String name;
	private double price;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Phone [pid=" + pid + ", name=" + name + ", price=" + price + "]";
	}

	
}
