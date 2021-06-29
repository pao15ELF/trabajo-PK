package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.model.ProductLine;
import ar.edu.unju.fi.TPFinal.service.IProductLineService;
import ar.edu.unju.fi.TPFinal.service.IProductService;


@SpringBootTest
class ProductLineTest {
	private static final Log LOGGER = LogFactory.getLog(ProductLineTest.class);
	
	@Autowired
	private IProductLineService productLineService; 
	@Autowired
	private IProductService productService;
	
	@Test
	void cargarProductLine() {
		
		ProductLine marca1 = new ProductLine("SRN-01","La Serenisima",null,null,null);
		productLineService.guardarProductLine(marca1);
		ProductLine encontrado = productLineService.buscarProductLinePorId("SRN-01");
		ProductLine marca2 = new ProductLine("ARC-01","Arcor",null,null,null);
		productLineService.guardarProductLine(marca2);
		
		assertEquals(marca1.getProductLine(), encontrado.getProductLine());
	}
	
	//@Test
	void listaProductos() {
		ProductLine encontrado = productLineService.buscarProductLinePorId("SRN-01");
		List<Product> lista = productService.buscarListaProductosPorLineProduct(encontrado); 
		LOGGER.info("lista de productos: "+ lista.get(0).getProductCode());
		assertEquals(lista.size(),2);
	}

}
