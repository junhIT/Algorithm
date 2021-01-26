package BAEKJOON;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String message, result = null;
		Map<String, Integer> map = new HashMap<>();
		boolean dup = false;
		int pValue = 0;
		
		Scanner scan = new Scanner(System.in);
		
		message = scan.nextLine().toUpperCase();
		
		for(String s : message.split("")) {
			
			if(map.get(s)==null) map.put(s, 1);
			else {
				map.put(s, map.get(s)+1);
				}
		}
		
		for(String key : map.keySet()){
			int value = map.get(key);
			if(pValue < value) {
				pValue = value;
				result = key;
				dup = false;
			}else if (pValue == value) {
				dup=true;
			}
		}
		
		if(dup==true) {
			System.out.println("?");
		} else {
			System.out.println(result);
		}
	}
}
