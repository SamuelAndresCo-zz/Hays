/* 
* @(#)DispatcherTest.java 1.0 23/07/2018 
* Copyright (c) 2018 ALMundo.
* Bogota, Colombia
* All rights reserved.
*/
package co.com.almundo.test;

import co.com.almundo.business.Call;
import co.com.almundo.dispatcher.Dispatcher;
import co.com.almundo.model.Employee;
import co.com.almundo.util.enums.Constans;
import co.com.almundo.util.enums.RoleEnum;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * class DispatcherTest
 * @author Samuel Andres Zabala
 * @version 1.0, 23/07/2018
 * @since 1.0
 */
public class DispatcherTest extends TestCase{

	 public static TestSuite suite(){
	        return new TestSuite(DispatcherTest.class);
	 }
	 
	 public void testDiezCalls(){
	    	try {
		    	Dispatcher dispatcher = new Dispatcher();
		    	dispatcher.start();

		    	dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.OPERATOR), " 1 "));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.SUPERVISOR), " 2 "));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.SUPERVISOR), "3"));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.DIRECTOR), "4"));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.SUPERVISOR), "5"));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.SUPERVISOR), "6"));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.OPERATOR), "7"));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.SUPERVISOR), "8"));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.SUPERVISOR), "9"));
				dispatcher.dispatchCall(new Call(new Employee(1, "Sam", RoleEnum.DIRECTOR), "10"));


				Thread.sleep((Constans.MAX_CALL_WAIT_TIME * 10)/3);
				
				assertTrue(dispatcher.getCalls().isEmpty());
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				fail();
			}
	    	
	    }
}
