package com.collection.map;

public class Country {
 private String countryName;

 
public String getCountryName() {
	return countryName;
}


public void setCountryName(String countryName) {
	this.countryName = countryName;
}




public Country(String countryName) {
	super();
	this.countryName = countryName;
}


@Override
public String toString() {
	return "Country [countryName=" + countryName + "]";
}
 
 
}
