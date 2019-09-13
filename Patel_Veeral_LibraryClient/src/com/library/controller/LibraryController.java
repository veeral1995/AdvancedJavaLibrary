package com.library.controller;

import com.library.model.domain.AvailableItems;
import com.library.model.domain.RentalItem;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import org.apache.log4j.Logger;


/**
 * This class is the Controller in the MVC framework. View classes 
 * call into the Controller and as such have no visibility into the Model.
 * 
 * This controller uses a socket connection to connect to the ServerSocket
 * which happens to be the Model's FleetRentalServerManager. 
 * 
 * @author Mike.Prasad
 *
 */
public  class LibraryController implements IInterceptingController
{
	static Logger log = Logger.getLogger("com.controller.LibraryController");

    public ArrayList<Object> performAction(String commandString, AvailableItems availableItems, String searchString)
        {
            boolean status = false;
            Socket socket = null;
            ObjectOutputStream out = null;
            ObjectInputStream is = null;
            ArrayList<Object> results = null;
    
        try
            {
                System.out.println ("About to make a socket connection to the server");
                // Step 1: Create Socket to make a connection		 
                socket = new Socket(InetAddress.getLocalHost(), 8189);

                // Step 2: Get input and output streams
                out = new ObjectOutputStream(socket.getOutputStream());
                out.flush();
                out.writeObject (commandString);
                out.writeObject (availableItems);
                out.writeObject (searchString);

                // Step 3: Process data sent back from Server
                is = new ObjectInputStream(socket.getInputStream());
                results = (ArrayList<Object>) is.readObject(); // get what server has to say
         
            }	
            catch (Exception e)
		{
                    log.error (e.getClass()+": "+e.getMessage(), e);
		}
            finally
                {
                    // Step 4: Close connection
                    try {
			if (is != null) {
                            is.close();
			}
			if (out != null) {
                            out.close();
			}
			if (socket != null) {
                            socket.close();
			}
			} catch (IOException e) {
                                                    log.error (e.getClass()+": "+ e.getMessage(), e);
						}
			}//end try/catch/finally				
	return results;
  } //end performAction

    public boolean performActionRent(String commandString, AvailableItems availableItems, String catNum)
        {
            boolean status = false;
            Socket socket = null;
            ObjectOutputStream out = null;
            ObjectInputStream is = null;
            
            log.info("Inside LibraryController:performActionRent");
    
        try
            {
                log.info("About to make a socket connection to the server");
                // Step 1: Create Socket to make a connection		 
                socket = new Socket(InetAddress.getLocalHost(), 8189);

                // Step 2: Get input and output streams
                out = new ObjectOutputStream(socket.getOutputStream());
                out.flush();
                out.writeObject (commandString);
                out.writeObject (availableItems);
                out.writeObject (catNum);

                // Step 3: Process data sent back from Server
                is = new ObjectInputStream(socket.getInputStream());
		status = (Boolean)is.readObject();
                //availableItems = (AvailableItems)is.readObject(); // get what server has to say
         
            }	
            catch (Exception e)
		{
                    log.error (e.getClass()+": "+e.getMessage(), e);
		}
            finally
                {
                    // Step 4: Close connection
                    try {
			if (is != null) {
                            is.close();
			}
			if (out != null) {
                            out.close();
			}
			if (socket != null) {
                            socket.close();
			}
			} catch (IOException e) {
                                                    log.error (e.getClass()+": "+ e.getMessage(), e);
						}
			}//end try/catch/finally				
	return status;
  } //end performAction
    @Override
    public boolean performAction(String commandString, AvailableItems availableItems) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} // end class LibraryController