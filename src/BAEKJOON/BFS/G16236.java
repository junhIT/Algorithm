package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair16236{
	int x;
	int y;
	
	public Pair16236(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}

public class G16236 {
	public static int[][] arr = new int[20][20];
	
	public static int[] dx = {0, -1, 0 , 1};
	public static int[] dy = {1, 0, -1 , 0};
	public static int n, level, need, move;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();

			n = Integer.parseInt(br.readLine()); //  N * N ( 어항 )
			
			// 어항에 들어있는 물고기 입력
			for(int i = 0; i < n; i++) {  
				sb.append(br.readLine()+" ");
			}
			st = new StringTokenizer(sb.toString());
			
			// 어항에 물고기 넣기
			int temp, x = 0, y = 0; //  아기상어 첫 위치 확인을 위한 변수
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					temp = Integer.parseInt(st.nextToken());
					arr[i][j] = temp;
					// 아기상어 일 경우 좌표 기억하기
					if(temp==9) {
						x = i;
						y = j;
					}
				}
			}
			
			need=1;
			level=1;
			while(BFS(x, y));
			
			consoleArray();
			
			System.out.println(move);
	}
	
	public static void consoleArray() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	
	
	public static boolean BFS(int x, int y) {
		int[][] visit = new int[20][20];
		Queue<Pair16236> q = new LinkedList<>();
		q.add(new Pair16236(x, y));
		visit[x][y] = 1;
		while(!q.isEmpty()) {
			Pair16236 xy = q.poll();
			move++;
			for(int i = 0; i < 4; i++) {
				int nx = xy.x+dx[i];
				int ny = xy.y+dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(arr[nx][ny]==99)arr[nx][ny]=0;
				if(arr[nx][ny] > level) continue;
				if(need == 0) {
					level++;
					need = level;
				}
				
				if(arr[nx][ny] != 0) {
					need--;
					arr[nx][ny] = 9;
					arr[x][y] = 0;
					return true;
				}
				arr[nx][ny] = 99;
				consoleArray();
				q.add(new Pair16236(nx,ny));
			}
		}
		return false;
	}
}
