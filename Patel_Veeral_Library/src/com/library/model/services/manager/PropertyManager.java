package com.library.model.services.manager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.library.model.business.exception.PropertyFileNotFoundException;

/**
 * The property manager is in change of finding and opening up the application.preropties file. This property manager is called up within the ManagerSuperType class
 *   
 * @author Veeral Patel
 *
 */

public class PropertyManager
{
	//here we are using a Java object of Properties to declare our file
	private static Properties properties;
 
	//This method is in charge of loading the property and throws errors if it is not found
	public static void loadProperties(String propertyFileLocation) throws PropertyFileNotFoundException
	{
	    properties = new Properties();
	    FileInputStream sf = null;
	    try
	    {
	      sf = new FileInputStream(propertyFileLocation);
	      properties.load(sf);
     
	      System.out.println("Property file successfully loaded from location: " + propertyFileLocation);
	      System.out.println("Property Contents: " + properties.toString());

	    }
	    catch (FileNotFoundException fnfe) 
		 {
	    	System.out.println("Property file not found.");
	    	throw new PropertyFileNotFoundException ("Property File cannot be found.", fnfe);
		 }
	    catch (IOException ioe) 
	    {
	    	System.out.println("IOException while loading Properties file.");
	    	throw new PropertyFileNotFoundException ("IOException while loading Properties file.", ioe);	    	
	    }
	    catch (Exception excp) 
	    {
	    	System.out.println("Exception while loading Properties file.");
	    	throw new PropertyFileNotFoundException ("Exception while loading Properties file.", excp);	    	
	    }
		finally
		{
			if (sf != null)
			{	
			   try {
 			    sf.close();
			   } catch (IOException e) {
				e.printStackTrace();
			   }
		    }	
		}	    
	} 

	//Here we are getting the property from the file while passing it a string key
    static public String getPropertyValue (String key)
    {
    	return properties.getProperty(key);
    }
} 