package com.veni.javafiles;

public class Test {
	public static void main(String[] args) {
		//printHello();
		//addNumber();
		//addNumberWithArgument(1,10);
		//int x=addNumberWithArgumentWithReturn(1,2);
		//System.out.println("Square is "+(x*x));
		//String ab=addNumberWithNoArgumentButReturn();
		//System.out.println(ab+" My husband is also lucky to have me");
		System.out.println(addNumberWithNoArgumentButReturn());
	}
	
	//Function with no argument and no return value
	static void printHello()
	{
		for(int i=1;i<10;i++)
		{
			System.out.println("Hello India");
		}
	}
	//Function with no argument and no return value
	static void addNumber()
	{

		int a=5;
		int b=5;
		
		System.out.println((a+b));
		
	}
	//Function with  argument and no return value
	static void addNumberWithArgument(int a,int b)
	{
		System.out.println((a+b));
		
	}
	//Function with  argument and and return value
	static int addNumberWithArgumentWithReturn(int a,int b)
	{
		// return and square of the return vlue
		//System.out.println((a+b));
		//System.out.println((a+b));
		//return 5;
		return (a+b);
		
	}
	//	Function with  argument of different data types and no return value
	static void addNumberWithArgumentwithDifferntDatataype(int a,char b,String c)
	{
		b='1';
		c="asdasd";
		System.out.println();
	}
//	Function with no argument but return value
	static String addNumberWithNoArgumentButReturn()
	{
		
		return "I am lucky to have husband like Amit";
	}
}



