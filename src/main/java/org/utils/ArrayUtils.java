package org.utils;

public class ArrayUtils {

	public static <E> E[] reverse(E[] e) {
		for(int i = 0; i < e.length / 2; i++)
		{
		    E temp = e[i];
		    e[i] = e[e.length - i - 1];
		    e[e.length - i - 1] = temp;
		}
		return e;
	}
}
