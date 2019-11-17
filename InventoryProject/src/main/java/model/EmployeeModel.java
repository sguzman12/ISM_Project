package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Employee;
import utilities.HibernateUtilities;

public class EmployeeModel
{
	Transaction transaction = null;
	
	
	public EmployeeModel()
	{
		
	}
	
	

	public void addEmployeeToDB(String first, String last, String address,
			String city, String state, int zip, String phone, String email,
			BigDecimal pay, String contact)
	{
		Employee emp = new Employee(first, last, address, city, state, zip,
				phone, email, pay, contact);

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("Transaction created");

			session.save(emp);

			System.out.println("session saved");
			transaction.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			transaction.rollback();
		}
	}

	public List<Employee> searchEmployees(String last)
	{
		
		try {
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
		Query query = session
				.createQuery("from Employee where last = :lastname ");
		query.setParameter("lastname", last);
		List<Employee> list = query.getResultList();
		
		return list;
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
		return null;
	}
}
