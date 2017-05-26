package org.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.datastructure.CustomArrayList;
import org.model.Customer;
import org.model.Product;

public class to_test_binary_search {

	public static void main(String[] args) {
		try {
			Product[] products = new Product[5];
//			products[0] = new Product("A", null, null, null, null);
//			products[1] = new Product("C", null, null, null, null);
//			products[2] = new Product("D", null, null, null, null);
//			products[3] = new Product("E", null, null, null, null);
//			products[4] = new Product("G", null, null, null, null);
//			List<Product> list = new CustomArrayList<>();
//			for (int i = 0; i < products.length; i++) {
//				list.add(products[i]);
//			}
//			System.out.println(Collections.binarySearch(list, products[3]));
//			// Arrays.sort(products,(x,y)->x.pcode.compareTo(y.pcode));
//			int index = Arrays.binarySearch(products, new Product("B", null, null, null, null),
//					(x, y) -> x.pcode.compareTo(y.pcode));
//			System.out.println(index);
//			System.out.println(products.length);
			System.out.println(products[0].pcode.compareTo(products[1].pcode));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
