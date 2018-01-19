package com.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1_Set {

	public static void main(String[] args) {

		HashSet<Car> setOfCar = new HashSet<Car>();
		setOfCar.add(new Car(1, "Audi", "petrol"));
		setOfCar.add(new Car(2, "Benz", "disel"));
		setOfCar.add(new Car(3, "Merceds", "petrol"));
		setOfCar.add(new Car(1, "Audi", "petrol"));
		
		for (Car car : setOfCar) {
			System.out.println(car);
		}
		
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''");
		HashSet<String> setOfNames2 = new HashSet<String>();
		setOfNames2.add("Tejas");
		setOfNames2.add("Usha");
		setOfNames2.add("Shailesh");
		setOfNames2.add("Tejas"); //duplicate is not added
		setOfNames2.forEach(System.out::println);
		
		
		System.out.println("''''''''''''''''''''''''''''''''''''''''''''''");
		HashSet<String> setOfNames = new HashSet<String>();
		List<String> listOfNames = Arrays.asList("Tejas","Usha","Shailesh","Tejas");
		setOfNames.addAll(listOfNames);
		
		
		setOfNames.forEach(System.out:: println);
		//let me remove Shailesh
		System.out.println("-=-=-=-=-=-=-=-=-=-");
		listOfNames.forEach(System.out::println);
		setOfNames.remove("Shailesh");
		System.out.println("______After Removing _________");
		setOfNames.forEach(System.out::println);
		
		System.out.println("--------------------------------------------------------------");
		HashSet<Car> setOfCars2 = new HashSet<Car>();
		setOfCars2.addAll(Arrays.asList(new Car(1, "Maruti", "petrol"),
										new Car(2, "Santro", "disel"),
										new Car(3,"Audi", "petrol"),
										new Car(4,"Benz", "disel"),
										new Car(5,"honda", "petrol"),
										new Car(5,"honda", "petrol")
							));
		
		setOfCars2.forEach(System.out::println);
		System.out.println("*********************************************************************");
		//I want all carName in sorted ASC order which has only disel type
		setOfCars2.stream()
				.filter(arg ->{
					String carObjWithCtype = arg.getCtype();
					return carObjWithCtype.equals("disel");
				})
				.map(arg -> {
					return arg.getCname();
				})
				.sorted()
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		
		System.out.println("---------------customizing the above code-------------");
		setOfCars2.parallelStream()
				.filter(arg -> arg.getCtype().equals("petrol"))
				.map(Car::getCname)
				.sorted()
				.collect(Collectors.toList())
				.forEach(System.out:: println);
		
		
		System.out.println("%%%%%%%%%%%%%%%%%%% Removed Duplication %%%%%%%%%%%%%%%%%%%%%%%%%%%%");
List<String> listOfCarName =  setOfCars2.parallelStream()
										.filter(arg -> arg.getCtype().equals("petrol"))
										.map(Car::getCname)
										.sorted()
										.collect(Collectors.toList());

Set<String> setOfCarName = new HashSet<String>();
setOfCarName.addAll(listOfCarName);
setOfCarName.forEach(System.out::println);
	}

}
