package com.library.model.domain;

import org.junit.Test;
import com.library.model.domain.Address;

import junit.framework.TestCase;

public class AddressTest extends TestCase{
	
	/**
	 * Tests with an address that is in Mounds View passed in
	 */
	@Test	
	public void testValidate() {
		Address veeralAddress = new Address ("7161 Pleasant View Drive", "Mounds View", "MN", "USA", 55112);
		assertTrue ("veeralAddress validates", veeralAddress.validate());
	       System.out.println("testValidate PASSED");
	}
	
		/**
		 * Tests with an address that is NOT in Mounds View passed in
		 */
		@Test(expected = IllegalArgumentException.class)
		public void FailValidate() {
			Address NonMVAddress = new Address ("1450 Brookshire Court", "New Brighton", "MN", "USA", 55112);
			assertFalse ("Address is NOT from Mounds View", NonMVAddress.getAddressValid());
		       System.out.println("FailValidate PASSED");		
		}
}
