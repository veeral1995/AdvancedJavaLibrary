package com.library.model.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.library.model.services.factory.ServiceFactoryTest;
import com.library.model.services.manager.PropertyManagerTest;
import com.library.model.services.rentalservice.RentalServiceImplTest;
import com.library.model.services.retreivalservice.RetreivalServiceImplTest;

/**
*
* @author Veeral Patel
*
*This test class will call the services that we have to test them
*/

@RunWith(Suite.class)
@SuiteClasses({ ServiceFactoryTest.class, RetreivalServiceImplTest.class, RentalServiceImplTest.class, PropertyManagerTest.class })
public class AllServicesTests {

}
