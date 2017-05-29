package org.ui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.actions.AboutAction;
import org.actions.LoadFileAction;
import org.model.Customer;
import org.model.Order;
import org.model.Product;

@SuppressWarnings("serial")
public class MainJFrame extends JFrame {

	// frame
	private static JFrame frame;
	// data
	private static List<Customer> customers;
	private static List<Product> products;
	private static List<Order> orders;
	// layout and container
	private JPanel container;
	private static JTabbedPane mainTabPane;
	// component
	private JMenuBar menuBar;
	private JMenu menuFile, menuHelp;
	private JMenuItem menuLoadFile, menuAbout;

	// database
	public MainJFrame() throws HeadlessException {
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Sale Management System  (SMS)");

		this.setContentPane(container);
		MainJFrame.frame = this;
		this.setVisible(true);
	}

	private void init() {
		container = new JPanel();
		container.setLayout(new BorderLayout());

		mainTabPane = new JTabbedPane();
		mainTabPane.add("Product", new ProductPanel());
		mainTabPane.add("Customer", new CustomerPanel());
		mainTabPane.add("Order", new OrderPanel());
		mainTabPane.add("Input file", new InputFilePanel());

		menuBar = new JMenuBar();
		menuBar.add(menuFile = createFileMenu());
		menuBar.add(menuHelp = createHelpMenu());

		this.setJMenuBar(menuBar);
		container.add(mainTabPane, BorderLayout.CENTER);
	}

	private JMenu createHelpMenu() {
		JMenu jMenu = new JMenu("Help");
		menuAbout = new JMenuItem("About");
		menuAbout.addActionListener((x) -> new AboutAction().handle(x));
		jMenu.add(menuAbout);
		return jMenu;
	}

	private JMenu createFileMenu() {
		JMenu jMenu = new JMenu("File");
		menuLoadFile = new JMenuItem("Load File");
		menuLoadFile.addActionListener((x) -> new LoadFileAction().handle(x));
		jMenu.add(menuLoadFile);
		return jMenu;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static JTabbedPane getMainTabPane() {
		return mainTabPane;
	}

	public static List<Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(List<Customer> customers) {
		MainJFrame.customers = customers;
	}

	public static List<Product> getProducts() {
		return products;
	}

	public static void setProducts(List<Product> products) {
		MainJFrame.products = products;
	}

	public static List<Order> getOrders() {
		return orders;
	}

	public static void setOrders(List<Order> orders) {
		MainJFrame.orders = orders;
	}

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			frame = new MainJFrame();
		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
}
