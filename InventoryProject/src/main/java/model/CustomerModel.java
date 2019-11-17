package model;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Customer;
import dao.Employee;
import utilities.HibernateUtilities;

public class CustomerModel
{
	Transaction transaction = null;

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
