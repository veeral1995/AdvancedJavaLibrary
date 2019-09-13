
package com.library.model.doa.jdbc;

import com.library.model.services.manager.PropertyManager;
import com.library.model.doa.ILibraryDao;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.Movie;
import com.library.model.domain.RentalItem;
import com.library.model.services.exception.AvailibilityException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 *
 * @author vpatel48
 */
public class LibraryJDBCDaoImpl implements ILibraryDao {

 	static Logger log = Logger.getLogger("com.library.model.doa.jdbc:LibraryJDBCDaoImpl.java");
			
        private Connection fetchConnection() throws ClassNotFoundException
            {
		log.info("Fetching Database Connection");

		Connection conn = null;
		String url      = PropertyManager.getPropertyValue("jdbc.url");
		String userid   = PropertyManager.getPropertyValue("jdbc.user");
		String password = PropertyManager.getPropertyValue("jdbc.password");

		//load and register JDBC driver then connect to database
		try
		{
                        Driver myDriver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(myDriver);
			conn = DriverManager.getConnection(url, userid, password);
		}
		catch (SQLException e)
		{
			log.debug(e.getMessage());         
		}
			return conn;
            }

public AvailableItems getAvailableItems() throws AvailibilityException, IOException, ClassNotFoundException{
        boolean status = false;
							
	log.info("Using JDBC");
        log.info("Inside Get Available Items");

	AvailableItems availableItems = returnAllAvailableItems();

	if (availableItems != null){
            status = true;
	}
	return availableItems;
} //end getAvailableRentals

private AvailableItems returnAllAvailableItems() throws AvailibilityException, IOException, ClassNotFoundException{
	AvailableItems availableItems = null;
	ResultSet bkSet = null;
        ResultSet mvSet = null;
        ResultSet cdSet = null;
	Statement stmt = null, stmt1, stmt2 = null;
	Connection conn = null, conn1, conn2 = null;
	
	try
	{
            conn = fetchConnection(); 
            conn1 = fetchConnection(); 
            conn2 = fetchConnection(); 
            
            if (conn != null){	
                log.info("Connection worked");
		stmt = conn.createStatement();
                stmt1 = conn1.createStatement();
                stmt2 = conn2.createStatement();
		bkSet = stmt.executeQuery ("Select bookTitle, bookAuthor, releaseYear, catalogNumber, IBSN, availibility From sys.book WHERE availibility = 0;");
                cdSet = stmt1.executeQuery ("Select cdTitle, cdArtist, releaseYear, catalogNumber, availibility From sys.cd WHERE availibility = 0;");
                mvSet = stmt2.executeQuery ("Select movieTitle, releaseYear, catalogNumber, availibility From sys.movie WHERE availibility = 0;");

		availableItems = buildAvailableItems(cdSet, mvSet, bkSet);
            }
	}
	catch(SQLException e){
            log.debug(e.getMessage());
	}
	finally{
		try{
                    if (stmt != null){
			stmt.close();
                    }
                    if (conn != null) {
			conn.close();
                    }												
                }
		catch (SQLException e){									
                    log.debug(e.getMessage());									
		} 
	}						
    return availableItems;
} 


private AvailableItems buildAvailableItems (ResultSet cdSet, ResultSet movieSet, ResultSet bookSet) throws AvailibilityException, IOException, SQLException{
	log.info("Inside buildAvailableItems");
	AvailableItems availableItems = null;
						
	try{
            if (cdSet.isBeforeFirst()){	
		availableItems = new AvailableItems();
            }
            while (cdSet.next()){
                //cdTitle, cdArtist, releaseYear, catalogNumber
		CD cd = new CD(cdSet.getString(1), cdSet.getString(2), cdSet.getInt(3), cdSet.getString(4), cdSet.getInt(5));
		availableItems.addCD(cd);
            }
            } 
            catch (SQLException e){								
		log.debug(e.getMessage());
            }
        try{
            cdSet.close();
            while (movieSet.next()){
		Movie movie = new Movie(movieSet.getString(1),  movieSet.getInt(2),  movieSet.getString(3), movieSet.getInt(4));
		availableItems.addMovie(movie);
            }
            } 
            catch (SQLException e){								
		log.debug(e.getMessage());
            }
        try{
            movieSet.close();
            while (bookSet.next()){
		Book book = new Book(bookSet.getString(1), bookSet.getString(2), bookSet.getInt(3), bookSet.getInt(4), bookSet.getDate(5) ,bookSet.getString(6), bookSet.getInt(7));
		availableItems.addBook(book);
            }
            } 
            catch (SQLException e){								
		log.debug(e.getMessage());
            }
	return availableItems;
}


    public boolean rentItem(String catalogNumber, String type) throws ClassNotFoundException, SQLException {
        
	Statement stmt = null;
	Connection conn = null;
        int response = 0;
	String queryString = "UPDATE sys."+type+" SET availibility = 1, returnDate = DATE_ADD(CURDATE(), INTERVAL 21 DAY) WHERE catalogNumber = " + catalogNumber + ";";
	try
	{
            conn = fetchConnection(); 
            
            if (conn != null){	
		stmt = conn.createStatement();
                response = stmt.executeUpdate(queryString);
            }
	}
	catch(SQLException e){
            log.debug(e.getMessage());
	}
	finally{
		try{
                    if (stmt != null){
			stmt.close();
                    }
                    if (conn != null) {
			conn.close();
                    }												
                }
		catch (SQLException e){									
                    log.debug(e.getMessage());									
		} 
	}		
        
        if(response != 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean getAllItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean rentItem(String catalogNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} // end class FleetRentalJDBCDaoImpl