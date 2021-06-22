package ar.edu.unju.fi.TPFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "EMPLOYEES")
@Component
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeNumber")
	private Integer employeeNumber;
	
	@NotEmpty(message="Debe ingresar el apellido del empleado")
	@Column(name = "lastName", length=50, nullable=false)
	private String lastName; //tamaño 50
	
	@NotEmpty(message="Debe ingresar el nombre del empleado")
	@Column(name = "firstName", length=50, nullable=false)
	private String firstName; //tamaño 50
	
	@NotEmpty(message="Debe ingresar la extension")
	@Column(name = "extension", length=10, nullable=false)
	private String extension; // tamaño 10
	
	@NotEmpty(message="Debe ingresar un correo electronico valido")
	@Column(name = "email", length=100, nullable=false)
	private String email; // tamaño 100
	
	@Valid
	@Autowired
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "officeCode")
	private Office officeCode; //tamaño 10
	
	
	@Valid
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "reportsTo")
	private Employee reportsTo; 
	
	@NotEmpty(message="Debe ingresar el titulo de trabajo del empleado")
	@Column(name = "jobTitle", length=50, nullable=false)
	private String jobTitle; //tamaño50
	
	@OneToMany(mappedBy = "salesRepEmployeeNumber",fetch = FetchType.EAGER)
	private List<Customer> customers = new ArrayList<Customer>();
	
	public Employee()
	{
		
	}


	/**
	 * @param employeeNumber
	 * @param lastName
	 * @param firstName
	 * @param extension
	 * @param email
	 * @param officeCode
	 * @param reportsTo
	 * @param jobTitle
	 */
	public Employee(Integer employeeNumber, String lastName, String firstName, String extension, String email,
			Office officeCode, Employee reportsTo, String jobTitle) {
		
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}



	/**
	 * @return the employeeNumber
	 */
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}



	/**
	 * @param employeeNumber the employeeNumber to set
	 */
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}



	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}



	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}



	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the officeCode
	 */
	public Office getOfficeCode() {
		return officeCode;
	}



	/**
	 * @param officeCode the officeCode to set
	 */
	public void setOfficeCode(Office officeCode) {
		this.officeCode = officeCode;
	}



	/**
	 * @return the reportsTo
	 */
	public Employee getReportsTo() {
		return reportsTo;
	}



	/**
	 * @param reportsTo the reportsTo to set
	 */
	public void setReportsTo(Employee reportsTo) {
		this.reportsTo = reportsTo;
	}



	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}



	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	
	
	/**
	 * @return the customers
	 */
	public List<Customer> getCustomers() {
		return customers;
	}



	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}



	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", officeCode=" + officeCode + ", reportsTo="
				+ reportsTo + ", jobTitle=" + jobTitle + "]";
	}


	
	
}
