package org.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.database.DataAccessController;

public class InputFilePanel extends JPanel {

	private JLabel customer_lbl, product_lbl, order_lbl;
	private JTextField customer_txt, product_txt, order_txt;
	private JButton customer_btn, product_btn, order_btn, save_btn;
	private File customer_file, product_file, order_file;

	public InputFilePanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		init();
		bind();
	}

	private void init() {
		Dimension txtSize = new Dimension(300, 30);
		Dimension fieldWrapper = new Dimension(800, 60);

		// customer
		customer_lbl = new JLabel("Customer File:");
		customer_txt = new JTextField();
		customer_txt.setPreferredSize(txtSize);
		customer_btn = new JButton("Load File");
		customer_btn.setName("customer_btn");

		JPanel customer_pnl = new JPanel();
		customer_pnl.setPreferredSize(fieldWrapper);
		customer_pnl.add(customer_lbl);
		customer_pnl.add(customer_txt);
		customer_pnl.add(customer_btn);
		this.add(customer_pnl);

		// product
		product_lbl = new JLabel("Product File:  ");
		product_txt = new JTextField();
		product_txt.setPreferredSize(txtSize);
		product_btn = new JButton("Load File");
		product_btn.setName("product_btn");

		JPanel product_pnl = new JPanel();
		product_pnl.setPreferredSize(fieldWrapper);
		product_pnl.add(product_lbl);
		product_pnl.add(product_txt);
		product_pnl.add(product_btn);
		this.add(product_pnl);

		// order field
		order_lbl = new JLabel("Order File:      ");
		order_txt = new JTextField();
		order_txt.setPreferredSize(txtSize);
		order_btn = new JButton("Load File");
		order_btn.setName("order_btn");

		JPanel order_pnl = new JPanel();
		order_pnl.setPreferredSize(fieldWrapper);
		order_pnl.add(order_lbl);
		order_pnl.add(order_txt);
		order_pnl.add(order_btn);
		this.add(order_pnl);

		// save button
		save_btn = new JButton("Save");
		JPanel save_pnl = new JPanel();
		save_pnl.setPreferredSize(fieldWrapper);
		save_pnl.add(save_btn);
		this.add(save_pnl);
	}

	public void bind() {
		customer_btn.addActionListener((x) -> loadFile(x));
		product_btn.addActionListener((x) -> loadFile(x));
		order_btn.addActionListener((x) -> loadFile(x));
		save_btn.addActionListener((x)->saveFile(x));
	}

	private void saveFile(ActionEvent x) {
		DataAccessController.setCustomer_file(customer_file);
		DataAccessController.setOrder_file(order_file);
		DataAccessController.setProduct_file(product_file);
		JOptionPane.showMessageDialog(MainJFrame.getFrame(), "Config Saved !!");
	}

	private void loadFile(ActionEvent e) {
		System.out.println(((JButton) e.getSource()).getName());
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(MainJFrame.getFrame());
		switch (((JButton) e.getSource()).getName()) {
		case "product_btn":
			product_file = fileChooser.getSelectedFile();
			product_txt.setText(product_file != null ? product_file.getPath() : "");
			break;
		case "customer_btn":
			customer_file = fileChooser.getSelectedFile();
			customer_txt.setText(customer_file != null ? customer_file.getPath() : "");
			break;
		case "order_btn":
			order_file = fileChooser.getSelectedFile();
			order_txt.setText(order_file != null ? order_file.getPath() : "");
			break;

		default:
			break;
		}
		

	}
}
