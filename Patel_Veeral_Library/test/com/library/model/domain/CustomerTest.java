package com.library.model.domain;

import org.junit.Test;

import junit.framework.TestCase;

public class CustomerTest extends TestCase{

	/**
	 * Tests with an Customer that the Customer Class validates
	 */
	@Test	
	public void testValidate() {
		Address veeralAddress = new Address ("7161 Pleasant View Drive", "Mounds View", "MN", "USA", 55112);
		Customer VeeralCustomer = new Customer("Veeral", "Patel", "veeral1995@gmail.com", 414787488, "veeral1995", "testPassword", veeralAddress);
		
		assertTrue ("VeeralCustomer validates", VeeralCustomer.validate());
	       System.out.println("testValidate PASSED");
	}

}
