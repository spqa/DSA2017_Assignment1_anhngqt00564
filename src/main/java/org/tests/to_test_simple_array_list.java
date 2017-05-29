package org.tests;

import java.util.Collections;
import java.util.Iterator;

import org.datastructure.ArrayList;
import org.datastructure.CustomArrayList;
import org.datastructure.SimpleArrayList;
import org.model.Customer;

public class to_test_simple_array_list {

	public static void main(String[] args) {
		try {
			ArrayList<Customer> simpleArrayList=new ArrayList<>();
			simpleArrayList.add(new Customer("A"));
			simpleArrayList.add(new Customer("C"));
			simpleArrayList.add(new Customer("D"));
			simpleArrayList.add(new Customer("S"));
			simpleArrayList.add(new Customer("F"));
			simpleArrayList.add(new Customer("B"));
			CustomArrayList<Customer> list=new CustomArrayList<>(simpleArrayList);
			for (Customer customer : list) {
				System.out.println(customer);
			}
			Collections.sort(simpleArrayList);
			System.out.println(simpleArrayList.size());
			simpleArrayList.add(2, new Customer("G"));
			System.out.println(simpleArrayList.size());
			for (Customer customer : simpleArrayList) {
				System.out.println(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
