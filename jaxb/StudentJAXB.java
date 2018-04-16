package jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class StudentJAXB {
	public void marshall() {
		try {
			Student student = new Student(1, "Mateusz", "Milak", 201542);
			JAXBContext jb = JAXBContext.newInstance(Student.class);
			Marshaller ms = jb.createMarshaller();
			
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(student, System.out);
			ms.marshal(student, new File("src\\data\\Student.xml"));
			
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
	}
	
	public void unmarshall() {
		
		try {
			JAXBContext jb = JAXBContext.newInstance(Student.class);
			Unmarshaller ums = jb.createUnmarshaller();
			
			Student student = (Student)ums.unmarshal(new File("src\\data\\Student.xml"));
			
			System.out.println("id studenta: " + student.getId());
			System.out.println("Imie studenta: " + student.getName());
			System.out.println("Nazwisko studenta: " + student.getSurname());
			System.out.println("Indeks studenta: " + student.getIndex());
			
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
		}
		
	}
}
