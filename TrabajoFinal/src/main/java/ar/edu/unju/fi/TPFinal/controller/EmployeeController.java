package ar.edu.unju.fi.TPFinal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.TPFinal.model.Employee;
import ar.edu.unju.fi.TPFinal.service.IEmployeeService;
import ar.edu.unju.fi.TPFinal.service.IOfficeService;

//@Controller
public class EmployeeController {

	@Autowired
	private Employee employee;
	
	@Autowired
	@Qualifier("employeeServiceImp")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("officeServiceImp")
	private IOfficeService officeService;
	
	@GetMapping("/employee/nuevo")
	public ModelAndView getNuevoEmployeePage() {
		ModelAndView mav = new ModelAndView("nuevo_employee");
		mav.addObject("employee", employee);
		mav.addObject("offices", officeService.obtenerListaOffices());
		return mav;
	}
	
	@GetMapping("/employee/lista")
	public ModelAndView getListaEmployeePage() {
		ModelAndView mav = new ModelAndView("lista_employee");
		mav.addObject("employees", employeeService.listaemployees());
		return mav;
	}
	
	@GetMapping("/employee/eliminar/{employeeNumber}")
	public ModelAndView getEliminarEmployeePage(@PathVariable(value ="employeeNumber")Integer id) {
		ModelAndView mav = new ModelAndView("lista_employee");
		employeeService.eliminarEmployee(id);
		mav.addObject("employees", employeeService.listaemployees());
		
		return mav;
	}
	
	@GetMapping("/employee/modificar/{employeeNumber}")
	public ModelAndView getModificarEmployeePage(@PathVariable(value = "employeeNumber")Integer id) {
		ModelAndView mav = new ModelAndView("nuevo_employee");
		Employee encontrado = employeeService.buscarEmployeePorId(id);
		mav.addObject("employee",encontrado );
		mav.addObject("offices", officeService.obtenerListaOffices());
		return mav;
	}
	
	@PostMapping("/employee/guardar")
	public ModelAndView postGuardarEmployeePage(@Valid @ModelAttribute("employee")Employee unEmployee, BindingResult resultadoValidacion) {
		ModelAndView mav;
		if (resultadoValidacion.hasErrors()) {
			mav = new ModelAndView("nuevo_employee");
			mav.addObject("employee", unEmployee);
			mav.addObject("offices", officeService.obtenerListaOffices());
		}else {
			mav = new ModelAndView("lista_employee");
			mav.addObject("employees", employeeService.listaemployees());
		}
		return mav;
	}
}
