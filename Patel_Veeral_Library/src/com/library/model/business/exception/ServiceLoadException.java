package com.library.model.business.exception;

/**
*
* @author Veeral Patel
*
*This Exception is used if services are not loading
*/

@SuppressWarnings("serial")
public class ServiceLoadException extends Exception
{
	//This exception will be thrown if any of the services that we have do not load.
    public ServiceLoadException(final String inMessage, final Throwable inNestedException)
    {
        super(inMessage, inNestedException);
    }
	
}