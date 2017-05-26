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
import org.model.Product;
import org.utils.ArrayUtils;

@SuppressWarnings("serial")
public class ProductPanel extends JPanel {

	// database
	private DataAccessController db;
	private String[] Product_col = { "pcode", "Product Name", "Quantity","Saled","Price" };
	private int currentPosition = 0;
	private List<Product> Product_list;
	// component
	private JButton load_btn, add_btn, save_btn, del_btn, search_btn, sort_btn;
	private JTextField searh_txt;
	private JTable Product_table;
	private DefaultTableModel Product_table_model;
	// layout
	private JPanel top, center, bottom;
	private JScrollPane scrollPane;
	
	//form
	private JTextField pcode_txt,name_txt,quantity_txt,saled_txt,price_txt;

	public ProductPanel() {
		Product_list= new CustomArrayList<>();
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
		if (Product_list.isEmpty()) {
			MainJFrame.getMainTabPane().setSelectedIndex(3);
		}
		Product[] temp_array=(Product[]) Product_list.toArray(new Product[Product_list.size()]);
		showProduct(ArrayUtils.reverse(temp_array));
		return null;
	}

	private void loadAction(ActionEvent x) {
		try {
			if (Product_list.isEmpty()) {
				Product_list = db.getAllProduct();	
				System.out.println(Product_list.size());
			}
			// Product[] Products = new Product[Product_list.size()];
			// for (int i = 0; i < Products.length; i++) {
			// Products[i] = Product_list.get(i);
			// }
			showProduct((Product[]) Product_list.toArray(new Product[Product_list.size()]));
		} catch (FileNotFoundException e2) {
			MainJFrame.getMainTabPane().setSelectedIndex(3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void seachAction(ActionEvent x) {
		String query = searh_txt.getText().trim();
		Product temp = new Product(query);
		System.out.println(temp);
		int result = Collections.binarySearch(Product_list, temp);
		if (result >= 0) {
			showProduct(new Product[] { Product_list.get(result) });
		} else {
			JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Not Found");
		}
	}

	private void saveAction(ActionEvent x) {
		try {
			db.writeAllProduct(Product_list);
			JOptionPane.showMessageDialog(this,"Saved");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Could not save");
			e.printStackTrace();
		}
	}

	private Object delAction(ActionEvent x) {
		String result = JOptionPane.showInputDialog("Enter pcode:").trim();
		int index = Collections.binarySearch(Product_list, new Product(result));
		if (index<0) {
			JOptionPane.showMessageDialog(MainJFrame.getFrame(), "pcode not found");
		}else{
			Product_list.remove(index);
			JOptionPane.showMessageDialog(MainJFrame.getFrame(),"Deleted");
		}
		return null;
	}

	private void addAction(ActionEvent x) {
		if (Product_list.isEmpty()) {
			MainJFrame.getMainTabPane().setSelectedIndex(3);
			return;
		}
		pcode_txt=new JTextField();
		name_txt=new JTextField();
		quantity_txt=new JTextField();
		saled_txt=new JTextField();
		price_txt=new JTextField();
		JComponent[] Product_input=new JComponent[]{
				new JLabel("pcode"),pcode_txt,
				new JLabel("name"),name_txt,
				new JLabel("quanity"),quantity_txt,
				new JLabel("saled"),saled_txt,
				new JLabel("price"),price_txt
		};
		int result = JOptionPane.showConfirmDialog(null, Product_input, "Add new Product", JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			if (pcode_txt.getText().isEmpty() || name_txt.getText().isEmpty() || quantity_txt.getText().isEmpty()
					|| saled_txt.getText().isEmpty() || price_txt.getText().isEmpty()) {
				JOptionPane.showMessageDialog(MainJFrame.getFrame(), "invalid Input");
			}else{
				try {
					Product product=new Product();
					product.setPcode(pcode_txt.getText());
					product.setPrice(Double.parseDouble(price_txt.getText()));
					product.setPro_name(name_txt.getText());
					product.setQuantity(Integer.parseInt(quantity_txt.getText()));;
					product.setSale(Integer.parseInt(saled_txt.getText()));;
					Product_list.add(product);
					JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Added");
				}catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Invalid Number Format");
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		} 
	}

	private void showProduct(Product[] Products) {
		Product_table_model = new DefaultTableModel(Product_col, 0);
		for (Product Product : Products) {
			String[] rowData = { Product.getPcode(), Product.getPro_name(), Product.getQuantity()+"",Product.getSale()+"",Product.getPrice()+"" };
			Product_table_model.addRow(rowData);
		}
		Product_table.setModel(Product_table_model);
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

		del_btn = new JButton("Delete by pcode");
		top.add(del_btn);

		searh_txt = new JTextField();
		searh_txt.setPreferredSize(new Dimension(300, 30));
		top.add(searh_txt);

		search_btn = new JButton("Search");
		top.add(search_btn);

		this.add(top, BorderLayout.NORTH);

		// center
		center = new JPanel(new BorderLayout());

		Product_table = new JTable();
		Product_table_model = new DefaultTableModel(Product_col, 2);
		Product_table.setModel(Product_table_model);
		scrollPane = new JScrollPane(Product_table);
		center.add(scrollPane);

		this.add(center, BorderLayout.CENTER);
	}

}
