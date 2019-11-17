package model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Product;
import utilities.HibernateUtilities;

public class ProductModel
{
	Transaction transaction = null;

	// "Description", "Quantity", "Category", "Price"
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
