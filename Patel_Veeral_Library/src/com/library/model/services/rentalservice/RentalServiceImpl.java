package com.library.model.services.rentalservice;

import com.library.model.doa.jdbc.LibraryJDBCDaoImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.RentalItem;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import java.sql.SQLException;

/**
*
* @author Veeral Patel
*
*/

public class RentalServiceImpl implements IRentalService {

	
	
        @Override
	public boolean rentItem(AvailableItems availableItems, String catalogNumber) throws FileNotFoundException, IOException, AvailibilityException, ClassNotFoundException, SQLException  {
		
                boolean dbRentSuccess = false;
		ArrayList<Object> allItems = new ArrayList<>();			
		allItems = availableItems.returnAllAvailibleItems();
                //LibraryJDBCDaoImpl jdbcConnector = new LibraryJDBCDaoImpl();
		boolean rentSuccess;
		rentSuccess = RentalItem.rentItem(allItems, catalogNumber);
                //dbRentSuccess = jdbcConnector.rentItem(catalogNumber);
		
		return rentSuccess;
	}	


}
