package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.Control_Main;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class AddSale extends JFrame
{
	private JTextField customerInput;
	private JTextField orderInput;
	private JTextField saleInput;
	private int customer;
	private Integer order = 0;
	private BigDecimal sale;
	private Control_Main control;
	
	public AddSale() 
	{
		control = new Control_Main();
		getContentPane().setLayout(null);
		
		JLabel lblCustomerid = new JLabel("CustomerID:");
		lblCustomerid.setBounds(10, 11, 77, 14);
		getContentPane().add(lblCustomerid);
		
		JLabel lblOrder = new JLabel("Order:");
		lblOrder.setBounds(10, 36, 46, 14);
		getContentPane().add(lblOrder);
		
		JLabel lblSaleAmount = new JLabel("Sale Amount:");
		lblSaleAmount.setBounds(10, 71, 77, 14);
		getContentPane().add(lblSaleAmount);
		
		customerInput = new JTextField();
		customerInput.setBounds(82, 8, 86, 20);
		getContentPane().add(customerInput);
		customerInput.setColumns(10);
		
		orderInput = new JTextField();
		orderInput.setBounds(82, 36, 86, 20);
		getContentPane().add(orderInput);
		orderInput.setColumns(10);
		
		saleInput = new JTextField();
		saleInput.setBounds(82, 68, 86, 20);
		getContentPane().add(saleInput);
		saleInput.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(customerInput == null
							|| customerInput.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,
								"Customer ID must have a value");
					}
					else
					{
						customer = Integer.parseInt(customerInput.getText().trim());
					}
					if(!orderInput.getText().trim().isEmpty()) 
					{
						order = Integer.parseInt(orderInput.getText().trim());
					}
					if(saleInput == null
							|| saleInput.getText().trim().equals(""))
					{

						JOptionPane.showMessageDialog(null,
								"Sale Amount must have a value");
					}
					else
					{
						sale = new BigDecimal(saleInput.getText());
					}
					
					
					
					if(sale != null && customer !=0)
					{
						control.addSale(customer, order, sale );
						customerInput.setText("");
						orderInput.setText("");
						saleInput.setText("");
												
					}
				}
				catch(NullPointerException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(10, 151, 89, 23);
		getContentPane().add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerInput.setText("");
				orderInput.setText("");
				saleInput.setText("");
			}
		});
		btnClear.setBounds(126, 151, 89, 23);
		getContentPane().add(btnClear);
	}
}
