package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Order;
import utilities.HibernateUtilities;

/**
 * Model class for Orders table inside database.
 * 
 * @author Sigfredo Guzman
 *
 */
public class OrderModel
{
	Transaction transaction = null;

	/**
	 * Add new Order into Orders Table. Parameters passed in are used to create
	 * a new Order Object using the Order class in the dao package. Session
	 * object is created using the Hibernate Utility class which then saves the
	 * new Order object. If catch is thrown then transaction is rolledback.
	 * 
	 * @param item
	 *            ArrayList of Order Objects
	 */
	public void addOrderToDB(ArrayList<Order> item)
	{

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("Transaction created");

			for(Order o : item)
			{
				session.save(o);
			}
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
	 * Search Orders table using Order Last Name. Creates a new session object
	 * and searches using HQL. Results are saved into an ArrayList of Order and
	 * returned.
	 * 
	 * @param input
	 *            Order Number
	 * @return list ArrayList of Order Numbers found with parameter ID.
	 */
	public List<Order> searchOrders(int input)
	{

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			Query query = session.createQuery("from Order where id = :id ");
			query.setParameter("id", input);
			List<Order> list = query.getResultList();

			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
