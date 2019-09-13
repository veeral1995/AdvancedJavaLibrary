package com.library.model.services.exception;

public class AvailibilityException extends Exception {

	/**
	 * @author Veeral Patel
	 * 
	 * This Exception occurs where there is no items Available
	 */
	private static final long serialVersionUID = 1L;

	public AvailibilityException(final String inMessage)
    {
        super(inMessage);
    }
}