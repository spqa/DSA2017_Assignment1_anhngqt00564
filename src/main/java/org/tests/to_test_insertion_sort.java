package org.tests;

import org.datastructure.SortModule;
import org.model.Customer;

public class to_test_insertion_sort {

	public static void main(String[] args) {
		try {
			Customer[] customers=new Customer[6];
			customers[0]=new Customer("A");
			customers[1]=new Customer("D");
			customers[2]=new Customer("C");
			customers[3]=new Customer("I");
			customers[4]=new Customer("B");
			customers[5]=new Customer("H");
//			customers[6]=new Customer("G");
			SortModule.insertionSort(customers);
			for (Customer customer : customers) {
				System.out.println(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
