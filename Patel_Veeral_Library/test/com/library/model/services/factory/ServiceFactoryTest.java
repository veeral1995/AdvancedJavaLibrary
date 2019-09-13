package com.library.model.services.factory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.library.model.business.exception.ServiceLoadException;
import com.library.model.services.retreivalservice.IRetreivalService;
import com.library.model.services.retreivalservice.RetreivalServiceImpl;

/**
 * 
 * @author Veeral Patel
 * 
 * This ServiceFactoryTest will test if we can retrieve the services. It needs the application.properties file to load
 *
 */
public class ServiceFactoryTest {

	ServiceFactory serviceFactory;

	@Before
	public void setUp() throws Exception {
		serviceFactory = ServiceFactory.getInstance();
	}


	@Test
	public void testGetRetreivalService() {
		IRetreivalService retreivalService;
		try {
			retreivalService = (IRetreivalService) serviceFactory.getService(IRetreivalService.NAME);
			assertTrue(retreivalService instanceof RetreivalServiceImpl);
			System.out.println("testGetRetreivalService PASSED");
		} catch (ServiceLoadException e) {
			e.printStackTrace();
			fail("ServiceLoadException");
		}
	}

}
