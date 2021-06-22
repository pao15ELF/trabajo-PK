package ar.edu.unju.fi.TPFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.TPFinal.model.Order;
@Controller
public class OrderController {

	@Autowired
	private Order order;
	
	@GetMapping("/order/nuevo")
	public String getPaymentsNuevo(Model model) {
		model.addAttribute(order);
		return "orders_nuevo";
	}
	
	@GetMapping("/order/listado")
	public String getPaymentsLista(Model model) {
		return "orders_listado";
	
	}
}
