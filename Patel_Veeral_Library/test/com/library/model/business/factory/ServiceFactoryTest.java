package com.library.model.business.factory;

import junit.framework.TestCase;

import com.library.model.business.exception.ServiceLoadException;
import com.library.model.services.factory.ServiceFactory;
import com.library.model.services.retreivalservice.IRetreivalService;
import com.library.model.services.retreivalservice.RetreivalServiceImpl;

/**
 * 
 * @author mike.prasad
 *
 */

public class ServiceFactoryTest extends TestCase {

	ServiceFactory serviceFactory;
	

	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();
	}

	public void testGetInstance() {
	       assertNotNull(serviceFactory);
	}

	public void testGetRetreivalService() {
 		IRetreivalService retreivalService;
		try {
			retreivalService = (IRetreivalService)serviceFactory.getService(IRetreivalService.NAME);
	  	    assertTrue(retreivalService instanceof RetreivalServiceImpl);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

}
