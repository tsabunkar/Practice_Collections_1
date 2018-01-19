package org.OOPS_Practice;

public class App 
{
	
    public static void main( String[] args )
    {
    	Parent_App pApp = new Child_App(); //upcasting
    	System.out.println(pApp.name);
    	pApp.m1();
    	// All the child prop (ie both data member and member fun) are hidden.
    	// when upcasted to parent Class
    	
    	System.out.println("--------Downcasting--------");
    	//Cannot directly downcast from Parent_App -> Child_App
    	//we should first upcast and then downcast
    	Parent_App pApp1 = new Child_App(); //upcasting
    	Child_App cApp = (Child_App) pApp1; 
    	//for downcasting we need to write explicitly the casting statm 
    	// and also don't write the new keyword.
    	System.out.println(cApp.name +","+ cApp.name1);
    	cApp.m1();
    	cApp.m2();
    }
}
class Parent_App{
	
	String name="parentVara";
	void m1(){
		System.out.println("m1() of Parent_App");
	}
}

class Child_App extends Parent_App{
	
	String name1="childVara";
	void m2(){
		System.out.println("m1() of Child_App");
	}
}
