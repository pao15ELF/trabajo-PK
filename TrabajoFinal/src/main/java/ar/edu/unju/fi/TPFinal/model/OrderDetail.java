package ar.edu.unju.fi.TPFinal.model;

public class OrderDetail {
	
	private int orderNumber; 
	private String productCode; //tamaño 15
	private int quantityOrdered;
	private double priceEach; 
	private short orderLineNumber;
	
	public OrderDetail()
	{
		
	}

	
	/**
	 * @param orderNumber
	 * @param productCode
	 * @param quantityOrdered
	 * @param priceEach
	 * @param orderLineNumber
	 */
	public OrderDetail(int orderNumber, String productCode, int quantityOrdered, double priceEach,
			short orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}


	/**
	 * @return the orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}


	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}


	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}


	/**
	 * @param productCode the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	/**
	 * @return the quantityOrdered
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}


	/**
	 * @param quantityOrdered the quantityOrdered to set
	 */
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}


	/**
	 * @return the priceEach
	 */
	public double getPriceEach() {
		return priceEach;
	}


	/**
	 * @param priceEach the priceEach to set
	 */
	public void setPriceEach(double priceEach) {
		this.priceEach = priceEach;
	}


	/**
	 * @return the orderLineNumber
	 */
	public short getOrderLineNumber() {
		return orderLineNumber;
	}


	/**
	 * @param orderLineNumber the orderLineNumber to set
	 */
	public void setOrderLineNumber(short orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}


	@Override
	public String toString() {
		return "OrderDetails [orderNumber=" + orderNumber + ", productCode=" + productCode + ", quantityOrdered="
				+ quantityOrdered + ", priceEach=" + priceEach + ", orderLineNumber=" + orderLineNumber + "]";
	}

	
	
	
}
