package controller;

import javafx.stage.*;
import utilities.HibernateUtilities;
import view.FX_Gui;
import view.Swing_Gui;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.Customer;
import javafx.application.*;

//Author: Sigfredo Guzman
//Date: 9/11/2019

/**
 * 
 * @author Sigfredo Guzman
 * Main Class. Begins Program by setting up Swing GUI.
 */
public class ISM_Main extends Application
{

	public static void main(String[] args)
	{
		Transaction transaction = null;
		
		
		try
		{
			
			
			/*
			System.out.println("Made it to try");
			
			// start a transaction
			transaction = session.beginTransaction();
			System.out.println("Transaction created");
			
			session.save(cust1);
			session.save(cust2);
			
			System.out.println("session saved");
			transaction.commit();
			System.out.println("transaction committed");
			*/
			
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				
				public void run() 
				{
					Swing_Gui gui = new Swing_Gui();
					gui.setSize(954, 516);
					
					gui.setLocationRelativeTo(null);
					gui.setVisible(true);
				}
			});
		}
		catch(Exception e)
		{
			transaction.rollback();
		}
		
		

		//launch(args);

	}

	/**
	 * JavaFX. Not currently used.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Control_Main con = new Control_Main();
		con.begin();
	}

}
