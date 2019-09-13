package com.library.model.services.retreivalservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.library.model.domain.AvailableItems;
import com.library.model.services.IService;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;

/**
*
* @author Veeral Patel
*
*This Services will point to the RetreivalServiceImpl to use the methods that are in there. This is just an interface method, no logic is done here
*/

public interface IRetreivalService extends IService{

	
	//This variable is used to get the name of the service, it is referred to in the Service Factory
	public final String NAME = "IRetreivalService";
	
	//This method will return the result of a search with a string attached to it
	public ArrayList<?> returnSearchResult (AvailableItems availableItems, String searchString) throws RetreivalException, FileNotFoundException, IOException, ClassNotFoundException;
	
	
	//This method returns all of the available items that are in the library
	public ArrayList<?> getAllItems (AvailableItems availableItems) throws RetreivalException, FileNotFoundException, IOException, ClassNotFoundException, AvailibilityException;

}
