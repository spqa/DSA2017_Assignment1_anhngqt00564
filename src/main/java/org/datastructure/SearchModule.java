package org.datastructure;

import java.util.Collections;
import java.util.List;

import org.model.Customer;

public class SearchModule {

	public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T t) {
		
		return indexedBinarySearch(list, t);

	}
	
	
	
	private static <T> int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key)
    {
		
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low + high) /2;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }

	public static void main(String[] args) {
		List<Customer> list = new CustomArrayList<>();
		list.add(new Customer("A"));
		list.add(new Customer("b"));
		list.add(new Customer("c"));
		list.add(new Customer("D"));
		list.add(new Customer("C"));
		list.add(new Customer("G"));
		list.add(new Customer("B"));
		list.add(new Customer("b"));
		list.add(new Customer("d"));
		Collections.sort(list);
		for (Customer customer : list) {
			System.out.println(customer);
		}
		System.out.println(list.size());
		int index = binarySearch(list, new Customer("b"));
		System.out.println(index);
	}
}
