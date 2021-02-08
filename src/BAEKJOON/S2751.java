/*
 * 문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

 */

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2751 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int index = 0, min, temp;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		int[] array = new int[n];
		for(int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		/*
		// 선택정렬

		for (int i = 0; i < n; i++) {
			min = Integer.MAX_VALUE;
			for(int j = i; j < n; j++) {
				if(array[j] < min) {
					min = array[j];
					index = j;
				}
			}
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
			sb.append(temp+"\n");
		}
		
		System.out.println(sb);
		*/
		
		//버블정렬
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n-1-i; j++) {
				if(array[j] > array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.println(array[i]);
		}
		
	}
	

}
