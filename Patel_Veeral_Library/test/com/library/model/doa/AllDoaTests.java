package com.library.model.doa;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.library.model.doa.hibernate.LibraryHibernateImplTest;
import com.library.model.doa.jdbc.LibraryJDBCDaoImplTest;

/**
 * @author veeral patel
 *
 *This test suite will test the business class via the TUNIT test case
 */

@RunWith(Suite.class)
@SuiteClasses({ LibraryJDBCDaoImplTest.class, LibraryHibernateImplTest.class })
public class AllDoaTests {

}
