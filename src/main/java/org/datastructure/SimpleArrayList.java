package org.datastructure;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleArrayList<E> implements List<E>, Iterable<E> {

	protected E[] data;
	protected int size;
	protected int capacity;

	@SuppressWarnings("unchecked")
	public SimpleArrayList() {
		this.capacity = 0;
		data =(E[]) new Object[0] ;
	}
	
	

	@SuppressWarnings("unchecked")
	public SimpleArrayList(List<E> list) {
		this.data=(E[]) list.toArray();
		size=list.size();
	}



	@Override
	public boolean add(E e) {
		increaseCapacity();
		//set reference to object e at position [size] then increase size by 1
		data[size++] = e;
		return true;
	}

	@SuppressWarnings("unchecked")
	public void increaseCapacity() {
		if (size == 0) {
			capacity = 10;
			data=(E[]) new Object[10];
			return;
		}
		//Guarantee
		if ((size + 1 - capacity) > 0) {
			data = Arrays.copyOf(data, capacity = size + size / 2);
		}
	}

	@Override
	public void add(int index, E element) {
		rangeCheck(index);
		increaseCapacity();
		for (int i = size; i >index; i--) {
			data[i] =data[i-1];
		}
		data[index]=element;
		size++;
	}
	
	private void rangeCheck(int index) {
		if (index<0 || index>(size)) {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data =(E[]) new Object[0] ;
	}

	@Override
	public boolean contains(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E get(int index) {
		rangeCheck(index);
		return data[index];
	}

	@Override
	public int indexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator<>(this);
	}

	@Override
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ArrayIterator<>(this);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (o==data[i]) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E remove(int index) {
		for (int i = index; i < size; i++) {
			data[i]=data[i+1];
		}
		size--;
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E set(int index, E element) {
		return data[index]=element;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size);
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	@Override
	public <E> E[] toArray(E[] a) {
		if (a.length < size)
	        // Make a new array of a's runtime type, but my contents:
	        return (E[]) Arrays.copyOf(data, size, a.getClass());
	    System.arraycopy(data, 0, a, 0, size);
	    if (a.length > size)
	        a[size] = null;
	    return a;
		
	}

}
