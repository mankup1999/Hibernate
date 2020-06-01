package com.manku.hibernate.relations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="student")
public class Student {
	@Id
	private int id;
	private String name;
	/*
	@OneToOne
	private Laptop lap;
	public Laptop getLap() {
		return lap;
	}
	public void setLap(Laptop lap) {
		this.lap = lap;
	}
	*/
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Laptop> laps=new ArrayList<Laptop>();
	public List<Laptop> getLaps() {
		return laps;
	}
	public void setLaps(List<Laptop> laps) {
		this.laps = laps;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
