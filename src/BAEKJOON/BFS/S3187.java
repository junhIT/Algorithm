package BAEKJOON.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Pair{
	int x;
	int y;
	
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair() {
		// TODO Auto-generated constructor stub
	}
}
public class S3187 {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Queue<Pair> q = new LinkedList<>();
		
		String[][] border; // 들판
		int[][] vis; // 방문
		int[] dx = new int[] {1, 0, -1, 0};
		int[] dy = new int[] {0, 1, 0, -1};
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken()); // 평수
		int y = Integer.parseInt(st.nextToken()); // 평수
		
		int saveSheep = 0;
		int saveWolf = 0;
		
		border = new String[x][y];
		vis	= new int[x][y];
		
		for(int i = 0; i < x; i++) { // 울타리, 늑대, 양...
			sb.append(br.readLine());
		}
		
		String[] s = sb.toString().split("");
		int idx = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				border[i][j] = s[idx++];
			}
		}
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(vis[i][j] == 1 || border[i][j].equals("#")) continue;
				vis[i][j] = 1;
				q.add(new Pair(i,j));
				int sheep = 0;
				int wolf = 0;
				if(border[i][j].equals("k")) sheep++;
				else if(border[i][j].equals("v")) wolf++;
				while(!q.isEmpty()) {
					Pair xy = q.poll();
					for(int t = 0; t < 4; t++) {
						int nx = xy.x + dx[t];
						int ny = xy.y + dy[t];
						if(nx < 0 || nx >= x ||ny < 0 || ny >= y) continue;
						if(vis[nx][ny] == 1 || border[nx][ny].equals("#")) continue;
						vis[nx][ny]=1;
						q.add(new Pair(nx,ny));
						if(border[nx][ny].equals("k")) sheep++;
						else if(border[nx][ny].equals("v")) wolf++;
					}
				}
				if(sheep > wolf) saveSheep += sheep;
				else saveWolf += wolf;
			}
		}
		System.out.println(saveSheep + " " + saveWolf);
	}
}
