/* 
* @(#)Dispatcher.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.dispatcher;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import co.com.almundo.business.Call;
import co.com.almundo.business.ManagerCall;

/**
 * class Dispatcher
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public class Dispatcher extends Thread{

	private static Logger LOGGER = LogManager.getLogger(Dispatcher.class);

	BlockingQueue<ManagerCall> empleadosDisponibles;
	BlockingQueue<Call> calls; 
	


	public Dispatcher(){
		empleadosDisponibles = new PriorityBlockingQueue<ManagerCall>();
		calls = new LinkedBlockingQueue<Call>();
	}

	public void dispatchCall(Call call) throws InterruptedException{
		System.out.println("Entrando llamada " + call.getDescription());
		this.calls.put(call);
	}

	public void run() {
		Call call;
		try {
			while(true){
				call = calls.take();
				ManagerCall managerCall = new ManagerCall(call.getDescription());
				LOGGER.info("Esperando a tomar la llamada " + call.getDescription());
				//managerCall = empleadosDisponibles.take();
				LOGGER.info("Empleado " + managerCall.getNombre() + " va a tomar la llamada " + call.getDescription());
				managerCall.takeCall(call);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void addEmpleadoDisponible(ManagerCall managerCall){
		this.empleadosDisponibles.add(managerCall);
	}
	
	public Queue<Call> getCalls(){
		return calls;
	}
	
	public Queue<ManagerCall> getEmpleadosDisponibles(){
		return empleadosDisponibles;
	}

}
