package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class B10808 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String word = scan.nextLine();
		
		int[] result = new int[26];
		
		for(char c : word.toCharArray()) {
			result[((int)c-97)]++;
		}
		
		for(int n = 0; n < result.length; n++) {
			System.out.print(result[n]+" ");
		}
//		System.out.println(Arrays.toString(result));
	}
}
