package com.manku.hibernate.relations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="laptop")
public class Laptop {
	@Id
	private int lid;
	private String lname;
	@ManyToMany(mappedBy = "laps",fetch = FetchType.EAGER)
	private List<Student> stu=new ArrayList<Student>();
	
	public List<Student> getStu() {
		return stu;
	}
	public void setStu(List<Student> stu) {
		this.stu = stu;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
