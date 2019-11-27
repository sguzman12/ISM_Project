package dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Customers Object DAO class. Sets Up Annotations for use in Hibernate ORM.
 * 
 * @author Sigfredo Guzman
 *
 */
@Entity
@Table(name = "customers")
public class Customer
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CustID", updatable = false, nullable = false)
	private int id;

	@Column(name = "CustFName")
	private String first;

	@Column(name = "CustLName")
	private String last;

	@Column(name = "StreetAddress")
	private String address;

	@Column(name = "City")
	private String city;

	@Column(name = "State")
	private String state;

	@Column(name = "Zip")
	private int zip;

	@Column(name = "PhoneNum")
	private String phone;

	@Column(name = "Email")
	private String email;

	/**
	 * Default Constructor
	 */
	public Customer()
	{
	}

	/**
	 * One parameter Constructor. Used When searching for customer object.
	 * 
	 * @param id
	 *            Customer ID number
	 */
	public Customer(int id)
	{
		this.id = id;
	}

	/**
	 * Two parameter Constructor.
	 * 
	 * @param first
	 *            Customer First Name
	 * @param last
	 *            Customer Last Name
	 */
	public Customer(String first, String last)
	{
		this.first = first;
		this.last = last;
	}

	/**
	 * Three parameter Constructor
	 * 
	 * @param id
	 *            Customer ID
	 * @param first
	 *            Customer First Name
	 * @param last
	 *            Customer Last Name
	 */
	public Customer(int id, String first, String last)
	{
		this.id = id;
		this.first = first;
		this.last = last;
	}

	/**
	 * Four parameter Constructor
	 * 
	 * @param id
	 *            Customer ID
	 * @param first
	 *            Customer First Name
	 * @param last
	 *            Customer Last Name
	 * @param phone
	 *            Customer Phone number
	 */
	public Customer(int id, String first, String last, String phone)
	{
		this.id = id;
		this.first = first;
		this.last = last;
		this.phone = phone;
	}

	/**
	 * Used when Adding New Customer to table.
	 * 
	 * @param first
	 *            Customer First Name
	 * @param last
	 *            Customer Last Name
	 * @param address
	 *            Customer Street Address
	 * @param city
	 *            Customer City
	 * @param state
	 *            Customer State
	 * @param zip
	 *            Customer Zip Code
	 * @param phone
	 *            Customer Phone Number
	 * @param email
	 *            Customer Email
	 */
	public Customer(String first, String last, String address, String city,
			String state, int zip, String phone, String email)
	{
		this.first = first;
		this.last = last;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}

	/**
	 * Used when returning ArrayList of all Customers
	 * 
	 * @param id
	 *            Customer ID
	 * @param first
	 *            Customer First Name
	 * @param last
	 *            Customer Last Name
	 * @param address
	 *            Customer Street Address
	 * @param city
	 *            Customer City
	 * @param state
	 *            Customer State
	 * @param zip
	 *            Customer Zip Code
	 * @param phone
	 *            Customer Phone Number
	 * @param email
	 *            Customer Email
	 */
	public Customer(int id, String first, String last, String address,
			String city, String state, int zip, String phone, String email)
	{
		this.id = id;
		this.first = first;
		this.last = last;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getFirst()
	{
		return first;
	}

	public void setFirst(String first)
	{
		this.first = first;
	}

	public String getLast()
	{
		return last;
	}

	public void setLast(String last)
	{
		this.last = last;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public int getZip()
	{
		return zip;
	}

	public void setZip(int zip)
	{
		this.zip = zip;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}
