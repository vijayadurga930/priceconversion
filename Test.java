package com.cg.pricetest;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.cg.beans.Product;
import com.cg.exception.PriceException;

import com.cg.service.ProductpriceServiceImpl;

public class Test {
	static ProductpriceServiceImpl service;
	Product product=null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service= new ProductpriceServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service=null;
	}

	@Before
	public void setUp() throws Exception {
		product= new Product("pen",100,10);
	}

	@After
	public void tearDown() throws Exception {
		product=null;
	}

	@org.junit.Test
	
		public void testisPriceValid() throws PriceException {
			assertNotNull(service.isPriceValid(10));
	}
	@org.junit.Test
	
	public void testisQuantityValid() throws PriceException {
		assertNotNull(service.isQuantityValid(100));
}
}
