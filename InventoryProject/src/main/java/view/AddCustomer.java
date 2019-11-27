package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Control_Main;

/**
 * New Customer Frame. Collects input from user and sends after submit button
 * press to control class to add new Customer.
 * 
 * @author Sigfredo Guzman
 *
 */
public class AddCustomer extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Control_Main control;

	private JTextField fNameInput;
	private JTextField lNameInput;
	private JTextField addressInput;
	private JTextField cityInput;
	private JTextField stateInput;
	private JTextField zipInput;
	private JTextField phoneInput;
	private JTextField emailInput;
	private String fName, lName, address, city, state, phone, email, emercont;
	private int zip;
	private BigDecimal pay;

	/**
	 * Default constructor. Creates Frame and adds action handlers to buttons.
	 */
	public AddCustomer()
	{
		control = new Control_Main();
		// frame = new JFrame("New Employee");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 11, 55, 14);
		getContentPane().add(lblFirstName);

		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 36, 55, 14);
		getContentPane().add(lblLastName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 61, 55, 14);
		getContentPane().add(lblAddress);

		JLabel lblCity = new JLabel("City:");
		lblCity.setBounds(10, 86, 55, 14);
		getContentPane().add(lblCity);

		JLabel lblState = new JLabel("State:");
		lblState.setBounds(10, 111, 55, 14);
		getContentPane().add(lblState);

		JLabel lblZip = new JLabel("Zip:");
		lblZip.setBounds(10, 136, 55, 14);
		getContentPane().add(lblZip);

		JLabel lblPhonenumber = new JLabel("PhoneNumber:");
		lblPhonenumber.setBounds(10, 161, 76, 14);
		getContentPane().add(lblPhonenumber);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 186, 76, 14);
		getContentPane().add(lblEmail);

		fNameInput = new JTextField();
		fNameInput.setBounds(158, 8, 86, 20);
		getContentPane().add(fNameInput);
		fNameInput.setColumns(10);

		lNameInput = new JTextField();
		lNameInput.setColumns(10);
		lNameInput.setBounds(158, 33, 86, 20);
		getContentPane().add(lNameInput);

		addressInput = new JTextField();
		addressInput.setColumns(10);
		addressInput.setBounds(158, 58, 86, 20);
		getContentPane().add(addressInput);

		cityInput = new JTextField();
		cityInput.setColumns(10);
		cityInput.setBounds(158, 83, 86, 20);
		getContentPane().add(cityInput);

		stateInput = new JTextField();
		stateInput.setColumns(10);
		stateInput.setBounds(158, 108, 86, 20);
		getContentPane().add(stateInput);

		zipInput = new JTextField();
		zipInput.setColumns(10);
		zipInput.setBounds(158, 133, 86, 20);
		getContentPane().add(zipInput);

		phoneInput = new JTextField();
		phoneInput.setColumns(10);
		phoneInput.setBounds(158, 158, 86, 20);
		getContentPane().add(phoneInput);

		emailInput = new JTextField();
		emailInput.setColumns(10);
		emailInput.setBounds(158, 183, 86, 20);
		getContentPane().add(emailInput);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				try
				{
					if(fNameInput == null
							|| fNameInput.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,
								"First name must have a value");
					}
					else
					{
						fName = fNameInput.getText().trim();
					}
					if(lNameInput == null
							|| lNameInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Last name must have a value");
					}
					else
					{
						lName = lNameInput.getText().trim();
					}
					if(addressInput == null
							|| addressInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Address must have a value");
					}
					else
					{
						address = addressInput.getText().trim();
					}
					if(cityInput == null
							|| cityInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"City must have a value");
					}
					else
					{
						city = cityInput.getText().trim();
					}
					if(stateInput == null
							|| stateInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"State must have a value");
					}
					else
					{
						state = stateInput.getText().trim();
					}
					if(zipInput == null || zipInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Zip Code must have a value");
					}
					else
					{
						zip = Integer.parseInt(zipInput.getText().trim());
					}
					if(phoneInput == null
							|| phoneInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Phone Number must have a value");
					}
					else
					{
						phone = phoneInput.getText().trim();
					}
					if(emailInput == null
							|| emailInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Email must have a value");
					}
					else
					{
						email = emailInput.getText().trim();
					}

					if(fName != null && lName != null && address != null
							&& city != null && state != null && zip != 0
							&& phone != null && email != null)
					{

						control.addCustomer(fName, lName, address, city, state,
								zip, phone, email);
						fNameInput.setText("");
						lNameInput.setText("");
						addressInput.setText("");
						cityInput.setText("");
						stateInput.setText("");
						zipInput.setText("");
						phoneInput.setText("");
						emailInput.setText("");

					}
				}
				catch(NullPointerException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(61, 284, 89, 23);
		getContentPane().add(btnSubmit);

		JButton btnCancel = new JButton("Clear");
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fNameInput.setText("");
				lNameInput.setText("");
				addressInput.setText("");
				cityInput.setText("");
				stateInput.setText("");
				zipInput.setText("");
				phoneInput.setText("");
				emailInput.setText("");

			}
		});
		btnCancel.setBounds(183, 284, 89, 23);
		getContentPane().add(btnCancel);
	}
}
