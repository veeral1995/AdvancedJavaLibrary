package com.library.model.services.exception;

/**
 * @author Veeral Patel
 * 
 * This Exception occurs where there is an error in the retreival process
 */

public class RetreivalException extends Exception{


	private static final long serialVersionUID = 1L;

	public RetreivalException(final String inMessage)
	{
		super(inMessage);
	}
	
	public RetreivalException(final String inMessage, final Throwable inNestedException)
	{
		super(inMessage, inNestedException);
	}
}



