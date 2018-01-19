package com.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex2_List {

	public static void main(String[] args) {

		ArrayList<Employee> listOfEmployee = new ArrayList<Employee>();
		listOfEmployee.add(new Employee(1, "ashish", 500000));
		listOfEmployee.add(new Employee(2, "shivu",4000000));
		listOfEmployee.add(new Employee(3, "ram", 230000));
		
		System.out.println("List of employess are :- ");
		for (Employee employee : listOfEmployee) {
			System.out.println(employee);
		}
		
		System.out.println("-----------New way of adding the list of Object inside the list ---------...");
		List<Employee> listOfEmployee2 = Arrays.asList(
				new Employee(1, "Tejas", 500000),
				new Employee(2, "Ravi",4000000),
				new Employee(3, "subash", 230000)
				);
		

		System.out.println("List of employess are using external forEachloop :- ");
		for (Employee employee : listOfEmployee2) {
			System.out.println(employee);
		}
		
		System.out.println("------------------------");
		
		//forEach() takes Consumer Functional Interface 
		//Consumer Interface method must return void DT 
		System.out.println("List of employess are using internal forEachLoop :- ");
		listOfEmployee2.forEach(argu -> System.out.println(argu));
		
		System.out.println("***************");
		
		
		//Q) To get Employee Object whose name starts with T
		
		// filter() takes Predicate Functional Interface
		//Predicate Interface method must return boolean DT
		listOfEmployee2.stream()
						.filter(
								argu -> {
								String	emplName = argu.getEmployeeName();
								return	emplName.startsWith("T");
								}
								)
						.forEach(argum -> System.out.println(argum));
		
		
		
		//Q) To get all the employeeNames only
		// map() takes Function Functional Interface
		// function Interface method can return any type of Datatype
		listOfEmployee2.parallelStream()
						.map(argu -> {
							return argu.getEmployeeName();
						})
						.forEach(argu -> System.out.println(argu));
		
		
		
		
		
		//Q) To get all the EmployeeNames only whose start Names start with T
		System.out.println("=++++++++++++++++++=");
		listOfEmployee2.parallelStream()
		.filter(
				argum -> {
				String	emplName = argum.getEmployeeName();
				return	emplName.startsWith("T");
				}
				)
		.map(argu -> {
			return argu.getEmployeeName();
		})
		.forEach(argu -> System.out.println(argu));
			
		System.out.println("**************************************");
		System.out.println("**************************************");
		
		List<Employee> listOfEmployee3 = Arrays.asList(
				new Employee(1, "aldo", 50),
				new Employee(2, "cdfeee",40),
				new Employee(3, "bgbv", 63),
				new Employee(4, "zfzz", 30),
				new Employee(5, "khkk", 2)
				);
		
		
		//sorted () takes nothing as input param or
		// takes Comparator  functional Interface 
		//Comparator Interface - int compare(T arg0, T arg1);

		//collect() takes Collector functional interface.
		
		System.out.println("______________ASCE_SORT____________________");
		listOfEmployee3.parallelStream()
		.map(argu -> {
			return argu.getEmployeeName();
		})
		.sorted() //by default sort is ASC
		.collect(Collectors.toList()) // with sorted() must use collect().
		.forEach(System.out::println);  // :: is called -> Method Reference operator
										// synatx is 
										//static method->(ClassName :: methodName)
										//non-static method-> (instanceRef::methName)
		
		System.out.println("____________DESC_SORT______________________");

		listOfEmployee3.parallelStream()
		.map(argu -> {
			return argu.getEmployeeName();
		})
		.sorted((arg1, arg2) -> arg2.compareTo(arg1))
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		
		System.out.println("-------------OR-----------------------");
		
		listOfEmployee3.parallelStream()
		.map(argu -> {
			return argu.getEmployeeName();
		})
		.sorted((arg1,arg2) -> {
			char c1 = arg1.charAt(0);
			char c2 = arg2.charAt(0);
				
			return c1-c2;  // for ascending
			// return c2 - c1 ; // for descending
		})
		.collect(Collectors.toList())
		.forEach(argu -> System.out.println(argu));

		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		//Q) All the sorted ASC Names of employee whose salary is b/w (1,50)
		
		listOfEmployee3.parallelStream()
		.filter(arg ->{
			double EmpSalary = arg.getSalary();
			if(EmpSalary>=1 && EmpSalary<=50)
				return true;
			else
				return false;
		})
		.map(argu -> {
			return argu.getEmployeeName();
		})
		.sorted() 
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		
		
		// or 
		
		
		System.out.println("----------Using ternery operator---------------");
		listOfEmployee3.parallelStream()
		.filter(arg ->{
			double EmpSalary = arg.getSalary();
			return (EmpSalary>=1 && EmpSalary<=50) ? true : false; 
		})
		.map(argu -> {
			return argu.getEmployeeName();
		})
		.sorted() 
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		
		System.out.println("----------customize the code --------------");
		// if lambda function body is one line then remove the return keyword
		// terminating the semi-colon ;
		
		listOfEmployee3.parallelStream()
		.filter(arg ->arg.getSalary()>=1 && arg.getSalary()<=50 ? true : false)
		.map(Employee::getEmployeeName)
		.sorted() 
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
	}

}
