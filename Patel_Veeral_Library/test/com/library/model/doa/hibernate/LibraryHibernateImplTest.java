/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.model.doa.hibernate;

import com.library.model.doa.jdbc.LibraryJDBCDaoImpl;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.services.exception.AvailibilityException;
import java.io.IOException;
import java.sql.SQLException;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vpatel48
 */
public class LibraryHibernateImplTest {
    
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
	public static LibraryHibernateDaoImpl hib = new LibraryHibernateDaoImpl();
        //AvailableItems results = jdbc.getAvailableItems();
        
	@Test	
	public void checkDBConnection() throws AvailibilityException, IOException, ClassNotFoundException {
            AvailableItems results = hib.getAvailableItems();
            assertTrue("Data Is Found in The DB", (results != null));
            
        }
	@Test
	public void checkResults() throws ClassNotFoundException, AvailibilityException, IOException, SQLException {
                Book harryPotter = new Book ("Harry Potter: Order of the Phoenix", "J.K. Rowling", 2001, 0, null, "600134234", 532342);
                boolean result;
                AvailableItems results = hib.getAvailableItems();
                result = hib.rentItem("600134234", "book");
		
		assertFalse ("Should Pose Invalid Update of DB", result);
	}
	
}
