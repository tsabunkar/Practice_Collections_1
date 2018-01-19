package com.collection.list;

public class Employee {
	private int eid;
	private String employeeName;
	private double salary;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	public Employee(int eid, String employeeName, double salary) {
		super();
		this.eid = eid;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", employeeName=" + employeeName + ", salary=" + salary + "]";
	}
	
	

}
