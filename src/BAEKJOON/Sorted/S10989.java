package BAEKJOON.Sorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S10989 {
	static int[] sorted;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			
			int num = Integer.parseInt(br.readLine()); // 숫자 개수
			int[] arr = new int[num]; // 숫자 배열
			// 배열에 숫자 입력
			for(int i = 0; i < num; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(arr);
			
			/*
			sorted = new int[num]; // 결과 배열
			
			mergeSort(arr, 0, num-1);
			*/
			for(int n = 0; n < num; n++) {
				sb.append(arr[n]+"\n");
			}
			
			System.out.println(sb);
	}
	
	public static void merge(int[] a, int m, int middle, int n) {
		int i = m;
		int j = middle+1;
		int k = m;
		
		// 좌배열 우배열 비교하며 작은 값 넣기
		while(i <= middle && j <= n) {
			if(a[i] < a[j]) {
				sorted[k] = a[i];
				i++;
			}else {
				sorted[k] = a[j];
				j++;
			}
			k++;
		}
		// 남은 값 넣기
		if(i <= middle) {
			while(i <= middle) {
				sorted[k] = a[i];
				k++;
				i++;
			}
		} else {
			while(j <= n) {
				sorted[k] = a[j];
				k++;
				j++;
			}
		}
		
		// 정렬된 배열 삽입
		for(int t = m; t <= n; t++) {
			a[t] = sorted[t];
		}
		
		
	}
	
	public static void mergeSort(int a[], int m, int n) {
		
		if(m < n) {
			int middle = (m + n) / 2;
			mergeSort(a, m, middle);
			mergeSort(a, middle+1, n);
			merge(a, m, middle, n);
		}
	}
}
