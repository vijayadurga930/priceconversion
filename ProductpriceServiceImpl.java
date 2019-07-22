package com.cg.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cg.beans.Product;
import com.cg.dao.IProductpricedao;
import com.cg.dao.ProductpricedaoImpl;


public class ProductpriceServiceImpl implements IProductprice {
  ProductpricedaoImpl dao=new ProductpricedaoImpl();
    List<Product> productList=new ArrayList<>();
    
	public List<Product> getOrder() {
	productList=dao.getAllProducts();
		return productList;
	}

	public boolean AddOrder(Product product1) {
		boolean result=dao.AddOrder(product1);
		
		return result;
	}

	public boolean isQuantityValid(int quantity) {
	  boolean result1=true;
		if(quantity>1) {
			return result1;
		}else
		return (!result1);
	}

	public boolean isPriceValid(int price) {
		boolean result2=true;
		if(price>1) {
			return result2;
		}
		else
		return (!result2);
	
	}
	
	

}
