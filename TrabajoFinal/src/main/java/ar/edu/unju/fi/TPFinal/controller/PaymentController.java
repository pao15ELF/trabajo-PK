package ar.edu.unju.fi.TPFinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.TPFinal.model.Payment;
@Controller
public class PaymentController {
	
	@Autowired
	private Payment payment;
	
	@GetMapping("/payments/nuevo")
	public String getPaymentsNuevo(Model model) {
		model.addAttribute(payment);
		return "payments_nuevo";
	}
	
	@GetMapping("/payments/listado")
	public String getPaymentsLista(Model model) {
		return "payments_listado";
	}

}
