package demo;

import jaxb.*;

public class Main {
	
	public static void main(String args[]) {
		EmployeeJAXB obj = new EmployeeJAXB();
		obj.marshall();
		
		obj.unmarshall();
		
		StudentJAXB studentObj = new StudentJAXB();
		studentObj.marshall();
		studentObj.unmarshall();
	}

}
