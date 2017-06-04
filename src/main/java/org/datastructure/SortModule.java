package org.datastructure;

import java.util.List;

public class SortModule {
	public static <E extends Comparable<E>> void selectionSort(List<E> e) {
		if (e.size() == 0) {
			return;
		}

		for (int i = 0; i < e.size(); i++) {
			int minIndex = i;
			for (int j = i + 1; j < e.size(); j++) {
				if (e.get(minIndex).compareTo(e.get(j)) > 0) {
					minIndex = j;
				}
			}

			if (i != minIndex) {
				E tempObject = e.get(i);
				e.set(i, e.get(minIndex));
				e.set(minIndex, tempObject);
			}
		}
	}

	public static <E extends Comparable<E>> void insertionSort(E[] objects) {
		if (objects.length < 2) {
			return;
		}
		for (int i = 1; i < objects.length; i++) {
			int j = i - 1;
			E temp = objects[i];
			while (j >= 0 && temp.compareTo(objects[j]) < 0) {
				objects[j + 1] = objects[j];
				j--;
			}

			objects[j + 1] = temp;
		}

	}

	public static <E> void bubbleSort(List<E> e) {

	}

	public static <E> void mergeSort(List<E> e) {

	}

	@SuppressWarnings("unchecked")
	public static <E extends Comparable<? super E>> void quickSort(List<E> a) 
	{
		quickSort(a, 0, a.size());
	}

	private static <E extends Comparable<? super E>> void quickSort(List<E> a, int left, int right) 
	{
		if(left+1>=right) return;
		
		int mid = partition(a, left, right);
		
		quickSort(a, left, mid);
		quickSort(a, mid+1, right);		
	}
	
	private static <E extends Comparable<? super E>> int partition(List<E> a, int left, int right) 
	{
		 E pivot = a.get(right-1);
	
		 int i=left-1;
		 
		 for(int j=left; j<right-1; j++) 
		 if(a.get(j).compareTo(pivot) <= 0) 
		 {
			 i++;
			 swap(a, i, j);
		 }
		 
		swap(a, i+1, right-1);
	    return i + 1;
	}
	
	private static <E> void swap(List<E> e ,int i,int j){
		E temp=e.get(i);
		e.set(i, e.get(j));
		e.set(j, temp);
	}



}
