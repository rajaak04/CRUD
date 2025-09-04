package com.example.crud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="crud")
public class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long id;
	
	String e_name;
	String e_salary;
	String e_dept;
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_salary() {
		return e_salary;
	}
	public void setE_salary(String e_salary) {
		this.e_salary = e_salary;
	}
	public String getE_dept() {
		return e_dept;
	}
	public void setE_dept(String e_dept) {
		this.e_dept = e_dept;
	}
	
	
	
	
}
