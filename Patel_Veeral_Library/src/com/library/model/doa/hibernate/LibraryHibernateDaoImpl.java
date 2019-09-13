/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.model.doa.hibernate;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.Movie;
import com.library.model.services.exception.AvailibilityException;
import java.io.IOException;
import java.sql.*;
import javax.persistence.*;
import com.library.model.services.factory.HibernateSessionFactory;
import com.library.model.doa.ILibraryDao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vpatel48
 */
public class LibraryHibernateDaoImpl implements ILibraryDao{

    static Logger log = Logger.getLogger("com.LibraryHibernateDaoImpl");
    
    
    private Session fetchSession() throws HibernateException {
        log.info("******Fetching Hibernate Session");

        Session session = HibernateSessionFactory.currentSession();

        return session;

    } //end fetchConnection

    /**
     * Fetches all available cars for rental
     *
     * @return List containing all available rental cars
     */
public AvailableItems getAvailableItems() throws AvailibilityException, IOException, ClassNotFoundException{
        boolean status = false;
							
	log.info("Using Hibernate");
        log.info("Inside Get Available Items");

	AvailableItems availableItems = returnAllAvailableItems();

	if (availableItems != null){
            status = true;
	}
	return availableItems;
} //end getAvailableRentals

private AvailableItems returnAllAvailableItems() throws AvailibilityException, IOException, ClassNotFoundException{
	AvailableItems availableItems = null;
        List<Book> bkList = null;
        List<CD> cdList = null;
        List<Movie> mvList = null;
	Transaction tx = null;
	
      try {
        Session session = fetchSession();
        tx = session.beginTransaction();
        
        Query qBook = session.createQuery("from Book");
        Query qCD = session.createQuery("from CD");
        Query qMovie = session.createQuery("from Movie");
        
        bkList = qBook.getResultList();
        cdList = qCD.getResultList();
        mvList = qMovie.getResultList();
        
        availableItems = buildAvailableItems(bkList, cdList, mvList);
        
      } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error(e.getClass() + ": " + e.getMessage(), e);
        } finally {
            HibernateSessionFactory.closeSessionAndFactory();
        }
      
     
    return availableItems;
} 


private AvailableItems buildAvailableItems (List<Book> bookSet, List<CD> cdSet, List<Movie> movieSet) throws AvailibilityException, IOException, SQLException{
	log.info("Inside buildAvailableItems");
        
	AvailableItems availableItems = new AvailableItems();
        
            for (Book book : bookSet) {             
                availableItems.addBook(book);
            }
            
            for (CD cd : cdSet) {             
                availableItems.addCD(cd);
            }
            
            for (Movie movie : movieSet) {             
                availableItems.addMovie(movie);
            }
        
       return availableItems;
}

  public boolean rentItem(String catalogNumber, String type) throws ClassNotFoundException, SQLException {
        Transaction tx = null;
        int response = 0;
	
      try {
        Session session = fetchSession();        
        tx = session.beginTransaction();
	log.info("Inside rentItem in Hibernate, type: " + type);
        
        Query queryString = session.createQuery("UPDATE " +type+ " SET availibility = 1, returnDate = adddate(current_date , 21) WHERE catalogNumber = "+catalogNumber);
        //queryString.setParameter("Type", "sys."+type);
        //queryString.setParameter("from", today);
        //.setParameter("catalogNumber", catalogNumber);
		
        response = queryString.executeUpdate();
        
        tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error(e.getClass() + ": " + e.getMessage(), e);
        } finally {
            HibernateSessionFactory.closeSessionAndFactory();
        }
      
        if(response != 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean rentItem(String catalogNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getAllItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

