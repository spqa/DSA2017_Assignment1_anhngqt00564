package org.tests;

import org.datastructure.ArrayList;

public class to_test_for_loop {

	static int i=0;
	public static void main(String[] args) {
		
		for (int i = 0; i < increase(); i++) {
			
		}
		
//		ArrayList<String> arrayList=new ArrayList<>();
//		arrayList.add("haha");
//		arrayList.add("haha");
//		arrayList.add("haha");
//		arrayList.add("haha");
//		System.out.println(arrayList.size());
//		System.out.println(arrayList.get(arrayList.size()));
		int i=2;
		System.out.println(i=3/2);
	}
	
	public static int increase() {
		if(i<10){
			System.out.println(i++);
			return i;
		}
		return i;
	}
	
	// ->should not call function in for loop header
}
