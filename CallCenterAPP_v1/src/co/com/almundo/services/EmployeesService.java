/* 
* @(#)EmployeesService.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.services;

import co.com.almundo.model.Employee;

/**
 * interface EmployeesService
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public interface EmployeesService {

	/**
     * Retorna un empleado disponible ordenado segun su cargo en caso de no existir retorna null.
     * @return Employee
     */
    Employee getAvaibleEmployee();

    /**
     * Disponibiliza a un empleado para atender llamadas.
     * @param employee
     */
    void addEmployeeToQueue(Employee employee);

}
