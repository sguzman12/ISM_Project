package dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee Data Access Object class with annotations for hibernate.
 * 
 * @author Sigfredo Guzman
 *
 */
@Entity
@Table(name = "employees")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmpID", updatable = false, nullable = false)
	private int id;

	@Column(name = "EmpFName")
	private String first;

	@Column(name = "EmpLName")
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

	@Column(name = "PayRate", columnDefinition = "DECIMAL(10,2)")
	private BigDecimal pay;

	@Column(name = "EmerConNum")
	private String contactNum;

	/**
	 * Default Constructor
	 */
	public Employee()
	{
	}

	/**
	 * One parameter Constructor
	 * 
	 * @param id
	 *            Employee ID
	 */
	public Employee(int id)
	{

	}

	/**
	 * Two parameter Constructor
	 * 
	 * @param first
	 *            Employee First Name
	 * @param last
	 *            Employee Last Name
	 */
	public Employee(String first, String last)
	{
		this.first = first;
		this.last = last;
	}

	/**
	 * Three parameter constructor
	 * 
	 * @param id
	 *            Employee ID
	 * @param first
	 *            Employee First Name
	 * @param last
	 *            Employee Last Name
	 */
	public Employee(int id, String first, String last)
	{
		this.id = id;
		this.first = first;
		this.last = last;
	}

	/**
	 * Four parameter Constructor
	 * 
	 * @param id
	 *            Employee ID
	 * @param first
	 *            Employee First Name
	 * @param last
	 *            Employee Last Name
	 * @param phone
	 *            Employee Phone number
	 */
	public Employee(int id, String first, String last, String phone)
	{
		this.id = id;
		this.first = first;
		this.last = last;
		this.phone = phone;
	}

	/**
	 * Constructor used for adding new employee.
	 * 
	 * @param first
	 *            Employee First Name
	 * @param last
	 *            Employee Last Name
	 * @param address
	 *            Employee Street Address
	 * @param city
	 *            Employee City
	 * @param state
	 *            Employee State
	 * @param zip
	 *            Employee Zip Code
	 * @param phone
	 *            Employee Phone number
	 * @param email
	 *            Employee Email
	 * @param pay
	 *            Employee Pay Rate
	 * @param contactNum
	 *            Employee Emergency Contact Number
	 */
	public Employee(String first, String last, String address, String city,
			String state, int zip, String phone, String email, BigDecimal pay,
			String contactNum)
	{
		this.first = first;
		this.last = last;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.pay = pay;
		this.contactNum = contactNum;
	}

	/**
	 * Constructor used when retrieving searched employees
	 * 
	 * @param id
	 *            Employee ID
	 * @param first
	 *            Employee First Name
	 * @param last
	 *            Employee Last Name
	 * @param address
	 *            Employee Street Address
	 * @param city
	 *            Employee City
	 * @param state
	 *            Employee State
	 * @param zip
	 *            Employee Zip Code
	 * @param phone
	 *            Employee Phone number
	 * @param email
	 *            Employee Email
	 * @param pay
	 *            Employee Pay Rate
	 * @param contactNum
	 *            Employee Emergency Contact Number
	 */
	public Employee(int id, String first, String last, String address,
			String city, String state, int zip, String phone, String email,
			BigDecimal pay, String contactNum)
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
		this.pay = pay;
		this.contactNum = contactNum;
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

	public BigDecimal getPay()
	{
		return pay;
	}

	public void setPay(BigDecimal pay)
	{
		this.pay = pay;
	}

	public String getContactNum()
	{
		return contactNum;
	}

	public void setContactNum(String contactNum)
	{
		this.contactNum = contactNum;
	}

}
