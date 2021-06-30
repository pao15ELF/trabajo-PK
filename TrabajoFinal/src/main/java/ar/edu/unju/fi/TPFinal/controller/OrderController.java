package ar.edu.unju.fi.TPFinal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
import ar.edu.unju.fi.TPFinal.model.PaymentId;
import ar.edu.unju.fi.TPFinal.model.Product;
import ar.edu.unju.fi.TPFinal.service.ICustomerService;
import ar.edu.unju.fi.TPFinal.service.IOrderDetailService;
import ar.edu.unju.fi.TPFinal.service.IOrderService;
import ar.edu.unju.fi.TPFinal.service.IPaymentService;
import ar.edu.unju.fi.TPFinal.service.IProductService;

@Controller
public class OrderController {
	private static final Log LOGGER = LogFactory.getLog(OrderController.class);
	@Autowired
	private Order order;
	
	@Autowired
	private OrderDetail orderDetail;
	
	@Autowired
	private Payment payment;
	
	@Autowired
	@Qualifier("orderServiceImp")
	private IOrderService orderService;
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	@Qualifier("orderDetailServiceImp")
	private IOrderDetailService orderDetailService;
	
	@Autowired
	private IPaymentService paymentService;
	
	private Customer customer1;
	
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	private List<Product> productosOrdenados = new ArrayList<Product>();
	
	private double total=0;
	
	private Product controlProd;
	
	@GetMapping("/orderDetail/nuevo")
	public ModelAndView nuevoOrderDetailPage() {
		ModelAndView mav = new ModelAndView("nuevo_orderDetail"); 
		mav.addObject("orderDetail", orderDetail);
		mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
		//mav.addObject("siguiente", false);
		return mav;
	}
	
	public boolean controlOrdenMayorStock(Product product,short cantidadOrdenada) {
		boolean mayor=false;
		for(Product p : productosOrdenados) {
			if (p.getProductCode()==product.getProductCode())
				if(cantidadOrdenada>p.getQuantityInStock())
					mayor=true;
		}
		return mayor;
	}
	
	public boolean controlStockIgualCero(Product product) {
		boolean stockCero=false;
			for(Product p:productosOrdenados) {
				if (p.getProductCode()==product.getProductCode()) {
					if(p.getQuantityInStock()<=0)
						stockCero=true;
				}
			}
		return stockCero;
	}
	
	public void actualizarStockProducto(Product prod, short cantidad) {
		short stock=prod.getQuantityInStock();
		for(Product p:productosOrdenados) {
			if(p.getProductCode()==prod.getProductCode()) {
				stock=(short)(stock-cantidad);
				p.setQuantityInStock(stock);
			}	
		}
		LOGGER.info("stock actualizado en la lista de pedidos:"+stock);
	}
	
	public void quitarProductoDeOrdenados(Product controlProd) {
		int index=0;
		
		for(int i=0;i<=productosOrdenados.size()-1;i++) {
			if(productosOrdenados.get(i).getProductCode()==controlProd.getProductCode()) {
				index=i;
				break;
			}	
		}
		productosOrdenados.remove(index);
	}
	
	public void agregarProductoLista(Product producto) {
		boolean encontrado=false;
		if(productosOrdenados.size()!=0) {
			for(Product p: productosOrdenados) {
				if (p.getProductCode()==producto.getProductCode())
					encontrado=true;
			}	
		}
		if(encontrado==false) {
			productosOrdenados.add(producto);
		}	
	}
	
	public void modificarStock(short cant) {
		short stock=controlProd.getQuantityInStock();
		stock=(short)(stock-cant);
		controlProd.setQuantityInStock(cant);
	}
	
	@PostMapping("/orderDetail/cargar/siguiente")
	public ModelAndView guardarOrderPage(@Valid @ModelAttribute("orderDetail")OrderDetail unOrderDetail, BindingResult resultadoValidacion) {
		ModelAndView mav = new ModelAndView("nuevo_orderDetail");
		orderDetails.add(unOrderDetail);
		short stockProd=0,cantidadOrdenada=0;
		String mensajeControl="";
		if (resultadoValidacion.hasErrors()) {
			mav.addObject("orderDetail", unOrderDetail);
			mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
			
		}else {
			//control de stock
			controlProd = productService.buscarProductPorId(unOrderDetail.getOrderDetailId().getProductCode().getProductCode());
			cantidadOrdenada=(short)unOrderDetail.getQuantityOrdered();			
			stockProd= controlProd.getQuantityInStock();
			if (stockProd<=0) {
				mensajeControl="No hay stock para el producto solicitado";
				mav.addObject("mensajeControl", mensajeControl);
				mav.addObject("orderDetail", unOrderDetail);
				mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
			}else {
				if(cantidadOrdenada>stockProd) {
					mensajeControl="La cantidad ordenada supera al stock del producto solicitado";
					mav.addObject("mensajeControl", mensajeControl);
					mav.addObject("orderDetail", unOrderDetail);
					mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
				}else {
					modificarStock(cantidadOrdenada);
					productosOrdenados.add(controlProd);
					mav.addObject("orderDetail", orderDetail);
					mav.addObject("products", productService.obtenerListaProductsPorEstadoActivo());
					controlProd = new Product();
				}
			}
		}
		return mav;
	}
	
