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
import org.model.Order;
import org.utils.ArrayUtils;

@SuppressWarnings("serial")
public class OrderPanel extends JPanel {

	// database
	private DataAccessController db;
	private String[] Order_col = { "Pcode", "Ccode", "Quantity" };
	private static List<Order> Order_list;
	private int total_value = 0;
	// component
	private JButton load_btn, sort_btn;
	private JTable Order_table;
	private DefaultTableModel Order_table_model;
	private JLabel total_value_label;
	// layout
	private JPanel top, center;
	private JScrollPane scrollPane;

	// form
	private JTextField ccode_txt, pcode_txt, quantity_txt;

	public OrderPanel() {
		Order_list = new CustomArrayList<>();
		this.db = new DataAccessController();
		init();
		bind();
	}
	
	public static void setOrder_list(List<Order> order_list) {
		Order_list = order_list;
	}

	private void bind() {
		load_btn.addActionListener((x) -> loadAction(x));
		// add_btn.addActionListener((x) -> addAction(x));
		// save_btn.addActionListener((x) -> saveAction(x));
		// del_btn.addActionListener((x) -> delAction(x));
		// search_btn.addActionListener((x) -> seachAction(x));
		sort_btn.addActionListener((x) -> sortAction(x));
	}

	private Object sortAction(ActionEvent x) {
		if (Order_list.isEmpty()) {
			MainJFrame.getMainTabPane().setSelectedIndex(3);
		}
		Order[] temp_array = (Order[]) Order_list.toArray(new Order[Order_list.size()]);
		showOrder(ArrayUtils.reverse(temp_array));
		return null;
	}

	private void loadAction(ActionEvent x) {
		try {
			if (Order_list.isEmpty()) {
				Order_list = db.getAllOrder();
			}
			if (total_value==0) {
				for (Order order : Order_list) {
					total_value+=order.getQuantity();
				}
				
				total_value_label.setText("Total Orders: "+total_value);
			}
			
			// Order[] Orders = new Order[Order_list.size()];
			// for (int i = 0; i < Orders.length; i++) {
			// Orders[i] = Order_list.get(i);
			// }
			showOrder((Order[]) Order_list.toArray(new Order[Order_list.size()]));
		} catch (FileNotFoundException e2) {
			MainJFrame.getMainTabPane().setSelectedIndex(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// private void seachAction(ActionEvent x) {
	// String query = searh_txt.getText().trim();
	// Order temp = new Order(query);
	// System.out.println(temp);
	// int result = Collections.binarySearch(Order_list, temp);
	// if (result >= 0) {
	// showOrder(new Order[] { Order_list.get(result) });
	// } else {
	// JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Not Found");
	// }
	// }

	// private void saveAction(ActionEvent x) {
	// try {
	// db.writeAllOrder(Order_list);
	// JOptionPane.showMessageDialog(this,"Saved");
	// } catch (Exception e) {
	// JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Could not save");
	// e.printStackTrace();
	// }
	// }

	// private Object delAction(ActionEvent x) {
	// String result = JOptionPane.showInputDialog("Enter CCODE:").trim();
	// int index = Collections.binarySearch(Order_list, new Order(result));
	// if (index<0) {
	// JOptionPane.showMessageDialog(MainJFrame.getFrame(), "CCODE not found");
	// }else{
	// Order_list.remove(index);
	// JOptionPane.showMessageDialog(MainJFrame.getFrame(),"Deleted");
	// }
	// return null;
	// }

	// private void addAction(ActionEvent x) {
	// if (Order_list.isEmpty()) {
	// MainJFrame.getMainTabPane().setSelectedIndex(3);
	// return;
	// }
	// ccode_txt=new JTextField();
	// name_txt=new JTextField();
	// phone_txt=new JTextField();
	// JComponent[] Order_input=new JComponent[]{
	// new JLabel("ccode"),ccode_txt,
	// new JLabel("name"),name_txt,
	// new JLabel("phone"),phone_txt
	// };
	// int result = JOptionPane.showConfirmDialog(null, Order_input, "Add new
	// Order", JOptionPane.PLAIN_MESSAGE);
	// if (result == JOptionPane.OK_OPTION) {
	// if (ccode_txt.getText().isEmpty() || name_txt.getText().isEmpty() ||
	// phone_txt.getText().isEmpty()) {
	// JOptionPane.showMessageDialog(MainJFrame.getFrame(), "invalid Input");
	// }else{
	// Order Order=new Order();
	// Order.setCcode(ccode_txt.getText());
	// Order.setPcode(pcode);
	// Order.setQuantity(quantity;
	// Order_list.add(Order);
	// JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Added");
	// }
	// }
	// }

	private void showOrder(Order[] Orders) {
		Order_table_model = new DefaultTableModel(Order_col, 0);
		int total=0;
		for (int i=0;i<Orders.length;i++) {
			String[] rowData = { Orders[i].getPcode(), Orders[i].getCcode(), Orders[i].getQuantity() + "" };
			total+=Orders[i].getQuantity();
			Order_table_model.addRow(rowData);
			
			if (i==Orders.length-1 || Orders[i].getPcode().compareTo(Orders[i+1].getPcode())!=0) {
			Order_table_model.addRow(new String[]{"" ,"" ,"Total : "+total});
			total=0;
			}
		}
		Order_table.setModel(Order_table_model);
	}

	private void init() {
		this.setLayout(new BorderLayout());

		// top
		top = new JPanel();

		load_btn = new JButton("Load Data");
		top.add(load_btn);

		sort_btn = new JButton("Sort");
		top.add(sort_btn);

		total_value_label = new JLabel("Total Order:");
		top.add(total_value_label);
		// add_btn = new JButton("Add new");
		// top.add(add_btn);
		//
		// save_btn = new JButton("Save to file");
		// top.add(save_btn);
		//
		// del_btn = new JButton("Delete by ccode");
		// top.add(del_btn);

		// searh_txt = new JTextField();
		// searh_txt.setPreferredSize(new Dimension(300, 30));
		// top.add(searh_txt);

		// search_btn = new JButton("Search");
		// top.add(search_btn);

		this.add(top, BorderLayout.NORTH);

		// center
		center = new JPanel(new BorderLayout());

		Order_table = new JTable();
		Order_table_model = new DefaultTableModel(Order_col, 10);
		Order_table.setModel(Order_table_model);
		scrollPane = new JScrollPane(Order_table);
		center.add(scrollPane);

		this.add(center, BorderLayout.CENTER);
	}

}
