package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ingredient DAO class
 * 
 * @author Sigfredo Guzman
 *
 */
@Entity
@Table(name = "ingredients")
public class Ingredient
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IngredientID")
	private int id;

	@Column(name = "Description")
	private String description;

	@Column(name = "Quantity")
	private int quantity;

	/**
	 * Default Constructor
	 */
	public Ingredient()
	{
	}

	/**
	 * One parameter Constructor
	 * 
	 * @param id
	 *            Ingredient ID
	 */
	public Ingredient(int id)
	{
		this.id = id;
	}

	/**
	 * Two parameter Constructor
	 * 
	 * @param id
	 *            Ingredient ID
	 * @param des
	 *            Ingredient Name
	 */
	public Ingredient(int id, String des)
	{
		this.id = id;
		description = des;
	}

	/**
	 * Three parameter Constructor
	 * 
	 * @param id
	 *            Ingredient ID
	 * @param des
	 *            Ingredient Name
	 * @param quantity
	 *            Ingredient Quantity
	 */
	public Ingredient(int id, String des, int quantity)
	{
		this.id = id;
		description = des;
		this.quantity = quantity;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
}
