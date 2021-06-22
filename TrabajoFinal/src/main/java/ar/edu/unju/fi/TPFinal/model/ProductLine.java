package ar.edu.unju.fi.TPFinal.model;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="PRODUCTLINES")
public class ProductLine {
	
	@Id
	@Column(name = "productline")
	private String productLine; //tamaño 50
	

	@Column(name = "textDescription", length=4000, nullable=true)
	private String textDescription; // tamaño 4000 
	
	
	@Column(name = "htmlDescription", length=100, nullable=true)
	private String htmlDescription; //Preguntar con respecto a MEDIUMTEXT
	
	
	@Column(name = "image")
	private Blob image;  //Averiguar 
	
	@Valid
	@OneToMany(mappedBy = "productLine" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();
	
	public ProductLine ()
	{
		
	}
	

	/**
	 * @param productLine
	 * @param textDescription
	 * @param htmlDescription
	 * @param image
	 */
	public ProductLine(String productLine, String textDescription, String htmlDescription, Blob image) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
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
	
	/**
	 * @return the image
	 */
	public Blob getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Blob image) {
		this.image = image;
	}


	
	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return products;
	}


	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}


	@Override
	public String toString() {
		return "ProductLine [productLine=" + productLine + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + image + "]";
	}

		
}
