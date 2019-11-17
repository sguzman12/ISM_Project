package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Order;
import utilities.HibernateUtilities;

public class OrderModel
{
	Transaction transaction = null;

	public void addOrderToDB(ArrayList<Order> item)
	{

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("Transaction created");
			
			for(Order o: item) 
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
