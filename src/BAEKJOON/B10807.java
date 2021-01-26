package BAEKJOON;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B10807 {
	public static void main(String[] args) {
		int count = 0;
		
		Scanner scan = new Scanner(System.in);
		String length = scan.nextLine();
		String message = scan.nextLine();
		String key = scan.nextLine();
		
		for(String s : message.split(" ")) {
			if(s.equals(key)) count++;
		}
		
		System.out.println(count);
	}
}
