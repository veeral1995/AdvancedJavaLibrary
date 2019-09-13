package com.library.model.domain;

import com.library.controller.LibraryController;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalItem implements Serializable{

	/**
	 * @author Veeral Patel
	 */
	
	//Here we need Serializable to be able to write to the output files
	private static final long serialVersionUID = 1L;
	
	//the allAvailableItems is used to add every object in the library that is available
		ArrayList<Object> allAvailableItems = new ArrayList<Object>();
		
	
	public static boolean rentItem(ArrayList<Object> allAvailableItems, String rentCatalogNum) throws ClassNotFoundException, SQLException{
		
            
                //LibraryJDBCDaoImpl jdbc = new LibraryJDBCDaoImpl();
                //LibraryHibernateDaoImpl hib = new LibraryHibernateDaoImpl();
                LibraryController libController = new LibraryController();
		
		for(int i = 0; i< allAvailableItems.size(); i++) {
			
			if(allAvailableItems.get(i) instanceof Book)
				{
				if(((Book) allAvailableItems.get(i)).getCatalogNumber().equals(rentCatalogNum)) {
					
					if(((Book) allAvailableItems.get(i)).getAvailibility() == 1) {
						System.out.println("Book Is Not Available");
						return false;
					}
					else {
						((Book) allAvailableItems.get(i)).setAvailibility(1);
                                                //hib.rentItem(rentCatalogNum, "Book");
						return true;
						}				
					}
				}
			else if(allAvailableItems.get(i) instanceof Movie)
			{
				if(((Movie) allAvailableItems.get(i)).getCatalogNumber().equals(rentCatalogNum)) {
					
					if(((Movie) allAvailableItems.get(i)).getAvailibility() == 1) {
						System.out.println("Movie Is Not Available");
						return false;
					}
					else {
						((Movie) allAvailableItems.get(i)).setAvailibility(1);	
                                                //hib.rentItem(rentCatalogNum, "Movie");
						return true;
					}	
				}				
			}
			else if(allAvailableItems.get(i) instanceof CD)
			{
				if(((CD) allAvailableItems.get(i)).getCatalogNumber().equals(rentCatalogNum)) {
					if(((CD) allAvailableItems.get(i)).getAvailibility() == 1) {
						System.out.println("CD Is Not Available");
						return false;
					}
					else {
						((CD) allAvailableItems.get(i)).setAvailibility(1);	
                                                //hib.rentItem(rentCatalogNum, "CD");
						return true;
					}					
				}
			}
			else {
				System.out.println("Invalid Catalog Number, There Are No Matches");
				return false;
			}
			
			}
		
		return false;
		
	
	}
	
}
