package model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Customer;
import dao.Employee;
import utilities.HibernateUtilities;

/**
 * Model class for Customer table inside database.
 * 
 * @author Sigfredo Guzman
 *
 */
public class CustomerModel
{
	Transaction transaction = null;

	/**
	 * Add new Customer into Customers Table. Parameters passed in are used to
	 * create a new Customer Object using the Customer class in the dao package.
	 * Session object is created using the Hibernate Utility class which then
	 * saves the new customer object. If catch is thrown then transaction is
	 * rolledback.
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
	public void addCustomerToDB(String first, String last, String address,
			String city, String state, int zip, String phone, String email)
	{
		Customer cus = new Customer(first, last, address, city, state, zip,
				phone, email);

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("Transaction created");

			session.save(cus);

			System.out.println("session saved");
			transaction.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			transaction.rollback();
		}
	}

	/**
	 * Search Customers table using Customer Last Name. Creates a new session
	 * object and searches using HQL. Results are saved into an ArrayList of
	 * Customer and returned.
	 * 
	 * @param last
	 *            Customer Last Name
	 * @return list Customer ArrayList of found Customers with last name.
	 */
	public List<Customer> searchCustomers(String last)
	{

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			Query query = session
					.createQuery("from Customer where last = :lastname ");
			query.setParameter("lastname", last);
			List<Customer> list = query.getResultList();

			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Search Customers table using Customer ID. Creates a new session object
	 * and searches using HQL. Results are saved into an ArrayList of Customer
	 * and returned.
	 * 
	 * @param input
	 *            Customer ID
	 * @return list Customer ArrayList of found Customers with last name.
	 */
	public List<Customer> searchCustomerID(int input)
	{

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			Query query = session.createQuery("from Customer where id = :id ");
			query.setParameter("id", input);
			List<Customer> list = query.getResultList();

			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
