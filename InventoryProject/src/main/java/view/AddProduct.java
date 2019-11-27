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
 * New Product Frame. Collects input from user and sends after submit button
 * press to control class to add new Product.
 * 
 * @author Sigfredo Guzman
 *
 */
public class AddProduct extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Control_Main control;

	private JTextField descriptionInput;
	private JTextField quantityInput;
	private JTextField categoryInput;
	private JTextField priceInput;
	private String description, category;
	private int quantity;
	private BigDecimal price;

	/**
	 * Default Constructor creates frame and connects action handlers to
	 * buttons.
	 */
	public AddProduct()
	{
		control = new Control_Main();
		// frame = new JFrame("New Employee");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(10, 11, 55, 14);
		getContentPane().add(lblDescription);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(10, 36, 55, 14);
		getContentPane().add(lblQuantity);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(10, 61, 55, 14);
		getContentPane().add(lblCategory);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 86, 55, 14);
		getContentPane().add(lblPrice);

		descriptionInput = new JTextField();
		descriptionInput.setBounds(158, 8, 86, 20);
		getContentPane().add(descriptionInput);
		descriptionInput.setColumns(10);

		quantityInput = new JTextField();
		quantityInput.setColumns(10);
		quantityInput.setBounds(158, 33, 86, 20);
		getContentPane().add(quantityInput);

		categoryInput = new JTextField();
		categoryInput.setColumns(10);
		categoryInput.setBounds(158, 58, 86, 20);
		getContentPane().add(categoryInput);

		priceInput = new JTextField();
		priceInput.setColumns(10);
		priceInput.setBounds(158, 83, 86, 20);
		getContentPane().add(priceInput);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				try
				{
					if(descriptionInput == null
							|| descriptionInput.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,
								"First name must have a value");
					}
					else
					{
						description = descriptionInput.getText().trim();
					}
					if(quantityInput == null
							|| quantityInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Last name must have a value");
					}
					else
					{
						quantity = Integer
								.parseInt(quantityInput.getText().trim());
					}
					if(categoryInput == null
							|| categoryInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Address must have a value");
					}
					else
					{
						category = categoryInput.getText().trim();
					}
					if(priceInput == null
							|| priceInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Pay Rate must have a value");
					}
					else
					{

						price = new BigDecimal(priceInput.getText());

					}

					if(description != null && quantity != 0 && category != null
							&& price != null)
					{
						control.addProduct(description, quantity, category,
								price);
						descriptionInput.setText("");
						quantityInput.setText("");
						categoryInput.setText("");
						priceInput.setText("");

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
				descriptionInput.setText("");
				quantityInput.setText("");
				categoryInput.setText("");
				priceInput.setText("");
			}
		});
		btnCancel.setBounds(183, 284, 89, 23);
		getContentPane().add(btnCancel);
	}

}
