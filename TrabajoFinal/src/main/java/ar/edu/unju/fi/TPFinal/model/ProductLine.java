package ar.edu.unju.fi.TPFinal.model;

public class ProductLine {
	
	private String productLine; //tamaño 50
	private String textDescription; // tamaño 4000 
	private String htmlDescription; //Preguntar con respecto a MEDIUMTEXT
	//private Blob image;  //Averiguar 
	
	public ProductLine ()
	{
		
	}
	
	
	/**
	 * @param productLine
	 * @param textDescription
	 * @param htmlDescription
	 */
	public ProductLine(String productLine, String textDescription, String htmlDescription) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
	}


	/**
	 * @return the productLine
	 */
	public String getProductLine() {
		return productLine;
	}


	/**
	 * @param productLine the productLine to set
	 */
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}


	/**
	 * @return the textDescription
	 */
	public String getTextDescription() {
		return textDescription;
	}


	/**
	 * @param textDescription the textDescription to set
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}


	/**
	 * @return the htmlDescription
	 */
	public String getHtmlDescription() {
		return htmlDescription;
	}


	/**
	 * @param htmlDescription the htmlDescription to set
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}


	@Override
	public String toString() {
		return "ProductLines [productLine=" + productLine + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + "]";
	}
	
	
	

}
