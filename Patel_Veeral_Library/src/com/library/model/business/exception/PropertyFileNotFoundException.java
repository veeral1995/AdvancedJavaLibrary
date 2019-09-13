package com.library.model.business.exception;

//This exception is used with the application.properties file is not set correctly via path. 
public class PropertyFileNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	//This function will throw an error if the applicaiton.properties file is not found. We can pass in the message that is going to be shown.
	public PropertyFileNotFoundException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
	
} 