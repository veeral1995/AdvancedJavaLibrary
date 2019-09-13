package com.library.model.business.manager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.library.model.business.exception.ServiceLoadException;
import com.library.model.doa.hibernate.LibraryHibernateDaoImpl;
import com.library.model.domain.AvailableItems;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import com.library.model.services.factory.ServiceFactory;
import com.library.model.services.rentalservice.IRentalService;
import java.sql.SQLException;
import org.apache.log4j.*;

/**
 *
 * @author Veeral Patel
 *
 */

public class RentItemsManager extends ManagerSuperType {

	private static RentItemsManager _instance;
        static Logger log = Logger.getLogger("com.libraryapplication");
	private RentItemsManager() {}


	public static synchronized RentItemsManager getInstance() {
		if (_instance == null) {
			_instance = new RentItemsManager();
		}
		return _instance;
	}

	/**
	 * @throws IOException 
	 * @throws RetreivalException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 * This performAction is being referred to from the ManagerSuperType abstract class. 
	 * @throws AvailibilityException 
	 */
	public boolean performActionRent (AvailableItems availableItems, String catalogNumber) throws FileNotFoundException, ClassNotFoundException, RetreivalException, IOException, AvailibilityException {

                log.trace("Inside Original performActionRent Method");
		boolean rentStatus = false;
            try {
                rentStatus = rentItem(IRentalService.NAME, availableItems, catalogNumber);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(RentItemsManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
		
		return rentStatus;
	}
	

	/**
	 * @throws IOException 
	 * @throws RetreivalException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 * 
	 * This method, returnAllAvailableItems, returns all the items in the library that are available for rental
	 * @throws AvailibilityException 
	 */
		
	public boolean rentItem (String commandString, AvailableItems availableItems, String catalogNumber) throws FileNotFoundException, ClassNotFoundException, RetreivalException, IOException, AvailibilityException, SQLException {

		boolean rentSuccess = false;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		IRentalService iRentalService;
                
                LibraryHibernateDaoImpl hib = new LibraryHibernateDaoImpl();     
                availableItems = hib.getAvailableItems();


		try {
			iRentalService = (IRentalService) serviceFactory
					.getService("IRentalService");
			rentSuccess = iRentalService.rentItem(availableItems, catalogNumber);
                        log.trace("Successfully Rented Item");
		} 
		//This exception occurs when the service factory did not load correctly.
		catch (ServiceLoadException el) {
                        log.error(el);
		}

		return rentSuccess;

	}


	@Override
	public ArrayList performAction(String commandString, AvailableItems availableItems, String searchString)
			throws IOException, RetreivalException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}