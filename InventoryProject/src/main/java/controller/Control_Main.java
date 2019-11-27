package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.Customer;
import dao.Employee;
import dao.Order;
import dao.Product;
import dao.ProductSold;
import dao.Sale;
import model.CustomerModel;
import model.EmployeeModel;
import model.OrderModel;
import model.ProductModel;
import model.SaleModel;
import view.FX_Gui;

/**
 * 
 * @author Sigfredo Guzman
 * Control class that handles and communicates between the GUI, Hibernate Utility class, and Model packages
 */
public class Control_Main
{
	EmployeeModel eModel;
	CustomerModel cModel;
	ProductModel pModel;
	OrderModel oModel;
	SaleModel sModel;
	Session session;

	/**
	 * Default Constructor. Initializes Model package classes.
	 */
	public Control_Main()
	{
		eModel = new EmployeeModel();
		cModel = new CustomerModel();
		pModel = new ProductModel();
		oModel = new OrderModel();
		sModel = new SaleModel();
	}

	/**
	 * One parameter Constructor. Passed session object saved into controller.
	 * @param sess Session session Object
	 */
	public Control_Main(Session sess)
	{
		session = sess;
	}

	/**
	 * Calls JavaFX GUI constructor 
	 * @throws Exception
	 */
	public void begin() throws Exception
	{
		FX_Gui gui = new FX_Gui();
		gui.initialize();
	}

	/**
	 * Passed in details of New Employee and calls the Employee Model method to add new employee to database table employee.
	 * @param first Employee First Name
	 * @param last Employee Last Name
	 * @param address Employee Street Address
	 * @param city Employee City
	 * @param state Employee State
	 * @param zip Employee Zip Code
	 * @param phone Employee Phone Number
	 * @param email Employee Email
	 * @param pay Employee Pay Rate
	 * @param contact Employee Emergency Contact Number
	 */
	public void addEmployee(String first, String last, String address,
			String city, String state, int zip, String phone, String email,
			BigDecimal pay, String contact)
	{

		eModel.addEmployeeToDB(first, last, address, city, state, zip, phone,
				email, pay, contact);
	}

	/**
	 * Search Employee Table by Employee last name. Calls Employee Model and return ArrayList of all
	 * employees with last name.
	 * @param last Employee Last Name input
	 * @return employee ArrayList of Employee object
	 */
	public ArrayList<Employee> searchEmployee(String last)
	{

		ArrayList<Employee> employee = new ArrayList<Employee>();

		employee = (ArrayList<Employee>)eModel.searchEmployees(last);

		return employee;
	}
	
	/**
	 * Search Product by name inside Product table. Calls Product Model and returns ArrayList of Product
	 * @param last Product name input
	 * @return product ArrayList of Product Objects
	 */
	public ArrayList<Product> searchProduct(String last)
	{

		ArrayList<Product> product = new ArrayList<Product>();

		product = (ArrayList<Product>)pModel.searchProducts(last);

		return product;
	}
	
	/**
	 * Search Sale by Sale primary key. Calls Sale Model and returns ArrayList of Sale object.
	 * @param input Sale Number
	 * @return sale ArrayList of Sale Objects
	 */
	public ArrayList<Sale> searchSale(int input)
	{
		ArrayList<Sale> sale = new ArrayList<Sale>();

		sale = (ArrayList<Sale>)sModel.searchSaleID(input);

		return sale;
	}
	
	/**
	 * Adds Product to Product table. Passes input from GUI to Product Model.
	 * @param des Product description
	 * @param quantity Product quantity
	 * @param category Product category
	 * @param price Product price
	 */
	public void addProduct(String des, int quantity, String category,
			BigDecimal price)
	{

		pModel.addProductToDB(des, quantity, category, price);
	}
	
	/**
	 * Add Order to Order Table
	 * @param items ArrayList of Order items
	 */
	public void addOrder(ArrayList<Order> items) 
	{
		oModel.addOrderToDB(items);
	}

	/**
	 * Add New Customer to Customer table. Passes input from GUI to Customer Model.
	 * @param first Customer First Name
	 * @param last Customer Last Name
	 * @param address Customer Street Address
	 * @param city Customer City
	 * @param state Customer State
	 * @param zip Customer Zip Code
	 * @param phone Customer Phone Number
	 * @param email Customer Email
	 */
	public void addCustomer(String first, String last, String address,
			String city, String state, int zip, String phone, String email)
	{

		cModel.addCustomerToDB(first, last, address, city, state, zip, phone,
				email);
	}
	
	/**
	 * Adds New Sale to Sales table. Passes input from GUI to Sale Model class.
	 * @param customer Customer ID number
	 * @param order Order Number if not null
	 * @param amount Amount payed
	 */
	public void addSale(int customer, Integer order, BigDecimal amount) 
	{
		sModel.addSaleToDB(customer, order, amount);
	}

	/**
	 * Search Customer by their ID number. Calls Customer Model class and passes user input to search. 
	 * Returns Customer ArrayList
	 * @param input Customer ID number
	 * @return customer ArrayList of Customer Object
	 */
	public ArrayList<Customer> searchCustomerID(int input)
	{
		ArrayList<Customer> customer = new ArrayList<Customer>();

		customer = (ArrayList<Customer>)cModel.searchCustomerID(input);

		return customer;
	}

	/**
	 * Search Customer table by Last Name. Calls Customer Model class and passes last name input.
	 * @param input Customer Last name input
	 * @return customer ArrayList of Customers that match input.
	 */
	public ArrayList<Customer> searchCustomerLastName(String input)
	{
		ArrayList<Customer> customer = new ArrayList<Customer>();

		customer = (ArrayList<Customer>)cModel.searchCustomers(input);

		return customer;
	}
}
