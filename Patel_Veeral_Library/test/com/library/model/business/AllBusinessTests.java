package com.library.model.business;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.library.model.business.factory.ServiceFactoryTest;
import com.library.model.business.manager.RentItemsManagerTest;
import com.library.model.business.manager.SearchItemsManagerTest;

/**
 * @author veeral patel
 *
 *This test suite will test the business class via the TUNIT test case
 */

@RunWith(Suite.class)
@SuiteClasses({ SearchItemsManagerTest.class, RentItemsManagerTest.class, ServiceFactoryTest.class})
public class AllBusinessTests {

}
