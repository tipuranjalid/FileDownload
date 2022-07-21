package com.javaPrograms;

import java.util.HashMap;

public class CheckCharacterOccuranceCount {
	public static void charOccur(String Value) {
		String str = Value.toLowerCase();		
		HashMap<Character, Integer> hMap = new HashMap<>();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (hMap.containsKey(str.charAt(i))) {
				int count = hMap.get(str.charAt(i));
				hMap.put(str.charAt(i), ++count);
			} else {
				hMap.put(str.charAt(i), 1);
			}
		}
		System.out.println(hMap);

	}
	

	public static void main(String[] args) {
		charOccur("I am Tipuranjali");
	}
		
		

}
