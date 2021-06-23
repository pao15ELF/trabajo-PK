package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Office;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

@SpringBootTest
class OfficeTest {

	@Autowired
	private IOfficeService officeService;
	
	@Test
	void cargarOfficeTest() {
		
		Office office = new Office();
		
		office.setAddressLine1("belgrano 766");
		office.setAddressLine2("salta 452");
		office.setCity("Jujuy");
		office.setCountry("Argentina");
		office.setOfficeCode("CTR"); //id ingresado manualmente
		office.setPhone("155197089");
		office.setPostalCode("4600");
		office.setState("---");
		office.setTerritory("ARG");
		
		officeService.guardarOffice(office);
		
		Office office2 = new Office();
		
		office2.setAddressLine1("Los Perales 123");
		office2.setAddressLine2("Calle falsa 123");
		office2.setCity("Jujuy");
		office2.setCountry("Argentina");
		office2.setOfficeCode("ADM"); //id ingresado manualmente
		office2.setPhone("155122876");
		office2.setPostalCode("4600");
		office2.setState("---");
		office2.setTerritory("ARG");
		
		officeService.guardarOffice(office2);
		
		Office officeEnc = officeService.buscarOfficePorId("CTR");
		
		assertNotNull(officeEnc);
	}
}
