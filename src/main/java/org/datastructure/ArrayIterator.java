package org.datastructure;

import java.util.List;
import java.util.ListIterator;

public class ArrayIterator<E> implements ListIterator<E>{

	int current=0;
	List<E> list;
	
	
	public ArrayIterator(List<E> list) {
		this.list=list;
	}

	@Override
	public boolean hasNext() {
		return current!=list.size();
	}

	@Override
	public E next() {
		
		return list.get(current++);
	}

	@Override
	public boolean hasPrevious() {
		return current!=0;
	}

	@Override
	public E previous() {
		if (current==0) {
			return null;
		}
		current --;
		return list.get(current);
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return current;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return current-1;
	}

	@Override
	public void remove() {
		list.remove(current-1);
		
	}

	@Override
	public void set(E e) {
		list.set(current-1, e);
		
	}

	@Override
	public void add(E e) {
		list.add(e);		
	}

	
}
