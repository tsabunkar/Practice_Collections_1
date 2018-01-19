package com.collection.list;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex1_List {
	public static void main(String[] args) {
		ArrayList<String> listOfName = new ArrayList<String>();
		
		listOfName.add("Tejas");
		listOfName.add("Ravi");
		listOfName.add("Subash");
		listOfName.add("Tejas");
		
		ArrayList<String> listOfLastName = new ArrayList<String>();
		listOfLastName.add("Sabunkar");
		listOfLastName.add("Kumar");
		listOfLastName.add("B");
		
		//addAll() is used to add all the list of collection Obj(ie here string)
		//at onces inside the another list Of strings
		listOfName.addAll(listOfLastName);
		
		
	System.out.println("------list of last Names are :--------- ");
		for (String string : listOfLastName) {
			System.out.println(string);
		}
		
		System.out.println("------List of All Names are :---------");
		for (String string : listOfName) {
			System.out.println(string);
		}
		
		System.out.println("Size of listOfName List is : "+ listOfName.size());
		
		
		ArrayList<String> listOfLastNames2 = listOfLastName;
		System.out.println("------list of last Names are :--------- ");
		for (String string : listOfLastNames2) {
			System.out.println(string);
		}
		System.out.println("_____After Removing the 2 ele in the list of elements----");
		listOfLastNames2.remove(2);
		for (String string : listOfLastNames2) {
			System.out.println(string);
		}
		listOfLastNames2.add("Prashanth");
		System.out.println("______Iterating using Iterator______");
		Iterator<String> iter = listOfLastNames2.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		System.out.println("_________Iterating using Internal ForEach loop____");
		listOfLastName.forEach(System.out::println);
	}
	
	

}
