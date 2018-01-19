package com.collection.map;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Ex1_Map {

	public static void main(String[] args) {

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "tejas");
		hm.put(2, "usha");
		hm.put(3, "shailesh");
		hm.put(3, "yash");  //for every unique key we shld have unique value.
							//or else the latest value will re-write the prev value for that key
		

		System.out.println("To get all the keys using hashMap_Var");
		Set<Integer> mykeys = hm.keySet();
		mykeys.forEach(System.out::println);
		
		System.out.println("To get both keys and values using hashMap_Var");
		Set<Entry<Integer, String>> setOfStr = hm.entrySet();
		
		for (Entry<Integer, String> entry : setOfStr) {
			Integer keysAre = entry.getKey();
			String valuesAre = entry.getValue();
			System.out.println(keysAre+","+valuesAre);
		}
		
		System.out.println("-----------or-----------");
		setOfStr.forEach(System.out::println);
		
		System.out.println("----------------------------------");
		
		
		
	}

}
