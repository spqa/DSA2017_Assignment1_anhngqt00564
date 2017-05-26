package org.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("serial")
public class CustomArrayList<E extends Comparable< ? super E>> extends ArrayList<E>{

	
	public CustomArrayList(List<E> e){
		super(e);
		Collections.sort(this);		
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
