package jaxb;

import javax.xml.bind.*;
import javax.xml.transform.Result;

import java.io.*;

public class EmployeeJAXB {
	public void marshall() {
		try {
			
			Employee emp = new Employee("A001", "Manoj", "Nashik", 50000);
			JAXBContext jc = JAXBContext.newInstance(Employee.class);
			
			Marshaller ms = jc.createMarshaller();
			
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(emp, System.out);
			ms.marshal(emp, new File("src\\data\\Employee.xml"));
			
			
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
	}
	
	public void unmarshall() {
		
		try {
			JAXBContext jc = JAXBContext.newInstance(Employee.class);
			Unmarshaller ums = jc.createUnmarshaller();
			
			Employee emp = (Employee) ums.unmarshal(new File("src\\\\data\\\\Employee.xml"));
			
			System.out.println("Employee information");
			System.out.println("id: " + emp.getId());
			System.out.println("name: " + emp.getName());
			System.out.println("address: " + emp.getAddress());
			System.out.println("salary: " + emp.getSalary());
			
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
	}
}
