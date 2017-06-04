package org.datastructure;

import java.util.Collections;
import java.util.List;

public class CustomArrayList<E extends Comparable< ? super E>> extends SimpleArrayList<E>{

	
	public CustomArrayList(List<E> e){
		super(e);
		SortModule.quickSort(this);		
	}	
	
	public CustomArrayList() {
		super();
	}
	 
	public boolean add(E e) {
        int index = Collections.binarySearch(this, e);
        if (index < 0) index = -index-1;
        super.add(index, e);
        return true;
    }
}
