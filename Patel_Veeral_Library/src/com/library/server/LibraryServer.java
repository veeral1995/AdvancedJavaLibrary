package com.library.server;


import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LibraryServer 
{

	
	static Logger log = Logger.getLogger("com.library.server.LibraryServer");
        private static int threadsCreated=1;

	 private LibraryServer() {
            }

    
    /**
     *
     * Fires up the server
     */
    public static void startServer()
    {
     try
     {
        log.info("Library Server Started");
        ServerSocket s = new ServerSocket(8189); // port should come from a properties file
        for (;;)
            
        {  Socket socket = s.accept( );

	   LibraryServerHandler libraryServerHandler = new LibraryServerHandler(socket, threadsCreated);
           libraryServerHandler.run();   
           log.info("Threads created: " + threadsCreated);
           threadsCreated++;											
        }
     }
     catch (Exception e)
     {  
         log.error("Issue starting Library Server ", e);
     }    	  	
    }

    public static void main(String[] args)
    {
        BasicConfigurator.configure();
	LibraryServer.startServer();						
    }//end main
}
