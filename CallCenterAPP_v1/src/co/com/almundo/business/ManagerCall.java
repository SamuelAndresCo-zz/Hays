/* 
* @(#)ManagerCall.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.business;

import java.util.Optional;

import co.com.almundo.model.Employee;
import co.com.almundo.services.EmployeesService;
import co.com.almundo.services.impl.EmployeesServiceImpl;
import co.com.almundo.util.enums.RoleEnum;
import co.com.almundo.util.exception.EmployeeNotAvaibleException;

/**
 * class ManagerCall
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public class ManagerCall extends Thread implements Comparable<ManagerCall> {

		protected RoleEnum typeEmployee;
		protected String nombre;
		private Call call;
		private EmployeesService employeesService= new EmployeesServiceImpl();
		
		public ManagerCall(String nombre){
			this.nombre = nombre;
			
		}
		
		public int getPrioridad(){
			return this.typeEmployee.getPriority();
		}
	

		public void takeCall(Call call) throws InterruptedException {
			this.call = call;
			this.start();
		}

		public void run() {
			 Employee employee = Optional.ofNullable(employeesService.getAvaibleEmployee()).
		                orElseThrow(() -> new EmployeeNotAvaibleException("No hay empleados disponibles para atender la llamada"));
	        try {
	        this.call.setEmployee(employee);
			Thread.sleep(1000 * call.getCallDuration());
	        System.out.println("Llamada " + call.getDescription() + " finalizada. Duracion :" + call.getCallDuration());
	        this.addEmpleadoDisponible(call);
	        System.out.println("Empleado " + this.getNombre() + " disponible");
			} catch (InterruptedException e) {
				System.out.println("Error atendiendo llamada " + call.getDescription());
				e.printStackTrace();
			} 
		}

		public String getNombre() {
			return nombre;
		}

		public void addEmpleadoDisponible(Call call) {
			 employeesService.addEmployeeToQueue(call.getEmployee());
		}
		
		
		@Override
		public int compareTo(ManagerCall e) {
			if (this.getPrioridad() < e.getPrioridad()){
				return -1;
			}
			if (this.getPrioridad() > e.getPrioridad()){
				return 1;
			}
			return 0;
		}

	
}
