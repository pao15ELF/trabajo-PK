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
		
		office.setAddressLine1("Belgrano 766");
		office.setAddressLine2("Salta 452");
		office.setCity("San Salvador de Jujuy");
		office.setCountry("Argentina");
		office.setOfficeCode("Contaduria"); //id ingresado manualmente
		office.setPhone("155197089");
		office.setPostalCode("4600");
		office.setState("Jujuy");
		office.setTerritory("---");
		
		officeService.guardarOffice(office);
		
		
		Office office1 = new Office();
		
		office1.setAddressLine1("La Madrid 256");
		office1.setAddressLine2("Guemes 198 - Piso 6");
		office1.setCity("San Salvador de Jujuy");
		office1.setCountry("Argentina");
		office1.setOfficeCode("Administracion"); //id ingresado manualmente
		office1.setPhone("156856900");
		office1.setPostalCode("4600");
		office1.setState("Jujuy");
		office1.setTerritory("---");
		
		officeService.guardarOffice(office1);
		
		
		Office office2 = new Office();
		
		office2.setAddressLine1("Lavalle 800");
		office2.setAddressLine2("----");
		office2.setCity("San Salvador de Jujuy");
		office2.setCountry("Argentina");
		office2.setOfficeCode("Sucursal 01"); //id ingresado manualmente
		office2.setPhone("155802020");
		office2.setPostalCode("4600");
		office2.setState("Jujuy");
		office2.setTerritory("----");
		
		officeService.guardarOffice(office2);
		
		Office office3 = new Office();
		
		office3.setAddressLine1("Alvear 345");
		office3.setAddressLine2("----");
		office3.setCity("San Salvador de Jujuy");
		office3.setCountry("Argentina");
		office3.setOfficeCode("Sucursal 02"); //id ingresado manualmente
		office3.setPhone("4232327");
		office3.setPostalCode("4600");
		office3.setState("Jujuy");
		office3.setTerritory("----");
		
		officeService.guardarOffice(office3);
		
		Office office4 = new Office();
		
		office4.setAddressLine1("Av 19 de Abril 444");
		office4.setAddressLine2("----");
		office4.setCity("San Salvador de Jujuy");
		office4.setCountry("Argentina");
		office4.setOfficeCode("Sucursal 03"); //id ingresado manualmente
		office4.setPhone("4214567");
		office4.setPostalCode("4600");
		office4.setState("Jujuy");
		office4.setTerritory("----");
		
		officeService.guardarOffice(office4);
		
		Office office5 = new Office();
		
		office5.setAddressLine1("Patricias Argentinas 390");
		office5.setAddressLine2("----");
		office5.setCity("San Salvador de Jujuy");
		office5.setCountry("Argentina");
		office5.setOfficeCode("Central"); //id ingresado manualmente
		office5.setPhone("4903490");
		office5.setPostalCode("4600");
		office5.setState("Jujuy");
		office5.setTerritory("----");
		
		officeService.guardarOffice(office5);
		
		Office officeEnc = officeService.buscarOfficePorId("Contaduria");
		
		assertNotNull(officeEnc);
	}
}
