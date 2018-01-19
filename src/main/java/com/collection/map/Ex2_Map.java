package com.collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2_Map {

	public static void main(String[] args) {

/*		List<Country> listOfCountry = Arrays.asList(
										new Country("India"),
										new Country("Pakistan")
										);
		
		List<State> listOfState = Arrays.asList(
										new State("Karnataka"),
										new State("Maharasthra"),
										new State("AndhraPradesh"),
										new State("TamilNadu")
							);
		
		List<State> listOfState2 = Arrays.asList(
										new State("Lahore"),
										new State("Islamabad"),
										new State("Sindh")
							);
		List<List<State>> listOfAllStates = Arrays.asList(listOfState,listOfState2);
		
		HashMap<Country, List<State>> hm = new HashMap<Country, List<State>>();
		
		for (int i = 0; i < listOfCountry.size(); i++) {
			hm.put(listOfCountry.get(i), listOfAllStates.get(i));
		}
		
		hm.entrySet().forEach(System.out::println);*/
		
		List<String> listOfCountry = Arrays.asList("india","pakistan");

		List<String> listOfState = Arrays.asList("karnataka","maharasthra","andhraPradesh","tamilNadu");

		List<String> listOfState2 = Arrays.asList("lahore","islamabad","sindh");
		
		List<List<String>> listOfAllStates = Arrays.asList(listOfState,listOfState2);
		
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		
		for (int i = 0; i < listOfCountry.size(); i++) {
			hm.put(listOfCountry.get(i), listOfAllStates.get(i));
		}
		
		hm.entrySet().forEach(System.out::println);
		
		System.out.println("-------------------");
		//Q) To get all the states only...
		
		//Note streams are not there for MAP'S
		// soo we need to get Set<Entry> from Map 
		// syntax ->Set<Entry> vara =  hashMap_vara.entrySet();
		
		Set<Entry<String, List<String>>> keyValuePair = hm.entrySet();
		
		System.out.println("--------All the States are : --------------");
		
		//keyValuePair.forEach(System.out::println);
		
		keyValuePair.parallelStream()
					.map(arg ->{
							List<String> listOfStates = arg.getValue();
							return listOfStates;
					})
					.forEach(System.out::println);
		
		//Q) To get all the states only...
		
		System.out.println("--------All the countries are : ------------");
		keyValuePair.parallelStream()
					.map(arg ->{
							String countr = arg.getKey();
							return countr;
					})
					.forEach(System.out::println);
		
		//Q) To get all the states for India only(both key and Value)
		System.out.println("------All the states for India(both key and Value)-----");
		keyValuePair.parallelStream()
					.filter(arg->{
					String countr =	arg.getKey();
					return countr.equals("india");
					})
					.forEach(System.out::println);
		
		
		//Q) To get all the states for India  (Value only)
		System.out.println("------All the states for India(Value only)-----");
		keyValuePair.parallelStream()
					.filter(arg->{
					String countr =	arg.getKey();
					return countr.equals("india");
					})
					.map(arg -> {
						List<String> listOfStates = arg.getValue();
						return listOfStates;
					})
					.forEach(System.out::println);
		
		
		System.out.println("------customzie-----");
		//Q) To get all the states for India  (Value only)
		keyValuePair.parallelStream()
					.filter(arg-> arg.getKey().equals("india"))
					.map(arg -> {
								List<String> listOfStates = arg.getValue();
								return listOfStates;
								})
					.forEach(System.out::println);
		
		
		// above code we cannot sort bcoz listOfStates is List<String> values 
		// if the map value was only String of values then we could have sort
		// but the map value is ListOfString values...
		
	}

}
