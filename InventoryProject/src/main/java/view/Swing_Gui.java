package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.ScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Control_Main;
import dao.Customer;
import dao.Employee;
import dao.Product;
import dao.Sale;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.Window.Type;

/**
 * Main Frame class. Tabs are used to show different options, (Sales, Orders,
 * Products, Customers, Employees). Search input bar allows user to input search
 * criteria for each. Output is displayed inside JTable. Option to Add new
 * Object for each tab can be found by clicking inside the Add Button.
 * 
 * @author Sigfredo Guzman
 *
 */
public class Swing_Gui extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField saleSearch;
	private JTable saleTable;
	private JTextField orderSearch;
	private JTable orderTable;
	private JTextField productSearch;
	private JTable productTable;
	private JTextField customerSearch;
	private JTable customerTable;
	private JTextField employeeSearch;
	private JTable employeeTable;
	private DefaultTableModel model;

	/**
	 * Default Constructor creates frame and adds action handlers.
	 */
	public Swing_Gui()
	{
		setTitle("Raiders Bakery");
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 935, 471);
		getContentPane().add(tabbedPane);

		JPanel salesTab = new JPanel();
		salesTab.setToolTipText("Sales");
		tabbedPane.addTab("Sales", null, salesTab, null);
		salesTab.setLayout(null);

		JButton btnNewButton = new JButton("New Sale");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				AddSale sale = new AddSale();
				sale.setSize(500, 500);
				sale.setTitle("New Sale Form");
				sale.setVisible(true);
			}
		});
		btnNewButton.setBounds(6, 5, 114, 26);
		salesTab.add(btnNewButton);

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(635, 10, 79, 16);
		salesTab.add(lblSearch);

		saleSearch = new JTextField();
		saleSearch.setBounds(716, 8, 114, 20);

		salesTab.add(saleSearch);
		saleSearch.setColumns(10);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(16, 43, 913, 203);
		salesTab.add(scrollPane_4);

		saleTable = new JTable();
		scrollPane_4.setViewportView(saleTable);
		saleTable.setModel(new DefaultTableModel(
				new Object[][] { { "", "", " ", "", "" },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "Sale", "Customer", "Order ID", "Date",
						"Total" }));

		JButton btnSubmit_3 = new JButton("Submit");
		btnSubmit_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!saleSearch.getText().trim().isEmpty())
				{
					String last = saleSearch.getText().trim();
					int id = Integer.parseInt(last);
					Control_Main control = new Control_Main();

					ArrayList<Sale> list = new ArrayList<Sale>();

					// System.out.println("Before List Returned");
					list = control.searchSale(id);

					// System.out.println("List Returned");

					model = (DefaultTableModel)saleTable.getModel();

					model.setRowCount(0);

					for(Sale ey : list)
					{

						Object[] emp = new Object[5];
						emp[0] = ey.getId();
						emp[1] = ey.getCstID();
						emp[2] = ey.getOrdNum();
						emp[3] = ey.getSaleDate();
						emp[4] = ey.getSaleAmount();

						model.addRow(emp);

					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"Must have a value to search");
				}

			}
		});
		btnSubmit_3.setBounds(845, 4, 90, 28);
		salesTab.add(btnSubmit_3);

		JPanel ordersTab = new JPanel();
		tabbedPane.addTab("Orders", null, ordersTab, null);
		ordersTab.setLayout(null);

		JLabel lblSearch_1 = new JLabel("Search:");
		lblSearch_1.setBounds(625, 11, 68, 16);
		ordersTab.add(lblSearch_1);

		orderSearch = new JTextField();
		orderSearch.setBounds(705, 5, 122, 28);
		ordersTab.add(orderSearch);
		orderSearch.setColumns(10);

		JButton btnNewOrder = new JButton("New Order");
		btnNewOrder.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				AddOrder order = new AddOrder();
				order.setSize(500, 500);
				order.setTitle("New Order Form");
				order.setVisible(true);
			}
		});
		btnNewOrder.setBounds(6, 6, 122, 28);
		ordersTab.add(btnNewOrder);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(16, 42, 913, 393);
		ordersTab.add(scrollPane_3);

		orderTable = new JTable();
		scrollPane_3.setViewportView(orderTable);
		orderTable.setModel(new DefaultTableModel(
				new Object[][] { { "", "", "", " ", "" },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "Order Number", "Customer", "Employee",
						"Date Ordered", "Delivery Date" }));

		JButton btnSubmit_2 = new JButton("Submit");
		btnSubmit_2.setBounds(839, 5, 90, 28);
		ordersTab.add(btnSubmit_2);
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		orderTable.getColumnModel().getColumn(3).setPreferredWidth(85);
		orderTable.getColumnModel().getColumn(4).setPreferredWidth(86);

		JPanel productsTab = new JPanel();
		tabbedPane.addTab("Products", null, productsTab, null);
		productsTab.setLayout(null);

		productSearch = new JTextField();
		productSearch.setBounds(714, 6, 122, 28);
		productsTab.add(productSearch);
		productSearch.setColumns(10);

		JLabel lblSearch_2 = new JLabel("Search:");
		lblSearch_2.setBounds(647, 12, 55, 16);
		productsTab.add(lblSearch_2);

		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				AddProduct item = new AddProduct();
				item.setSize(500, 500);
				item.setTitle("New Product Form");
				item.setVisible(true);
			}
		});
		btnAddProduct.setBounds(6, 6, 132, 28);
		productsTab.add(btnAddProduct);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(16, 46, 913, 389);
		productsTab.add(scrollPane_2);

		productTable = new JTable();
		scrollPane_2.setViewportView(productTable);
		productTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, "", "", "", "" },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null },
						{ null, null, null, null, null }, },
				new String[] { "ID", "Description", "Quantity", "Category",
						"Price" }));

		JButton btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!productSearch.getText().trim().isEmpty())
				{
					String last = productSearch.getText().trim();

					Control_Main control = new Control_Main();

					ArrayList<Product> list = new ArrayList<Product>();

					// System.out.println("Before List Returned");
					list = control.searchProduct(last);

					// System.out.println("List Returned");

					model = (DefaultTableModel)productTable.getModel();

					model.setRowCount(0);

					for(Product ey : list)
					{

						Object[] emp = new Object[5];
						emp[0] = ey.getId();
						emp[1] = ey.getDescription();
						emp[2] = ey.getQuantity();
						emp[3] = ey.getCategory();
						emp[4] = ey.getPrice();

						model.addRow(emp);

					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"Must have a value to search");
				}
			}
		});
		btnSubmit_1.setBounds(839, 6, 90, 28);
		productsTab.add(btnSubmit_1);

		JPanel customersTab = new JPanel();
		tabbedPane.addTab("Customers", null, customersTab, null);
		customersTab.setLayout(null);

		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AddCustomer cus = new AddCustomer();
				cus.setSize(500, 500);
				cus.setTitle("New Customer Form");
				cus.setVisible(true);
			}
		});
		btnAddCustomer.setBounds(0, 6, 135, 28);
		customersTab.add(btnAddCustomer);

		customerSearch = new JTextField();
		customerSearch.setBounds(710, 6, 122, 28);
		customersTab.add(customerSearch);
		customerSearch.setColumns(10);

		JLabel lblSearch_3 = new JLabel("Search:");
		lblSearch_3.setBounds(643, 12, 55, 16);
		customersTab.add(lblSearch_3);

		final JRadioButton rdbtnLastName = new JRadioButton("Last Name");
		rdbtnLastName.setSelected(true);
		rdbtnLastName.setBounds(499, 11, 90, 18);
		customersTab.add(rdbtnLastName);

		final JRadioButton rdbtnId = new JRadioButton("ID");
		rdbtnId.setBounds(588, 11, 43, 18);
		customersTab.add(rdbtnId);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 46, 919, 389);
		customersTab.add(scrollPane_1);

		customerTable = new JTable();
		scrollPane_1.setViewportView(customerTable);
		customerTable.setModel(new DefaultTableModel(new Object[][] {
				{ "", "", "", "", "", "", "", "", "" },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "First", "Last", "Address", "City",
						"State", "Zip", "Phone", "Email" }));

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				if(!customerSearch.getText().trim().isEmpty())
				{
					if(rdbtnId.isSelected())
					{
						String last = customerSearch.getText().trim();
						int input = Integer.parseInt(last);
						Control_Main control = new Control_Main();

						ArrayList<Customer> list = new ArrayList<Customer>();

						// System.out.println("Before List Returned");
						list = control.searchCustomerID(input);

						// System.out.println("List Returned");

						model = (DefaultTableModel)customerTable.getModel();

						model.setRowCount(0);

						for(Customer ey : list)
						{

							Object[] emp = new Object[11];
							emp[0] = ey.getId();
							emp[1] = ey.getFirst();
							emp[2] = ey.getLast();
							emp[3] = ey.getAddress();
							emp[4] = ey.getCity();
							emp[5] = ey.getState();
							emp[6] = ey.getZip();
							emp[7] = ey.getPhone();
							emp[8] = ey.getEmail();

							model.addRow(emp);

						}
					}
					else
					{
						String last = customerSearch.getText().trim();

						Control_Main control = new Control_Main();

						ArrayList<Customer> list = new ArrayList<Customer>();

						// System.out.println("Before List Returned");
						list = control.searchCustomerLastName(last);

						// System.out.println("List Returned");

						model = (DefaultTableModel)customerTable.getModel();

						model.setRowCount(0);

						for(Customer ey : list)
						{

							Object[] emp = new Object[11];
							emp[0] = ey.getId();
							emp[1] = ey.getFirst();
							emp[2] = ey.getLast();
							emp[3] = ey.getAddress();
							emp[4] = ey.getCity();
							emp[5] = ey.getState();
							emp[6] = ey.getZip();
							emp[7] = ey.getPhone();
							emp[8] = ey.getEmail();

							model.addRow(emp);

						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"Must have a value to search");
				}
			}
		});
		btnSubmit.setBounds(839, 6, 90, 28);
		customersTab.add(btnSubmit);

		JPanel EmployeesTab = new JPanel();
		tabbedPane.addTab("Employees", null, EmployeesTab, null);
		EmployeesTab.setLayout(null);

		employeeSearch = new JTextField();
		employeeSearch.setBounds(705, 6, 122, 28);
		EmployeesTab.add(employeeSearch);
		employeeSearch.setColumns(10);

		JLabel lblSearch_4 = new JLabel("Search:");
		lblSearch_4.setBounds(647, 12, 55, 16);
		EmployeesTab.add(lblSearch_4);

		JButton btnNewEmployee = new JButton("New Employee");
		btnNewEmployee.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				AddEmployee emp = new AddEmployee();
				emp.setSize(500, 500);
				emp.setTitle("New Employee Form");
				emp.setVisible(true);
				// emp.run();
			}
		});
		btnNewEmployee.setBounds(0, 6, 122, 28);
		EmployeesTab.add(btnNewEmployee);
		Action actionEmp = new AbstractAction()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
			{

			}
		};
		saleSearch.addActionListener(actionEmp);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 46, 929, 389);
		EmployeesTab.add(scrollPane);
		model = new DefaultTableModel(
				new Object[][] {
						{ "", "", "", "", "", "", "", "", "", "", " " },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null },
						{ null, null, null, null, null, null, null, null, null,
								null, null }, },
				new String[] { "ID", "First", "Last", "Address", "City",
						"State", "Zip", "Phone", "Email", "PayRate",
						"EmerContact" });
		employeeTable = new JTable();
		employeeTable.setModel(model);
		scrollPane.setViewportView(employeeTable);

		employeeTable.getColumnModel().getColumn(0).setPreferredWidth(55);

		JButton btnEmpSearchSubmit = new JButton("Submit");
		btnEmpSearchSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(!employeeSearch.getText().trim().isEmpty())
				{
					String last = employeeSearch.getText().trim();
					Control_Main control = new Control_Main();

					ArrayList<Employee> list = new ArrayList<Employee>();

					// System.out.println("Before List Returned");
					list = control.searchEmployee(last);

					// System.out.println("List Returned");

					model = (DefaultTableModel)employeeTable.getModel();

					model.setRowCount(0);

					for(Employee ey : list)
					{

						Object[] emp = new Object[11];
						emp[0] = ey.getId();
						emp[1] = ey.getFirst();
						emp[2] = ey.getLast();
						emp[3] = ey.getAddress();
						emp[4] = ey.getCity();
						emp[5] = ey.getState();
						emp[6] = ey.getZip();
						emp[7] = ey.getPhone();
						emp[8] = ey.getEmail();
						emp[9] = ey.getPay();
						emp[10] = ey.getContactNum();

						model.addRow(emp);

					}

					// System.out.println("Gone through list");
					// employeeTable.setModel(empModel);
					// displayEmployeeSearch(list, empModel);
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"Must have a value to search");
				}

			}
		});
		btnEmpSearchSubmit.setBounds(839, 6, 90, 28);
		EmployeesTab.add(btnEmpSearchSubmit);
		System.out.println(employeeTable.getModel().toString());

	}
}
