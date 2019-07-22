package com.cg.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cg.beans.Product;
import com.cg.dao.ProductpricedaoImpl;
import com.cg.exception.PriceException;
import com.cg.service.ProductpriceServiceImpl;
;

public class Main {
	static  int dollar=75;
	static String product;
	static String Choice;
	static  int quantity;
	 static int price;
	static  double amount;
	static ProductpriceServiceImpl service=new ProductpriceServiceImpl();
	static List<Product> list=new ArrayList<>();
	Scanner scanner=new Scanner(System.in);
     public static void main(String[] args) throws PriceException {
		Scanner scanner=new Scanner(System.in);
		Main obj=new Main();
		Map<String,Product> map=new HashMap<>();
		
		System.out.println("welcome to price calculation");
		do{
			System.out.println("1.calculate orderprice\n 2.display orders ");
		
		boolean choiceflag=false;
		
		    int choice=scanner.nextInt();
		    switch(choice) {
		    case 1: obj.addDetails();
		    break;
		    /*List<Product> productlist=dao.getAllProducts();
			display(productlist);
			System.out.println(productlist);
			*/
			
		    case 2:display();break;
		    default:System.out.println("Invalid Input");
			}
		    System.out.println("Want to Continue? Yes=y/No=n");
		     Choice=scanner.next();
		}while(Choice.equalsIgnoreCase("y"));
     }
	private void addDetails() {
		 System.out.println("enter 1.Pen \n 2.Mobile  ");
		 int option=scanner.nextInt();
		
		 if(option==1)
			  product ="Pen";
		  else if(option==2)
			  product="Mobile";
		  else
			  System.out.println(" enter option 1 or 2");
		 boolean quantityFlag=true;
		 do { System.out.println("enter quantity(in no): ");
		 			quantity = scanner.nextInt();
               
	  		 try {
	  			    quantityFlag=service.isQuantityValid(quantity);
		    	   if(!quantityFlag) 
		    	   {
	    	  	throw new PriceException("Invalid");
		    	   }
	  		 }
		    	   catch (PriceException e)
		    	   {
				e.printStackTrace();
		    	   }
		    	   catch(InputMismatchException e) 
		    	   {
		    		   
				System.err.println("enter only digits ");
		    	   }
		 }while(!quantityFlag);
		         boolean priceFlag=true;
		         do {
		        	 System.out.println("enter price for eachone(in dollars): ");
		        		Scanner scanner=new Scanner(System.in);
     	 			price=scanner.nextInt();
		        	 try {  
		        		     priceFlag=service.isPriceValid(price);
		        		 
		        	 			if(!priceFlag) {
		        	 				throw new PriceException("invalid price");
		        	 			}
		        	 }  catch (PriceException e)
			    	   {
		 				e.printStackTrace();
		 		    	   }
		 		    	   catch(InputMismatchException e) 
		 		    	   {
		 		    		  
		 				System.err.println("enter only digits ");
		 		    	   }
		         }while(!priceFlag);
	    	 
	    	  System.out.println(price);
	    	   amount=(price*dollar)*quantity;
	    	   double charges=(amount)*(1.25/100);
	    	   double total=amount+charges;
	           System.out.println("Amount(in rupees): "+amount+ "Conversion Charge :"+charges);
	           System.out.println("Total Amount :"+(total));
	           
	           Product product1 =new  Product(product,total,quantity);
	           boolean result=service.AddOrder(product1);
	           if(result)
	        	   System.out.println("Product Added Succesfully");
	           else
	        	   System.out.println("Not Added");
	 
		
	}

	private static void display() {
		List<Product> productlist=new ArrayList<>();
		list=service.getOrder();
		Iterator<Product> iterator=list.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next());
		
		
		
	}

}
