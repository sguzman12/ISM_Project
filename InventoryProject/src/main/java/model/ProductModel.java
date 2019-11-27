package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Product;
import utilities.HibernateUtilities;

/**
 * Model class for Product table inside database.
 * 
 * @author Sigfredo Guzman
 *
 */
public class ProductModel
{
	Transaction transaction = null;

	/**
	 * Add new Products into Products Table. Parameters passed in are used to
	 * create a new Products Object using the Products class in the dao package.
	 * Session object is created using the Hibernate Utility class which then
	 * saves the new product object. If catch is thrown then transaction is
	 * rolledback.
	 * 
	 * @param description
	 *            Product Name
	 * @param quantity
	 *            Product Quantity
	 * @param category
	 *            Product Category
	 * @param price
	 *            Product Price
	 */
	public void addProductToDB(String description, int quantity,
			String category, BigDecimal price)
	{
		Product item = new Product(description, quantity, category, price);

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("Transaction created");

			session.save(item);

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
	 * Search Product table using Product Last Name. Creates a new session
	 * object and searches using HQL. Results are saved into an ArrayList of
	 * Product and returned.
	 * 
	 * @param input
	 *            Product Name
	 * @return list Product ArrayList matching Input.
	 */
	public List<Product> searchProducts(String input)
	{

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			Query query = session
					.createQuery("from Product where description LIKE :des ");

			query.setParameter("des", "%" + input + "%");
			List<Product> list = query.getResultList();

			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
