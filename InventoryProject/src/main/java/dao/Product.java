package dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Products DAO Object class with hibernate annotations.
 * 
 * @author Sigfredo Guzman
 *
 */
@Entity
@Table(name = "products")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	private int id;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Category")
	private String category;

	@Column(name = "Price")
	private BigDecimal price;

	public Product()
	{
	}

	public Product(int id)
	{
		this.id = id;
	}

	public Product(int id, int quantity)
	{
		this.id = id;
		this.quantity = quantity;
	}

	public Product(int id, int quantity, BigDecimal price)
	{
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	
	public Product(String description, int quantity, String category, BigDecimal price) 
	{
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.price = price;
	}

	public Product(int id, String description, int quantity, String category, BigDecimal price)
	{
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.price = price;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
