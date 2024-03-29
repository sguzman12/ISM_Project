package utilities;

import org.hibernate.SessionFactory;

import org.hibernate.boot.Metadata;

import org.hibernate.boot.MetadataSources;

import org.hibernate.boot.registry.StandardServiceRegistry;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Utility class to setup connection.
 * 
 * @author Sigfredo Guzman
 *
 */
public class HibernateUtilities
{

	private static StandardServiceRegistry registry;

	private static SessionFactory sessionFactory;

	/**
	 * Creates Session Factory to connect Hibernate with Database
	 * 
	 * @return sessionFactory Object
	 */
	public static SessionFactory getSessionFactory()
	{

		if(sessionFactory == null)
		{

			try
			{

				// Create registry

				registry = new StandardServiceRegistryBuilder().configure()
						.build();

				// Create MetadataSources

				MetadataSources sources = new MetadataSources(registry);

				// Create Metadata

				Metadata metadata = sources.getMetadataBuilder().build();

				// Create SessionFactory

				sessionFactory = metadata.getSessionFactoryBuilder().build();

			}
			catch(Exception e)
			{

				e.printStackTrace();

				if(registry != null)
				{

					StandardServiceRegistryBuilder.destroy(registry);

				}

			}

		}

		return sessionFactory;

	}

	/**
	 * Shutdown session.
	 */
	public static void shutdown()
	{

		if(registry != null)
		{

			StandardServiceRegistryBuilder.destroy(registry);

		}

	}

}
