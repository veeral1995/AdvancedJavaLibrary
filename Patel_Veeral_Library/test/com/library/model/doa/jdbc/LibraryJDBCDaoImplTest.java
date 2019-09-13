/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.model.doa.jdbc;

import org.junit.Test;
import com.library.model.doa.jdbc.LibraryJDBCDaoImpl;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.services.exception.AvailibilityException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import junit.framework.TestCase;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

/**
 *
 * @author vpatel48
 */
public class LibraryJDBCDaoImplTest {
    
	LibraryJDBCDaoImpl jdbc = new LibraryJDBCDaoImpl();
        //AvailableItems results = jdbc.getAvailableItems();
        
	@Test	
	public void checkDBConnection() throws AvailibilityException, IOException, ClassNotFoundException {
            AvailableItems results = jdbc.getAvailableItems();
            assertTrue("Data Is Found in The DB", (results != null));
            
        }
	@Test
	public void checkResults() throws ClassNotFoundException, AvailibilityException, IOException, SQLException {
                Book harryPotter = new Book ("Harry Potter: Order of the Phoenix", "J.K. Rowling", 2001, 0, null, "600134234", 532342);
                boolean shouldBeFalse;
                AvailableItems results = jdbc.getAvailableItems();
		shouldBeFalse = jdbc.rentItem("600134234", "book");
		
		assertFalse ("Should Pose Invalid Update of DB", shouldBeFalse);
	}
	
}
