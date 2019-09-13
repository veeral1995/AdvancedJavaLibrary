package com.library.server;


import com.library.model.business.manager.*;
import com.library.model.domain.AvailableItems;
import com.library.model.domain.RentalItem;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import org.apache.log4j.Logger;

/**
 * Class that connects FleetRentalServer to the FleetRentalManager  
	* 
	* Note that this class is a single threaded version!
	* 
	* @author Mike.Prasad
 *
 */

public class LibraryServerHandler 
{

    private Socket incomingSocket; 			
    private final int threadNumber; 
    static Logger log = Logger.getLogger("com.library.server.LibraryServerHandler");
		 
    public LibraryServerHandler(Socket _incomingSocket, int _threadNumber) 
	{
		incomingSocket = _incomingSocket;
		threadNumber = _threadNumber;
	}

    public void run ()
    {  
	ObjectInputStream in   = null;
	ObjectOutputStream out = null;

	try
	{
		in   = new ObjectInputStream(incomingSocket.getInputStream());
		out = new ObjectOutputStream(incomingSocket.getOutputStream());
                
                // Now as in the past, call the manager to perform action.
 		SearchItemsManager searchItemsManager = SearchItemsManager.getInstance();
                RentItemsManager rentItemsManager = RentItemsManager.getInstance();              

		// retrieve the commandString
		String commandString = (String)in.readObject();
		log.info("LibraryServerHandler::run:Received command to execute service: " + commandString);
                
                if ( commandString.equals("Rent")){
                    log.info("CommandString = Rent, therefore rent process occuring!");
                    AvailableItems availableItems = (AvailableItems)in.readObject();
                    String catalogNumber = (String)in.readObject();
                    boolean result = rentItemsManager.rentItem(commandString, availableItems, catalogNumber);
                    out.writeObject(result);
                    out.flush();
                }
                else {
                    log.info("CommandString != Rent, therefore search process occuring!");
                    AvailableItems availableItems = (AvailableItems)in.readObject();
                    ArrayList<?> status = searchItemsManager.performAction(commandString, availableItems);
                    out.writeObject(status);
                    out.writeObject(availableItems);
                    out.flush();
                }

		

	}
	catch (Exception e)
	{  
		log.error ("Error processing request from client", e);
	}
	finally
	{
		try {
			if (in != null) {
				in.close();
 			}
			if (out != null) {
				out.close();
	 		}
                        if (incomingSocket != null) {
				incomingSocket.close();
		 	}
		} catch (IOException e) {
			log.error (e.getClass()+": "+ e.getMessage(), e);
		}
                log.info (threadNumber + " exiting");
	}//end try/catch/finally
    }//end run    
} // end class FleetRentalServerHandler