package com.library.view;

import com.library.controller.LibraryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JTextField;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.Movie;
import com.library.view.Utils;
import com.library.view.MainJFrame;

public class RentItemsJFrameController {

	public MainJFrame libraryJFrame;
	public RentItemsJFrame rentalJFrame;
	
    /** Creates a new instance of RentItemsJFrameController */
    public RentItemsJFrameController() {
    }
	

  /*
   * Copy constructor
   */
    
  public RentItemsJFrameController (RentItemsJFrame rentalJFrame, MainJFrame libraryJFrame) 
  {
	  this.rentalJFrame = rentalJFrame;

        //add all the action listeners here
    	libraryJFrame.getButtonRent().addActionListener((ActionListener) this);
    	rentalJFrame.getCatalogNumberText().addActionListener((ActionListener) this); 
    	rentalJFrame.getButtonRentScreen().addActionListener((ActionListener) this);
        Utils.centerWindow(libraryJFrame);
        libraryJFrame.setVisible(true);
      }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, IOException 
  {

	 
    System.out.println ("Inside RentalJFrameController::actionPerformed");
    if (event.getSource().equals(libraryJFrame.getButtonRent()))
    {
    	getRentalStatus_actionPerformed(event, rentalJFrame.getCatalogNumberText().getText(), rentalJFrame.getResultsTextField());
    
    }
    else if (event.getSource().equals(rentalJFrame.getButtonBackToSearch()))
    {
    	getSearchPage_actionPerformed(event);
    }
    else if (event.getSource().equals(rentalJFrame.getButtonRentScreen()))
    {
    	getRentalStatus_actionPerformed(event, rentalJFrame.getCatalogNumberText().getText(), rentalJFrame.getResultsTextField());
    }
  }

  
 public void getRentalStatus_actionPerformed(ActionEvent event, String text, JTextField jResultsTextField) throws FileNotFoundException, ClassNotFoundException, IOException {

	 //jResultsTextField.setText("Clicked Rent");
	 System.out.println("Inside getRentalStatus_actionPerformed");
	 
	 performRentOperation(text, jResultsTextField);
	
}


private void performRentOperation(String text, JTextField jResultsTextField) throws FileNotFoundException, IOException, ClassNotFoundException {
	
	//SearchItemsManager searchItemsManager;
	//RentItemsManager rentItemsManager;
	AvailableItems availableItems = new AvailableItems();
	boolean rentSuccess = false;
	String catNum = text;
	//searchItemsManager = SearchItemsManager.getInstance();
	//rentItemsManager = RentItemsManager.getInstance();
	//LibraryJDBCDaoImpl jdbcDB = new LibraryJDBCDaoImpl();
        //LibraryHibernateDaoImpl dbConnection = new LibraryHibernateDaoImpl();
        LibraryController libController = new LibraryController();
	
	//availableItems = dbConnection.getAvailableItems();
	rentSuccess = libController.performActionRent("Rent", availableItems, catNum);
	
	if (rentSuccess == true) {
		jResultsTextField.setText("Rent Successful, Catalog Number: " + text);
	}
	else {
		jResultsTextField.setText("Rent Unsuccessful, Item may be invalid or not available");
	}
	
}


public void getRentalPage_actionPerformed(ActionEvent actionEvent, String string, JTextField jResultsTextField) throws FileNotFoundException, IOException, ClassNotFoundException 
  {     
	     new RentItemsJFrame().setVisible(true);

  } //end getSearchItems_actionPerformed

 public void getSearchPage_actionPerformed(ActionEvent actionEvent) {
	 
	 	System.out.println("Back to Search Page");
	     new MainJFrame().setVisible(true);
 }
  
}