	//@GetMapping("/order/nuevo")
	public ModelAndView nuevoOrderPage() {
		ModelAndView mav = new ModelAndView("nuevo_order");
		mav.addObject("order", order);
		mav.addObject("customers", customerService.listaCustomers());
		return mav;
	}
	
	@PostMapping("/order/nuevo")
	public ModelAndView postNuevoOrderPage(@ModelAttribute("orderDetail") OrderDetail unOrderDetail) {
		ModelAndView mav;
		orderDetails.add(unOrderDetail);
		short stockProd=0,cantidadOrdenada=0;
		String mensajeControl="";
		controlProd = productService.buscarProductPorId(unOrderDetail.getOrderDetailId().getProductCode().getProductCode());
		cantidadOrdenada = (short) unOrderDetail.getQuantityOrdered();
		stockProd=controlProd.getQuantityInStock();
		if (stockProd<=0) {
			mav = new ModelAndView("nuevo_orderDetail");
			mensajeControl="No hay stock para el producto solicitado";
			mav.addObject("orderDetail", unOrderDetail);
			mav.addObject("products",productService.obtenerListaProductsPorEstadoActivo());
			mav.addObject("mensajeControl", mensajeControl);
		}else {
			if(cantidadOrdenada>stockProd) {
				mav = new ModelAndView("nuevo_orderDetail");
				mensajeControl="La cantidad ordenada supera al stock del producto solicitado";
				mav.addObject("orderDetail", unOrderDetail);
				mav.addObject("products",productService.obtenerListaProductsPorEstadoActivo());
				mav.addObject("mensajeControl", mensajeControl);
			}else {
				modificarStock(cantidadOrdenada);
				productosOrdenados.add(controlProd); 
				mav = new ModelAndView("nuevo_order");
				mav.addObject("order", order);
				mav.addObject("customers", customerService.listaCustomers());
				controlProd = new Product();
			}
		}
		return mav;
	}
	
	@PostMapping("/order/control")
	public ModelAndView pagarOrderPage(@Valid @ModelAttribute("order")Order unOrder, BindingResult resultadoValidacion) {
		ModelAndView mav;
		int stock=0,cantidadOrdenada=0;
		//calculo auxiliar de monto total de la compra
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_order");
			mav.addObject("order", unOrder);
			mav.addObject("customers", customerService.listaCustomers());
		}else {
			orderService.guardarOrder(unOrder);
			//controlar stock
			for(OrderDetail o: orderDetails) {
				OrderDetailId oId = new OrderDetailId();
				oId.setProductCode(o.getOrderDetailId().getProductCode());				
				//cantidadOrdenada = (short) o.getQuantityOrdered();
				//stock = productoE.getQuantityInStock()-cantidadOrdenada;
				//productoE.setQuantityInStock((short)stock);
				productService.guardarProduct(o.getOrderDetailId().getProductCode());
				oId.setOrderNumber(unOrder);
				o.setOrderDetailId(oId);
				orderDetailService.guardarOrderDetail(o);
				total=total+(o.getPriceEach()*o.getQuantityOrdered());
				oId=null;
			}
			LOGGER.info("cliente1 "+unOrder.getCustomerNumber().getCustomerNumber());
			customer1 = customerService.buscarCustomerPorId(unOrder.getCustomerNumber().getCustomerNumber());
			mav = new ModelAndView("nuevo_payment");			
			mav.addObject("payment", payment);
			mav.addObject("customer", customer1);
			
			mav.addObject("total", total);
		}
		return mav;
		
	}
	
	@PostMapping("/payment/guardar")
	public ModelAndView realizarPaymentPage(@Valid @ModelAttribute("payment")Payment unPayment, BindingResult resultadoValidacion) {
		ModelAndView mav;
		PaymentId pId = new PaymentId();
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_payment");
			mav.addObject("customer",customer1);
			mav.addObject("payment", unPayment);
			mav.addObject("total", total);
		}
		else {
			pId.setCheckNumber(unPayment.getPaymentId().getCheckNumber());
			pId.setCustomersNumber(customer1);
			unPayment.setPaymentId(pId);
			unPayment.setAmount(total);
			paymentService.guardarPayment(unPayment);
			mav = new ModelAndView("resultado_payment");
			mav.addObject("payment", unPayment);
			customer1= new Customer();
			total=0;
			orderDetails= new ArrayList<OrderDetail>();;
		}
		return mav;
		
	}
}
