package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Control_Main;
import dao.Order;

import javax.swing.JTextArea;

/**
 * New Order Frame. Collects input from user and sends after submit button press
 * to control class to add new Order.
 * 
 * @author Sigfredo Guzman
 *
 */
public class AddOrder extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Control_Main control;

	private JTextField descriptionInput;
	private JTextField quantityInput;
	private ArrayList<Order> orderList;
	private int item, itemQuantity;
	private int customer, employee;
	private JTextField customerInput;
	private JTextField employeeInput;

	/**
	 * Default Constructor creates frame and connects action handlers to
	 * buttons.
	 */
	public AddOrder()
	{
		orderList = new ArrayList<Order>();
		control = new Control_Main();
		// frame = new JFrame("New Employee");
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblItem = new JLabel("ProductID:");
		lblItem.setBounds(10, 11, 86, 14);
		getContentPane().add(lblItem);

		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(10, 36, 55, 14);
		getContentPane().add(lblQuantity);

		descriptionInput = new JTextField();
		descriptionInput.setBounds(90, 8, 86, 20);
		getContentPane().add(descriptionInput);
		descriptionInput.setColumns(10);

		quantityInput = new JTextField();
		quantityInput.setColumns(10);
		quantityInput.setBounds(90, 33, 86, 20);
		getContentPane().add(quantityInput);

		final JTextArea txtAreaOrder = new JTextArea();
		txtAreaOrder.setColumns(2);
		txtAreaOrder.setBounds(10, 110, 414, 124);
		getContentPane().add(txtAreaOrder);

		JButton btnSubmit = new JButton("Add Item");
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
								"Product ordered must have a value");
					}
					else
					{
						item = Integer
								.parseInt(descriptionInput.getText().trim());
					}
					if(quantityInput == null
							|| quantityInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Must have a value");
					}
					else
					{
						itemQuantity = Integer
								.parseInt(quantityInput.getText().trim());
					}
					if(customerInput == null
							|| customerInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Must have a value");
					}
					else
					{
						customer = Integer
								.parseInt(customerInput.getText().trim());
					}
					if(employeeInput == null
							|| employeeInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Must have a value");
					}
					else
					{
						employee = Integer
								.parseInt(employeeInput.getText().trim());
					}

					if(item != 0 && itemQuantity != 0 && employee != 0
							&& customer != 0)
					{
						DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
						Date dateobj1 = new Date();

						Date dateobj2 = new Date();

						txtAreaOrder.append(item + "   " + itemQuantity + "\n");
						Order orderItem = new Order(customer, employee,
								dateobj1, dateobj2);
						orderList.add(orderItem);

					}
				}
				catch(NullPointerException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(59, 263, 89, 23);
		getContentPane().add(btnSubmit);

		JButton btnCancel = new JButton("Clear");
		btnCancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				descriptionInput.setText("");
				quantityInput.setText("");
				customerInput.setText("");
				employeeInput.setText("");
				txtAreaOrder.setText("");
			}
		});
		btnCancel.setBounds(158, 263, 89, 23);
		getContentPane().add(btnCancel);

		JButton btnCreateOrder = new JButton("Create Order");
		btnCreateOrder.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				if(!orderList.isEmpty())
				{
					control.addOrder(orderList);
				}

			}
		});
		btnCreateOrder.setBounds(306, 263, 118, 23);
		getContentPane().add(btnCreateOrder);

		JLabel lblCustomer = new JLabel("Customer:");
		lblCustomer.setBounds(10, 67, 70, 14);
		getContentPane().add(lblCustomer);

		customerInput = new JTextField();
		customerInput.setBounds(90, 64, 86, 20);
		getContentPane().add(customerInput);
		customerInput.setColumns(10);

		JLabel lblEmployee = new JLabel("Employee:");
		lblEmployee.setBounds(197, 11, 70, 14);
		getContentPane().add(lblEmployee);

		employeeInput = new JTextField();
		employeeInput.setBounds(293, 8, 86, 20);
		getContentPane().add(employeeInput);
		employeeInput.setColumns(10);
	}
}
