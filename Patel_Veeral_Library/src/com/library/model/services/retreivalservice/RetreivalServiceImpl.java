package com.library.model.services.retreivalservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.library.model.domain.AvailableItems;
import com.library.model.services.exception.AvailibilityException;
import com.library.model.services.exception.RetreivalException;

/**
*
* @author Veeral Patel
*
*This Implementation of the IRetreivalService is used to get data from searches. The user can search for all of the available items, or enter a string to search for a specific item
*/

public class RetreivalServiceImpl implements IRetreivalService {

	//This method will return a list of available items in the library that match the search entered by the user
	public ArrayList<?> returnSearchResult(AvailableItems availableItems, String searchString) throws RetreivalException, FileNotFoundException, IOException, ClassNotFoundException {
		
		ArrayList<Object> resultArray = new ArrayList<>();
		resultArray = availableItems.returnSearchResult(searchString);		
		return resultArray;
		
	}	

	//This method will return all of the available items that are in the libary for rental purposes
	public ArrayList<?> getAllItems (AvailableItems availableItems) throws RetreivalException, FileNotFoundException, IOException, ClassNotFoundException, AvailibilityException {
	
		ArrayList<Object> allItems = new ArrayList<>();
		
		allItems = availableItems.returnAllAvailibleItems();
		return allItems;
		
	}


}
