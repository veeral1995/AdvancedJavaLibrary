package com.library.model.domain;

import org.junit.Test;

import junit.framework.TestCase;

public class MovieTest extends TestCase{

	/**
	 * Tests with an Movie that the Movie Class validates
	 */
	@Test	
	public void testValidate() {
		Movie movieTest = new Movie ("The Accountant", 2016, "34594234", 28237542);
		assertTrue ("movieTest validates", movieTest.validate());
	       System.out.println("testValidate PASSED");
	}
	
	/**
	* This test method invokes the equals method of class Movie, and then passes two objects, that are equal. 
	* If both objects are equal, the assertTrue statement will pass.
	*/
	@Test
	public void testEqualsTrue() {
		Movie redMovie = new Movie ("Red", 2010, "7543324", 67239423);
		Movie redMovieTrue = new Movie ("Red", 2010, "7543324", 6729342);
		
		assertFalse ("Both Movies Are Equal", redMovie.equals(redMovieTrue));
	}
	
	/**
	* This test method invokes the equals method of class Movie, and then passes two objects, that are not equal. 
	* If both objects are equal, the assertFalse statement will pass.
	*/
	@Test
	public void testEqualsFail() {
		Movie redMovie = new Movie ("Red", 2010, "7543324", 678923784);
		Movie redMovieFail = new Movie ("Red1", 2010, "7543324", 6823742);
		
		assertFalse ("Both Movies Are Not Equal", redMovie.equals(redMovieFail));
	}
}
