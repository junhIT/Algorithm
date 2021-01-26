package BAEKJOON;
/*
 * 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
 * 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
*/

import java.util.Scanner;

public class B2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int first = scan.nextInt();
		int second = scan.nextInt();
		int third = scan.nextInt();
		
		String result = Integer.toString(first*second*third);
	
		for(int n = 0; n < 10; n++) {
			int count = 0;
			for(String s : result.split("")) {
				if(Integer.toString(n).equals(s)) count++;
			}
			System.out.println(count);
		}
	}
}
