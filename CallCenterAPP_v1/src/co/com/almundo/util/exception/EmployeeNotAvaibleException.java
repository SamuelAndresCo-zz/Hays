/* 
* @(#)EmployeeNotAvaibleException.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.util.exception;

/**
 * class EmployeeNotAvaibleException
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public class EmployeeNotAvaibleException extends RuntimeException {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotAvaibleException(String message) {
	        super(message);
	    }

	    public EmployeeNotAvaibleException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
