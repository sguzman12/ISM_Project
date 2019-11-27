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

	/**
	 * Default Constructor.
	 */
	public Product()
	{
	}

	/**
	 * One parameter Constructor
	 * 
	 * @param id
	 *            Product ID
	 */
	public Product(int id)
	{
		this.id = id;
	}

	/**
	 * Two parameter Constructor
	 * 
	 * @param id
	 *            Product ID
	 * @param quantity
	 *            Product Quantity
	 */
	public Product(int id, int quantity)
	{
		this.id = id;
		this.quantity = quantity;
	}

	/**
	 * Three parameter Constructor
	 * 
	 * @param id
	 *            Product ID
	 * @param quantity
	 *            Product Quantity
	 * @param price
	 *            Product Price
	 */
	public Product(int id, int quantity, BigDecimal price)
	{
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}

	/**
	 * Four parameter Constructor. Used to add new product.
	 * 
	 * @param description
	 *            Product Name
	 * @param quantity
	 *            Product Quantity
	 * @param category
	 *            Product Category
	 * @param price
	 *            Product Price
	 */
	public Product(String description, int quantity, String category,
			BigDecimal price)
	{
		this.description = description;
		this.quantity = quantity;
		this.category = category;
		this.price = price;
	}

	/**
	 * Five parameter Constructor. Used when retrieving products from table.
	 * 
	 * @param id
	 *            Product ID
	 * @param description
	 *            Product Name
	 * @param quantity
	 *            Product Quantity
	 * @param category
	 *            Product Category
	 * @param price
	 *            Product Price
	 */
	public Product(int id, String description, int quantity, String category,
			BigDecimal price)
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
