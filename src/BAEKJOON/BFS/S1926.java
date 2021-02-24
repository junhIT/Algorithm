package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class S1926 {
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[500][500];
		boolean[][] vis = new boolean[500][500];
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		Pair pair = new Pair();
		
		int large = 0;
		int largeTemp = 0;
		int count = 0;
		
		Queue<Pair> q = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken()); // 높이
		int y = Integer.parseInt(st.nextToken()); // 넓이

		// 도화지 값 읽기
		for(int i = 0; i < x; i ++) {
			sb.append(br.readLine() + " ");
		}
		
		st = new StringTokenizer(sb.toString());
		
		// 도화지에 그리기
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		for(int i = 0; i <x ; i++) {
			for(int j = 0; j < y; j++) {
				if(arr[i][j] != 1) continue;
					count++;
					arr[i][j]=2;
					q.add(new Pair(i,j));
					System.out.println("Queue in : " + i + ", "+ j);
					largeTemp = 0;
					while(!q.isEmpty()) {
						largeTemp++;
						pair = q.poll();
						System.out.println("Queue out : " + pair.x + ", " + pair.y);
						for(int t = 0; t < 4; t++) {
							int xx = pair.x + dx[t];
							int yy = pair.y + dy[t];
							if(xx < 0 || xx >= x || yy < 0 || yy >= y) continue;
							if(arr[xx][yy] != 1) continue;
							arr[xx][yy]=2;
							System.out.println("Queue in : " + xx + ", "+ yy);
							q.add(new Pair(xx,yy));
						}
					}
					large = (largeTemp > large) ? largeTemp : large;
			}
		}
		
		System.out.println(count);
		System.out.println(large);
		
	}
}