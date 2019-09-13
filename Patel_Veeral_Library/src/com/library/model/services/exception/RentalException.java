package com.library.model.services.exception;

/**
 * @author Veeral Patel
 * 
 * This Exception occurs where there is an error in the retreival process
 */

public class RentalException extends Exception{


	private static final long serialVersionUID = 1L;

	public RentalException(final String inMessage)
	{
		super(inMessage);
	}
	
	public RentalException(final String inMessage, final Throwable inNestedException)
	{
		super(inMessage, inNestedException);
	}
}



