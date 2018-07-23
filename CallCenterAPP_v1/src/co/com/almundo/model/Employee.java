/* 
* @(#)Employee.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.model;

import co.com.almundo.util.enums.RoleEnum;

/**
 * class Employee
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public class Employee {

	private Integer id;
	private String name;
    private RoleEnum role;
    
	/**
	 * @param id
	 * @param name
	 * @param role
	 */
	public Employee(Integer id, String name, RoleEnum role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the role
	 */
	public RoleEnum getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(RoleEnum role) {
		this.role = role;
	}

}
