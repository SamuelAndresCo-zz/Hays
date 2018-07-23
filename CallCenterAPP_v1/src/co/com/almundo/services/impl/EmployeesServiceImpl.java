/* 
* @(#)EmployeesServiceImpl.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.services.impl;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.almundo.model.Employee;
import co.com.almundo.services.EmployeesService;
import co.com.almundo.util.enums.Constans;

/**
 * class EmployeesServiceImpl
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public class EmployeesServiceImpl implements EmployeesService {

   
	private static Logger LOGGER = LogManager.getLogger(EmployeesServiceImpl.class);

    private PriorityBlockingQueue<Employee> employeesPriorityQueue;


    public EmployeesServiceImpl() {
        employeesPriorityQueue = new PriorityBlockingQueue<>();

    }

    @Override
    public Employee getAvaibleEmployee() {
        try {
            return employeesPriorityQueue.poll(Constans.MAX_CALL_WAIT_TIME, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            LOGGER.error("Error inesperado al asignar llamadas.", e);
            return null;
        }
    }
    
    @Override
    public void addEmployeeToQueue(Employee employee) {
        employeesPriorityQueue.add(employee);
    }
}
