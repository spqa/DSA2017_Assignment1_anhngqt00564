package org.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.datastructure.CustomArrayList;
import org.model.Customer;
import org.model.Order;
import org.model.Product;

public class DataAccessController {
	private static File product_file;
	private static File customer_file;
	private static File order_file;
	private DataAccess dataAccess;

	public DataAccessController() {
		this.dataAccess = new DataAccessJson();
	}

	public static File getProduct_file() {
		return product_file;
	}

	public static void setProduct_file(File product_file) {
		DataAccessController.product_file = product_file;
	}

	public static File getCustomer_file() {
		return customer_file;
	}

	public static void setCustomer_file(File customer_file) {
		DataAccessController.customer_file = customer_file;
	}

	public static File getOrder_file() {
		return order_file;
	}

	public static void setOrder_file(File order_file) {
		DataAccessController.order_file = order_file;
	}

	public List<Customer> getAllCustomer() throws Exception {
		if (customer_file==null) {
			throw new FileNotFoundException();
		}
		
		return new CustomArrayList<Customer>(dataAccess.readList(customer_file,Customer.class));
	}
	
	public List<Product> getAllProduct() throws Exception {
		if (product_file==null) {
			throw new FileNotFoundException();
		}
		
		return new CustomArrayList<Product>(dataAccess.readList(product_file,Product.class));
	}
	
	public List<Order> getAllOrder() throws Exception {
		if (order_file==null) {
			throw new FileNotFoundException();
		}
		
		return new CustomArrayList<Order>(dataAccess.readList(order_file,Order.class));
	}
	
	public void writeAllCustomer(List<Customer> list) throws Exception{
		if (customer_file==null) {
			throw new FileNotFoundException();
		}
		
		dataAccess.writeList(list, customer_file);
	}
	
	public void writeAllProduct(List<Product> list) throws Exception{
		if (product_file==null) {
			throw new FileNotFoundException();
		}
		
		dataAccess.writeList(list, product_file);
	}
	
	public void writeAllOrder(List<Order> list) throws Exception{
		if (order_file==null) {
			throw new FileNotFoundException();
		}
		
		dataAccess.writeList(list, order_file);
	}

}
