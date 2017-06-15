package org.assignment2;

public class to_test_common_string_operations {

	public static void main(String[] args) {
		String testString ;
		int temp;
		// concatenation
		System.out.println("test concatenation");
		testString = new String("Hello");
		System.out.println("before: "+testString);
		System.out.println("after: " + testString.concat(" world!"));
		
		// find character
		System.out.println("----------------------------");
		System.out.println("test find character");
		char query = 'e';
		testString = new String("Hello");
		System.out.println("test string: "+testString);
		if ((temp = testString.indexOf(query)) >= 0) {
			System.out.println(query+" appears in string at position "+temp);
		}else{
			System.out.println(query+"e not found");
		}
		
		// length
		System.out.println("----------------------------");
		System.out.println("test string length");
		testString = new String("Hello");
		System.out.println("test string: "+testString);
		System.out.println("length: " + testString.length());
		
		// lowercase
		System.out.println("----------------------------");
		System.out.println("test lowercase");
		testString = new String("HeLlo");
		System.out.println("before: "+testString);
		System.out.println("after: " + testString.toLowerCase());
		
		// substring
		System.out.println("----------------------------");
		System.out.println("test substring");
		testString = new String("Hello world!");
		System.out.println("test string: "+testString);
		System.out.println("substring: " + testString.substring(0,5));
		
		//trim
		System.out.println("----------------------------");
		System.out.println("test trim");
		testString = new String(" hello ");
		System.out.println("before: "+testString);
		System.out.println("after : " + testString.trim());
		
		
	}
	
}
