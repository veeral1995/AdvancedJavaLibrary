/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.model.services.exception;

/**
 *
 * @author vpatel48
 */

public class DaoLoadException extends Exception {
	
		public DaoLoadException(final String inMessage, final Throwable inNestedException)
		{
							super(inMessage, inNestedException);
		}
}
