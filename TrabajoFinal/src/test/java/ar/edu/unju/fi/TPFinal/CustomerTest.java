package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.service.ICustomerService;
import ar.edu.unju.fi.TPFinal.service.IEmployeeService;
@SpringBootTest
class CustomerTest {

	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IEmployeeService employeeService;
	
	@Test
	void testCrearCustomer() {
		
		Employee emp = employeeService.buscarEmployeePorId(3);
		
		Customer customer = new Customer();
		customer.setAddressLine1("mza14 l8");
		customer.setAddressLine2("---");
		customer.setCity("BS AS");
		customer.setContactFirstName("Cliente1");
		customer.setContactLastName("apellidocliente");
		customer.setCountry("Argetina");
		customer.setCreditLimit(3000d);
		customer.setCustomerName("Cliente--");
		customer.setCustomerNumber(1);
		customer.setPhone("7896543");
		customer.setPostalCode("2345");
		customer.setSalesRepEmployeeNumber(emp);
		customer.setState("active");
		customerService.guardarCustomer(customer);
		
		Customer encontrado = customerService.buscarCustomerPorId(1);
		assertNotNull(encontrado);
		
	}

}
