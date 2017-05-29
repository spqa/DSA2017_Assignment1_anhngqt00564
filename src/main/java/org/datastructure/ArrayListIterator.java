package org.datastructure;

import java.util.Iterator;
import java.util.List;

public class ArrayListIterator<E> implements Iterator<E>{

	private int current=0;
	private List<E> list;
	public ArrayListIterator(List<E> e) {
		list=e;
	}
	
	@Override
	public boolean hasNext() {
		return current!=list.size();
	}

	@Override
	public E next() {
//		if (hasNext()) {
			return list.get(current++);
//		}
//		return null;
	}

}
