package com.library.model.domain;


import org.junit.Test;

import junit.framework.TestCase;

public class CDTest extends TestCase{

	/**
	 * Tests with an Book that the Book Class validates
	 */
	@Test	
	public void testValidate() {
		CD CDTest = new CD ("Whitney Houston", "Whitney Houston", 1984, "34594234", 4573456);
		assertTrue ("CDTest validates", CDTest.validate());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	* This test method invokes the equals method of class CD, and then passes two objects, that are equal. 
	* If both objects are equal, the assertTrue statement will pass.
	*/
	@Test
	public void testEqualsTrue() {
		CD views = new CD ("Views", "Drake", 2016, "987643", 352342);
		CD viewsTrue = new CD ("Views", "Drake", 2016, "987643", 63453);
		
		assertFalse ("Both CDs Are Equal", views.equals(viewsTrue));
	}
	
	/**
	* This test method invokes the equals method of class CD, and then passes two objects, that are not equal. 
	* If both objects are equal, the assertFalse statement will pass.
	*/
	@Test
	public void testEqualsFail() {
		CD views = new CD ("Views", "Drake", 2016, "987643", 6793458);
		CD viewsFail = new CD ("Public Discontent", "Colbie", 2016, "987643", 1234);
		
		assertFalse ("Both CDs Are Not Equal", views.equals(viewsFail));
	}
}
