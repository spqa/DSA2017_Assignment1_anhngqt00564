package org.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.database.DataAccessController;
import org.datastructure.CustomArrayList;
import org.model.Customer;
import org.utils.ArrayUtils;

@SuppressWarnings("serial")
public class CustomerPanel extends JPanel {

	// database
	private DataAccessController db;
	private String[] customer_col = { "ccode", "Customer Name", "Phone" };
	private int currentPosition = 0;
	private List<Customer> customer_list;
	// component
	private JButton load_btn, add_btn, save_btn, del_btn, search_btn, sort_btn;
	private JTextField searh_txt;
	private JTable customer_table;
	private DefaultTableModel customer_table_model;
	// layout
	private JPanel top, center, bottom;
	private JScrollPane scrollPane;
	
	//form
	private JTextField ccode_txt,name_txt,phone_txt;

	public CustomerPanel() {
		customer_list= new CustomArrayList<>();
		this.db = new DataAccessController();
		init();
		bind();
	}

	private void bind() {
		load_btn.addActionListener((x) -> loadAction(x));
		add_btn.addActionListener((x) -> addAction(x));
		save_btn.addActionListener((x) -> saveAction(x));
		del_btn.addActionListener((x) -> delAction(x));
		search_btn.addActionListener((x) -> seachAction(x));
		sort_btn.addActionListener((x) -> sortAction(x));
	}

	private Object sortAction(ActionEvent x) {
		if (customer_list.isEmpty()) {
			MainJFrame.getMainTabPane().setSelectedIndex(3);
		}
		Customer[] temp_array=(Customer[]) customer_list.toArray(new Customer[customer_list.size()]);
		showCustomer(ArrayUtils.reverse(temp_array));
		return null;
	}

	private void loadAction(ActionEvent x) {
		try {
			if (customer_list.isEmpty()) {
				customer_list = db.getAllCustomer();	
			}
			// Customer[] customers = new Customer[customer_list.size()];
			// for (int i = 0; i < customers.length; i++) {
			// customers[i] = customer_list.get(i);
			// }
			showCustomer((Customer[]) customer_list.toArray(new Customer[customer_list.size()]));
		} catch (FileNotFoundException e2) {
			MainJFrame.getMainTabPane().setSelectedIndex(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void seachAction(ActionEvent x) {
		String query = searh_txt.getText().trim();
		Customer temp = new Customer(query);
		System.out.println(temp);
		int result = Collections.binarySearch(customer_list, temp);
		if (result >= 0) {
			showCustomer(new Customer[] { customer_list.get(result) });
		} else {
			JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Not Found");
		}
	}

	private void saveAction(ActionEvent x) {
		try {
			db.writeAllCustomer(customer_list);
			JOptionPane.showMessageDialog(this,"Saved");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Could not save");
			e.printStackTrace();
		}
	}

	private Object delAction(ActionEvent x) {
		String result = JOptionPane.showInputDialog("Enter CCODE:").trim();
		int index = Collections.binarySearch(customer_list, new Customer(result));
		if (index<0) {
			JOptionPane.showMessageDialog(MainJFrame.getFrame(), "CCODE not found");
		}else{
			customer_list.remove(index);
			JOptionPane.showMessageDialog(MainJFrame.getFrame(),"Deleted");
		}
		return null;
	}

	private void addAction(ActionEvent x) {
		if (customer_list.isEmpty()) {
			MainJFrame.getMainTabPane().setSelectedIndex(3);
			return;
		}
		ccode_txt=new JTextField();
		name_txt=new JTextField();
		phone_txt=new JTextField();
		JComponent[] customer_input=new JComponent[]{
				new JLabel("ccode"),ccode_txt,
				new JLabel("name"),name_txt,
				new JLabel("phone"),phone_txt
		};
		int result = JOptionPane.showConfirmDialog(null, customer_input, "Add new Customer", JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			if (ccode_txt.getText().isEmpty() || name_txt.getText().isEmpty() || phone_txt.getText().isEmpty()) {
				JOptionPane.showMessageDialog(MainJFrame.getFrame(), "invalid Input");
			}else{
				Customer customer=new Customer(ccode_txt.getText(),name_txt.getText(),phone_txt.getText());
				customer_list.add(customer);
				JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Added");
			}
		} 
	}

	private void showCustomer(Customer[] customers) {
		customer_table_model = new DefaultTableModel(customer_col, 0);
		for (Customer customer : customers) {
			String[] rowData = { customer.getCcode(), customer.getCus_name(), customer.getPhone() };
			customer_table_model.addRow(rowData);
		}
		customer_table.setModel(customer_table_model);
	}

	private void init() {
		this.setLayout(new BorderLayout());

		// top
		top = new JPanel();

		load_btn = new JButton("Load Data");
		top.add(load_btn);

		sort_btn = new JButton("Sort");
		top.add(sort_btn);

		add_btn = new JButton("Add new");
		top.add(add_btn);

		save_btn = new JButton("Save to file");
		top.add(save_btn);

		del_btn = new JButton("Delete by ccode");
		top.add(del_btn);

		searh_txt = new JTextField();
		searh_txt.setPreferredSize(new Dimension(300, 30));
		top.add(searh_txt);

		search_btn = new JButton("Search");
		top.add(search_btn);

		this.add(top, BorderLayout.NORTH);

		// center
		center = new JPanel(new BorderLayout());

		customer_table = new JTable();
		customer_table_model = new DefaultTableModel(customer_col, 2);
		customer_table.setModel(customer_table_model);
		scrollPane = new JScrollPane(customer_table);
		center.add(scrollPane);

		this.add(center, BorderLayout.CENTER);
	}

}
