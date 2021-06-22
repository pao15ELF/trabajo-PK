package ar.edu.unju.fi.TPFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.TPFinal.model.Customer;

@Controller
public class CustomerController {
	@Autowired
	private Customer customer;

		@GetMapping("/cliente/nuevo")
		public String getClienteNuevo(Model model) {
			model.addAttribute(customer);
			return "cliente_nuevo";
		}
		@GetMapping("/cliente/listado")
		public String getListaCliente(Model model) {
			
			
			return "cliente_listado";
		}
		

}
