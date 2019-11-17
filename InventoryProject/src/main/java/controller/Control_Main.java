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

public class Control_Main
{
	EmployeeModel eModel;
	CustomerModel cModel;
	ProductModel pModel;
	OrderModel oModel;
	SaleModel sModel;
	Session session;

	public Control_Main()
	{
		eModel = new EmployeeModel();
		cModel = new CustomerModel();
		pModel = new ProductModel();
		oModel = new OrderModel();
		sModel = new SaleModel();
	}

	public Control_Main(Session sess)
	{
		session = sess;
	}

	public void begin() throws Exception
	{
		FX_Gui gui = new FX_Gui();
		gui.initialize();
	}

	public void addEmployee(String first, String last, String address,
			String city, String state, int zip, String phone, String email,
			BigDecimal pay, String contact)
	{

		eModel.addEmployeeToDB(first, last, address, city, state, zip, phone,
				email, pay, contact);
	}

	public ArrayList<Employee> searchEmployee(String last)
	{

		ArrayList<Employee> employee = new ArrayList<Employee>();

		employee = (ArrayList<Employee>)eModel.searchEmployees(last);

		return employee;
	}
	
	public ArrayList<Product> searchProduct(String last)
	{

		ArrayList<Product> product = new ArrayList<Product>();

		product = (ArrayList<Product>)pModel.searchProducts(last);

		return product;
	}
	
	public ArrayList<Sale> searchSale(int input)
	{
		ArrayList<Sale> sale = new ArrayList<Sale>();

		sale = (ArrayList<Sale>)sModel.searchCustomerID(input);

		return sale;
	}
	
	public void addProduct(String des, int quantity, String category,
			BigDecimal price)
	{

		pModel.addProductToDB(des, quantity, category, price);
	}
	
	public void addOrder(ArrayList<Order> items) 
	{
		oModel.addOrderToDB(items);
	}

	public void addCustomer(String first, String last, String address,
			String city, String state, int zip, String phone, String email)
	{

		cModel.addCustomerToDB(first, last, address, city, state, zip, phone,
				email);
	}
	
	public void addSale(int customer, Integer order, BigDecimal amount) 
	{
		sModel.addSaleToDB(customer, order, amount);
	}

	public ArrayList<Customer> searchCustomerID(int input)
	{
		ArrayList<Customer> customer = new ArrayList<Customer>();

		customer = (ArrayList<Customer>)cModel.searchCustomerID(input);

		return customer;
	}

	public ArrayList<Customer> searchCustomerLastName(String input)
	{
		ArrayList<Customer> customer = new ArrayList<Customer>();

		customer = (ArrayList<Customer>)cModel.searchCustomers(input);

		return customer;
	}
}
