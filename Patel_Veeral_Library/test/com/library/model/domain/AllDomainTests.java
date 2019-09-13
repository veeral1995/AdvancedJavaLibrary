package com.library.model.domain;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllDomainTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for com.library.model.domain");
		//$JUnit-BEGIN$
		suite.addTestSuite(AddressTest.class);
		suite.addTestSuite(BookTest.class);
		suite.addTestSuite(CDTest.class);
		suite.addTestSuite(CustomerTest.class);
		suite.addTestSuite(MovieTest.class);
		//$JUnit-END$
		
		return suite;
	}

}
