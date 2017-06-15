package org.assignment2;

import java.util.Arrays;

import org.omg.CORBA.Current;

public class to_test_string_sort_algorithm {

	public static void main(String[] args) {
		String[] a = { "158", "124", "238", 
				"707", "608", "250", "888" };
		sort(a, 3);
	}
	
	public static void sort(String[] a, int w) {
		int n = a.length;
		int R = 256; // extend ASCII alphabet size
		String[] aux = new String[n];

		for (int d = w - 1; d >= 0; d--) {
			// sort by key-indexed counting on dth character

			// compute frequency counts
			int[] count = new int[R + 1];
			for (int i = 0; i < n; i++)
				count[a[i].charAt(d) + 1]++;

			// compute cumulates
			for (int r = 0; r < R; r++)
				count[r + 1] += count[r];

			// move data
			for (int i = 0; i < n; i++)
				aux[count[a[i].charAt(d)]++] = a[i];

			// copy back
			for (int i = 0; i < n; i++) {
				a[i] = aux[i];
			}
			System.out.println("current d: "+d  );
			System.out.println(Arrays.asList(a));

		}
	}

}

	
