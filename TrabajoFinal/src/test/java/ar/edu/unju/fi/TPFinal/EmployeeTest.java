package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.model.Office;
import ar.edu.unju.fi.TPFinal.service.IEmployeeService;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

@SpringBootTest
class EmployeeTest {

	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IOfficeService officeService;
	
	//@Test
	void testListaEmployees() {
		
		Office office = officeService.buscarOfficePorId("STM");
		
		List<Employee> lista = employeeService.listaEmployeesPorOffice(office);
		assertEquals(lista.size(), 3);
		
	}

	//@Test
	void testCargarEmployee() {
		
		Office office = officeService.buscarOfficePorId("STM");
		Employee encontrado = employeeService.buscarEmployeePorId(2);
		Employee employee = new Employee();
		employee.setEmail("ejemplo@gmail.com");
		employee.setExtension("x900");
		employee.setFirstName("ejemplo1");
		employee.setJobTitle("contador");
		employee.setLastName("ejemplo1");
		employee.setOfficeCode(office);
		employee.setReportsTo(encontrado);
		employee.setEmployeeNumber(4);
		employeeService.guardarEmployee(employee);
		Employee emp = employeeService.buscarEmployeePorId(4);
		assertEquals(employee.getFirstName(),emp.getFirstName());
	}
	@Test
	void testCustomers() {
		
		Employee encontrado = employeeService.buscarEmployeePorId(1);
		List<Customer> customers = encontrado.getCustomers();
		assertTrue(customers.size()==1);
	}
}
