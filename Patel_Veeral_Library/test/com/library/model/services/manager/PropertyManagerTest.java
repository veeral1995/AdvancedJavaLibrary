package com.library.model.services.manager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import junit.framework.TestCase;
import com.library.model.services.exception.RetreivalException;

public class PropertyManagerTest extends TestCase{


	private static Properties properties;
	/**
	 * Test performAction method for RegisterCustomer
	 * @throws RetreivalException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public final void testPropertyLocation() throws ClassNotFoundException, IOException, RetreivalException
	{
		String propertyFileLocation = "C:\\Users\\vpatel48\\Downloads\\Patel_Veeral_Library\\test\\application.properties";
		
		properties = new Properties();
                FileInputStream sf = null;
	    
                sf = new FileInputStream(propertyFileLocation);
                properties.load(sf);
		
                assertTrue(sf != null);
	
	}
}