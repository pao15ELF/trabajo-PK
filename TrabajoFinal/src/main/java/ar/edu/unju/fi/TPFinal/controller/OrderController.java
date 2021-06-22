package ar.edu.unju.fi.TPFinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFinal.model.Customer;
import ar.edu.unju.fi.TPFinal.model.Order;
import ar.edu.unju.fi.TPFinal.model.OrderDetail;
import ar.edu.unju.fi.TPFinal.model.OrderDetailId;
import ar.edu.unju.fi.TPFinal.model.Payment;
import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.service.IOrderDetailService;
import ar.edu.unju.fi.TPFinal.service.IOrderService;


//@Controller
public class OrderController {

	@Autowired
	private Customer customer;
	
	@Autowired
	private Order order;
	
	@Autowired
	private OrderDetail orderDetail;
	
	@Autowired
	private Product product;
	
	@Autowired
	private Payment payment;
	
	@Autowired
	@Qualifier("orderServiceImp")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("orderDetailServiceImp")
	private IOrderDetailService orderDetailService;
	
	@GetMapping("/order/nuevo")
	public ModelAndView nuevoOrderPage() {
		ModelAndView mav = new ModelAndView("nuevo_order"); 
		mav.addObject("customer", customer);
		mav.addObject("order", order);
		mav.addObject("product", product);
		return mav;
	}
	
	@PostMapping("/order/cargar/siguiente")
	public ModelAndView guardarOrderPage(@ModelAttribute("customer") Customer unCustomer,@ModelAttribute("product")Product unProduct,@Valid @ModelAttribute("order")Order unOrder, @Valid @ModelAttribute("orderDetail")OrderDetail unOrderDetail, BindingResult resultadoValidacion) {
		ModelAndView mav = new ModelAndView("nuevo_order");;
		OrderDetailId orderDetailId = new OrderDetailId();
		if (resultadoValidacion.hasErrors()) {
			mav.addObject("customer", unCustomer);
			mav.addObject("order", unOrder);
			mav.addObject("product", product);
		}else {
			unOrder.setCustomerNumber(unCustomer);
			orderService.guardarOrder(unOrder);
			orderDetailId.setOrderNumber(unOrder);
			orderDetailId.setProductCode(unProduct);
			unOrderDetail.setOrderDetailId(orderDetailId);
			orderDetailService.guardarOrderDetail(unOrderDetail);
			mav.addObject("customer",unCustomer);
			mav.addObject("order",unOrder);
			mav.addObject("product", product);
		}
		return mav;
	}
	
	@PostMapping("/payment/nuevo")
	public ModelAndView pagarOrderPage(@ModelAttribute("customer") Customer unCustomer,@ModelAttribute("order")Order unOrder) {
		ModelAndView mav = new ModelAndView("nuevo_payment");
		List<OrderDetail> lista = orderDetailService.buscarOrdersPorOrderNumber(unOrder);
		//calculo auxiliar de monto total de la compra
		double total=0;
		for(OrderDetail o: lista) {
			total+=o.getPriceEach()*o.getQuantityOrdered();
		}
		//monto de la orden
		mav.addObject("amount", total);
		mav.addObject("customer", unCustomer);
		mav.addObject("payment", payment);
		return mav;
		
	}
	
	@PostMapping("/payment/pagar")
	public ModelAndView realizarPaymentPage(@Valid @ModelAttribute("payment")Payment unPayment,@ModelAttribute("order")Order unOrder, BindingResult resultadoValidacion) {
		ModelAndView mav;
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_payment");
			List<OrderDetail> lista = orderDetailService.buscarOrdersPorOrderNumber(unOrder);
			double total=0;
			for(OrderDetail o: lista) {
				total+=o.getPriceEach()*o.getQuantityOrdered();
			}
			mav.addObject("customer", unPayment.getPaymentId().getCustomersNumber());
			mav.addObject("payment", unPayment);
			mav.addObject("amount", total);
		}
		else {
			mav = new ModelAndView("resultado_payment");
		}
		return mav;
		
	}
}
