/* 
* @(#)RoleEnum.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.util.enums;

/** 
 * Enum public
 * 
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public enum RoleEnum {

    OPERATOR(1, "OPERATOR", 3),
	SUPERVISOR(2, "SUPERVISOR", 2),
	DIRECTOR(3, "DIRECTOR", 1);


	private final int code;
	private final String description;
	private int priority;

	private RoleEnum(int code, String description, int priority) {
		this.code = code;
		this.description = description;
		this.priority = priority;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	
	
}
