package com.collection.set;

public class Car {

	private int cid;
	private String cname;
	private String ctype;
	
	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCtype() {
		return ctype;
	}


	public void setCtype(String ctype) {
		this.ctype = ctype;
	}


	public Car(int cid, String cname, String ctype) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ctype = ctype;
	}


	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cname=" + cname + ", ctype=" + ctype + "]";
	}
	
	
}
