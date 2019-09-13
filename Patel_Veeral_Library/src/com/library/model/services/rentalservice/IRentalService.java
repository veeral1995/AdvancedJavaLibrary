package com.library.model.services.rentalservice;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.library.model.domain.AvailableItems;
import com.library.model.services.IService;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;
import java.sql.SQLException;

/**
*
* @author Veeral Patel
*
*This Services will point to the RetreivalServiceImpl to use the methods that are in there. This is just an interface method, no logic is done here
*/

public interface IRentalService extends IService{

	
	//This variable is used to get the name of the service, it is referred to in the Service Factory
	public final String NAME = "IRentalService";
	
	//This method will return the result of a search with a string attached to it
	public boolean rentItem (AvailableItems availableItems, String catalogNumber) throws SQLException, RetreivalException, FileNotFoundException, IOException, ClassNotFoundException, AvailibilityException;
	


}
