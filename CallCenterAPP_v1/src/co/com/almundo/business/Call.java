/* 
* @(#)Call.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.business;

import co.com.almundo.model.Employee;
import co.com.almundo.util.enums.Constans;
/**
 * class Call
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public class Call {
	
	private Employee employee;
	private long callDuration;
	private String description;
	

    public Call(Employee employee, String description){
       this.employee = employee;
       this.callDuration = (long) (Math.random() * ((Constans.MAX_TIME - Constans.MIN_TIME) + 1)) + Constans.MIN_TIME;
       this.description = description;
     }

    
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	/**
	 * @return the callDuration
	 */
	public long getCallDuration() {
		return callDuration;
	}

	/**
	 * @param callDuration the callDuration to set
	 */
	public void setCallDuration(long callDuration) {
		this.callDuration = callDuration;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
