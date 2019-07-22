package com.cg.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.beans.Product;

public class ProductpricedaoImpl {
	Map<Integer, Product> map= new HashMap<>();
	List<Product> productlist=new ArrayList<>();
	static int orderid=100;
	static int id=0;
	
	public List<Product> getAllProducts() {
		
		productlist.addAll(map.values());
		return productlist;
		
	}

	public boolean AddOrder(Product product1) {
		
	Product status=map.put(++orderid, product1);	
	System.out.println(status);
	if(status==null)	
	return true;
	else
	return false;
	}

	
}
