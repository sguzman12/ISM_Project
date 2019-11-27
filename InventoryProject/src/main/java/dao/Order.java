package dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Order DAO object class with hibernate annotations.
 * 
 * @author Sigfredo Guzman
 *
 */

@Entity
@Table(name = "orders")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderNum")
	private int id;

	@Column(name = "CustID")
	private int customer;

	@Column(name = "EmployeeID")
	private int employee;

	@Column(name = "OrderDate")
	private Date orderDate;

	@Column(name = "DeliveryDate")
	private Date deliveryDate;

	/**
	 * Default Constructor
	 */
	public Order()
	{
	}

	/**
	 * One parameter Constructor
	 * 
	 * @param id
	 *            Order Number
	 */
	public Order(int id)
	{
		this.id = id;
	}

	/**
	 * Two parameter Constructor
	 * 
	 * @param id
	 *            Order Number
	 * @param cust
	 *            Customer ID
	 */
	public Order(int id, int cust)
	{
		this.id = id;
		customer = cust;
	}

	/**
	 * Three parameter Constructor
	 * 
	 * @param id
	 *            Order Number
	 * @param cust
	 *            Customer ID
	 * @param employee
	 *            Employee ID
	 */
	public Order(int id, int cust, int employee)
	{
		this.id = id;
		customer = cust;
		this.employee = employee;
	}

	/**
	 * Four parameter Constructor. Used to add new order.
	 * 
	 * @param customer
	 *            Customer ID
	 * @param employee
	 *            Employee ID
	 * @param orderDate
	 *            Date Ordered
	 * @param deliveryDate
	 *            Date to Deliver
	 */
	public Order(int customer, int employee, Date orderDate, Date deliveryDate)
	{
		this.customer = customer;
		this.employee = employee;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
	}

	/**
	 * Constructor used to return orders.
	 * 
	 * @param id
	 *            Order Number
	 * @param customer
	 *            Customer ID
	 * @param employee
	 *            Employee ID
	 * @param orderDate
	 *            Date Ordered
	 * @param deliveryDate
	 *            Date to Deliver
	 */
	public Order(int id, int customer, int employee, Date orderDate,
			Date deliveryDate)
	{
		this.id = id;
		this.customer = customer;
		this.employee = employee;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getCustomer()
	{
		return customer;
	}

	public void setCustomer(int customer)
	{
		this.customer = customer;
	}

	public int getEmployee()
	{
		return employee;
	}

	public void setEmployee(int employee)
	{
		this.employee = employee;
	}

	public Date getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(Date orderDate)
	{
		this.orderDate = orderDate;
	}

	public Date getDeliveryDate()
	{
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate)
	{
		this.deliveryDate = deliveryDate;
	}
}
