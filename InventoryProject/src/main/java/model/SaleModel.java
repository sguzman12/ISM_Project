package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Sale;
import utilities.HibernateUtilities;

/**
 * Model class for Sale table inside database.
 * 
 * @author Sigfredo Guzman
 *
 */
public class SaleModel
{
	Transaction transaction = null;

	/**
	 * Default Constructor
	 */
	public SaleModel()
	{

	}

	/**
	 * Add new Sale into Sale Table. Parameters passed in are used to create a
	 * new Sale Object using the Sale class in the dao package. Session object
	 * is created using the Hibernate Utility class which then saves the new
	 * Sale object. If catch is thrown then transaction is rolledback.
	 * 
	 * @param customer
	 *            Customer ID
	 * @param order
	 *            Order Number IF NOT NULL
	 * @param amount
	 *            Sale Amount
	 */
	public void addSaleToDB(int customer, Integer order, BigDecimal amount)
	{
		Date dateSold = new Date();

		Sale sale = new Sale(customer, order, dateSold, amount);

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("Transaction created");

			session.save(sale);

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
	 * Search Sale table using Sale Last Name. Creates a new session object and
	 * searches using HQL. Results are saved into an ArrayList of Sale and
	 * returned.
	 * 
	 * @param id
	 *            Customer ID
	 * @return list ArrayList of Sale items matching customer ID
	 */
	public List<Sale> searchSaleID(int id)
	{

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			Query query = session.createQuery("from Sale where cstID = :id ");
			query.setParameter("id", id);
			List<Sale> list = query.getResultList();

			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
