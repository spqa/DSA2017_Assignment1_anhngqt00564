package org.datastructure;

import java.awt.event.ItemEvent;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SortedArrayList<E> implements Iterable<E>, List<E> {

	private E[] data;
	private int capacity;
	private int filled;
	private Comparator<E> comparator;

	@SuppressWarnings("unchecked")
	public SortedArrayList(Comparator<E> comparator) {
		this.comparator = comparator;
		capacity = 10;
		filled = 0;
		this.data = (E[]) new Object[capacity];
	}

	// private int binarySearch(E item) {
	// // return the index of item if match
	// // return -(position +1) if no match and position is index item should
	// // insert
	//
	// int indexMid = 0;
	// if (data.length == 0) {
	// return 0;
	// }
	//
	// if (data.length % 2 == 0) {
	// indexMid = data.length / 2;
	// }else{
	// indexMid=(data.length -1)/2;
	// }
	//
	// if (condition) {
	//
	// }
	//
	// }

	private void increaseCapacity() {
		data = Arrays.copyOf(data, data.length + 10);
	}

	@Override
	public boolean add(E e) {
		if (e == null) {
			throw new NullPointerException();
		}

		if (capacity == filled) {
			increaseCapacity();
		}

		// binarySearch work with least 2 element , data.length always>=10
		// because of capacity
		if (filled < 3) {
			if (data[0] == null) {
				data[0] = e;
			} else if (data[1] == null) {
				int x = comparator.compare(data[0], e);
				if (x > 0) {
					data[1] = data[0];
					data[0] = e;
				}
			}

		} else {
			int index = Arrays.binarySearch(data, e, comparator);
			index = index < 0 ? (-index - 1) : index;
			insert(index, e);
		}

		return true;
	}

	private void insert(int index, E element) {
		for (int i = data.length; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = element;
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();

	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object e) {

		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		if (index < 0 || index >= filled) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return filled == 0 ;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {

		return false;
	}

	@Override
	public E remove(int index) {
		if (index < 0 || index >= filled) {
			throw new IndexOutOfBoundsException();
		}
		// index+1 < filled
		for (int i = index; i < filled - 1; i++) {
			data[index] = data[index + 1];
		}
		filled--;
		//decrease capacity??
		//disable for performance
//		if (capacity - filled > 20) {
//			data = Arrays.copyOf(data, data.length - 10);
//		}
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

}
