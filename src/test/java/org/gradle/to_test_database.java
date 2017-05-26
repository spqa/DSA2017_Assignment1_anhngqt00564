package org.gradle;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.database.DataAccessJson;
import org.model.Customer;

public class to_test_database {

	public static void main(String[] args) throws Exception {
		try {
			File file = new File("C:\\Users\\super\\Desktop\\dsa2017-data\\1e5\\customers.json");
			DataAccessJson accessJson = new DataAccessJson();
			List<Customer> list = accessJson.readList(file, Customer.class);
			for (Customer customer : list) {
				System.out.println(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
