package ar.edu.unju.fi.TPFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.TPFinal.model.OrderDetail;
@Controller
public class OrderDetailController {

	@Autowired
	private OrderDetail orderDetail;
	
	@GetMapping("/orderDetail/nuevo")
	public String getPaymentsNuevo(Model model) {
		model.addAttribute(orderDetail);
		return "ordersDetails_nuevo";
	}
	
	@GetMapping("/orderDetail/listado")
	public String getPaymentsLista(Model model) {
		return "ordersDetails_listado";
	
	}

}
