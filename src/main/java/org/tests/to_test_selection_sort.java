package org.tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.datastructure.CustomArrayList;
import org.datastructure.SortModule;
import org.model.Customer;

public class to_test_selection_sort {
	public static void main(String[] args) {

		try {
			ArrayList<Customer> customArrayList=new ArrayList<>();
			customArrayList.add(new Customer("A"));
			customArrayList.add(new Customer("C"));
			customArrayList.add(new Customer("B"));
			customArrayList.add(new Customer("F"));
			customArrayList.add(new Customer("D"));
			customArrayList.add(new Customer("I"));
			customArrayList.add(new Customer("H"));
			
			SortModule.selectionSort(customArrayList);
			for (Customer customer : customArrayList) {
				System.out.println(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
