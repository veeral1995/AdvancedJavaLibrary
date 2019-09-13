package com.library.view;

import com.library.controller.LibraryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.Book;
import com.library.model.domain.CD;
import com.library.model.domain.Movie;
import com.library.view.Utils;
import javax.swing.JFrame;
import org.apache.log4j.Logger;


/**
 * availableitemsJFrameController.java
 *
 * Listens and handles actions generated from availableitemsJFrame.java
 * 
 * @author Veeral Patel
 */

public class MainJFrameController extends JFrame implements ActionListener 
{
	
        static Logger log = Logger.getLogger("com.library.view.mainjframe.mainJFrameController");
	public MainJFrame libraryJFrame;
	
    /** Creates a new instance of ItineraryJFrameController */
    public MainJFrameController() {
    }
	

  /*
   * Copy constructor
   */
    
  public MainJFrameController (MainJFrame libraryJFrame) 
  {
	  this.libraryJFrame = libraryJFrame;

        //add all the action listeners here
    	libraryJFrame.getSearchStringButton().addActionListener(this);
    	libraryJFrame.getSearchAllButton().addActionListener(this);
    	libraryJFrame.getSearchText().addActionListener(this);   
        // center the frame
        Utils.centerWindow(libraryJFrame);
        libraryJFrame.setVisible(true);
      }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) 
  {

	 
    System.out.println("Inside availableitemsJFrameController::actionPerformed");
    if (event.getSource().equals(libraryJFrame.getSearchStringButton()))
		try {
			getSearchItems_actionPerformed(event, libraryJFrame.getSearchText().getText(), libraryJFrame.jResultsTextField);
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	else if (event.getSource().equals(libraryJFrame.getSearchAllButton()))
		try {
			getAllItems_actionPerformed(event, libraryJFrame.jResultsTextField);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

  
  @SuppressWarnings("deprecation")
void getSearchItems_actionPerformed(ActionEvent actionEvent, String searchString, javax.swing.JTextField jResultsTextField) throws FileNotFoundException, IOException, ClassNotFoundException
  {
                 System.out.println("Inside availableitemsJFrameController; All Items was Clicked");
                 System.out.println("Search String Is: " + searchString);
	 	 //SearchItemsManager searchItemsManager;
	 	 AvailableItems dbItems = new AvailableItems();	
                 LibraryController libController = new LibraryController();
	 	 //searchItemsManager = SearchItemsManager.getInstance();	
                 
		ArrayList<Object> results = (ArrayList<Object>) libController.performAction("SearchItems", dbItems, searchString);	

	 	System.out.println("Here are the results: " + results.toString());
	 	jResultsTextField.setText(results.toString());    
  } //end getSearchItems_actionPerformed

  
/**
   * Processes Get Available Library Items action
   *
   * @param actionEvent ActionEvent
 * @throws RetreivalException 
 * @throws IOException 
 * @throws ClassNotFoundException 
 * @throws AvailibilityException 
   */
  
  @SuppressWarnings("deprecation")
void getAllItems_actionPerformed(ActionEvent actionEvent, javax.swing.JTextField jResultsTextField) throws ClassNotFoundException, IOException
  {
         System.out.println("Inside availableitemsJFrameController; All Items was Clicked");
 	 //SearchItemsManager searchItemsManager = SearchItemsManager.getInstance();
         LibraryController libController = new LibraryController();
         AvailableItems dbItems = new AvailableItems();
         
         log.info("In MainJFrameController, dbItems: " + dbItems.toString() );
	 ArrayList<Object> results = (ArrayList<Object>) libController.performAction("SearchAllItems", dbItems, "");	

 	 log.info("DataBase: " + results.toString());
 	 jResultsTextField.setText(results.toString());       
  }


  
} //end class   