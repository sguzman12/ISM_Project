package model;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Employee;
import utilities.HibernateUtilities;

/**
 * Model class for Employee table inside database.
 * 
 * @author Sigfredo Guzman
 *
 */
public class EmployeeModel
{
	Transaction transaction = null;

	/**
	 * Default Constructor
	 */
	public EmployeeModel()
	{

	}

	/**
	 * Add new Employee into Employees Table. Parameters passed in are used to
	 * create a new Employee Object using the Employee class in the dao package.
	 * Session object is created using the Hibernate Utility class which then
	 * saves the new Employee object. If catch is thrown then transaction is
	 * rolledback.
	 * 
	 * @param first
	 *            Employee First Name
	 * @param last
	 *            Employee Last Name
	 * @param address
	 *            Employee Street Address
	 * @param city
	 *            Employee City
	 * @param state
	 *            Employee State
	 * @param zip
	 *            Employee Zip Code
	 * @param phone
	 *            Employee Phone Number
	 * @param email
	 *            Employee Email
	 * @param pay
	 *            Employee Pay Rate
	 * @param contact
	 *            Employee Emergency Contact Number
	 */
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

	/**
	 * Search Employees table using Employee Last Name. Creates a new session
	 * object and searches using HQL. Results are saved into an ArrayList of
	 * Employee and returned.
	 * 
	 * @param last
	 *            Employee Last Name
	 * @return list Employee ArrayList of found Employees with last name.
	 */
	public List<Employee> searchEmployees(String last)
	{

		try
		{
			Session session = HibernateUtilities.getSessionFactory()
					.openSession();
			Query query = session
					.createQuery("from Employee where last = :lastname ");
			query.setParameter("lastname", last);
			List<Employee> list = query.getResultList();

			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}
