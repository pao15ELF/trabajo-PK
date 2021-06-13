package ar.edu.unju.fi.TPFinal.model;

public class Customer {
	
	private int customersNumber;
	private String customersName; //tamaño 50
	private String contactLastName; // tamaño 50
	private String contactFirstName; // tamaño 50
	private String phone; //tamaño 50
	private String addressLine1; // tamaño 50
	private String addressLine2; // tamaño 50
	private String city; //tamaño 50
	private String state; // tamaño 50
	private String postalCode; //tamaño 15
	private String country; //tamaño 50
	private int salesRepEmployeeNumber;
	private double creditLimit;
	
	
	public Customer()
	{
		
	}


	/**
	 * @param customersNumber
	 * @param customersName
	 * @param contactLastName
	 * @param contactFirstName
	 * @param phone
	 * @param addressLine1
	 * @param addressLine2
	 * @param city
	 * @param state
	 * @param postalCode
	 * @param country
	 * @param salesRepEmployeeNumber
	 * @param creditLimit
	 */
	public Customer(int customersNumber, String customersName, String contactLastName, String contactFirstName,
			String phone, String addressLine1, String addressLine2, String city, String state, String postalCode,
			String country, int salesRepEmployeeNumber, double creditLimit) {
		super();
		this.customersNumber = customersNumber;
		this.customersName = customersName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
		this.creditLimit = creditLimit;
	}


	/**
	 * @return the customersNumber
	 */
	public int getCustomersNumber() {
		return customersNumber;
	}


	/**
	 * @param customersNumber the customersNumber to set
	 */
	public void setCustomersNumber(int customersNumber) {
		this.customersNumber = customersNumber;
	}


	/**
	 * @return the customersName
	 */
	public String getCustomersName() {
		return customersName;
	}


	/**
	 * @param customersName the customersName to set
	 */
	public void setCustomersName(String customersName) {
		this.customersName = customersName;
	}


	/**
	 * @return the contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}


	/**
	 * @param contactLastName the contactLastName to set
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}


	/**
	 * @return the contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}


	/**
	 * @param contactFirstName the contactFirstName to set
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}


	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}


	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}


	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}


	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}


	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}


	/**
	 * @return the salesRepEmployeeNumber
	 */
	public int getSalesRepEmployeeNumber() {
		return salesRepEmployeeNumber;
	}


	/**
	 * @param salesRepEmployeeNumber the salesRepEmployeeNumber to set
	 */
	public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
		this.salesRepEmployeeNumber = salesRepEmployeeNumber;
	}


	/**
	 * @return the creditLimit
	 */
	public double getCreditLimit() {
		return creditLimit;
	}


	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}


	@Override
	public String toString() {
		return "Customers [customersNumber=" + customersNumber + ", customersName=" + customersName
				+ ", contactLastName=" + contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone
				+ ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
				+ state + ", postalCode=" + postalCode + ", country=" + country + ", salesRepEmployeeNumber="
				+ salesRepEmployeeNumber + ", creditLimit=" + creditLimit + "]";
	}

	
	
}
