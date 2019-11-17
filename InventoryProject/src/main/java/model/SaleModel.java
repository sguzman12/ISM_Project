package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;


import dao.Sale;
import utilities.HibernateUtilities;

public class SaleModel
{
Transaction transaction = null;
	
	
	public SaleModel()
	{
		
	}
	
	

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

	public List<Sale> searchCustomerID(int last)
	{
		
		try {
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
		Query query = session
				.createQuery("from Sale where cstID = :id ");
		query.setParameter("id", last);
		List<Sale> list = query.getResultList();
		
		return list;
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}
}
