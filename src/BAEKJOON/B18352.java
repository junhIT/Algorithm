//특정 거리의 도시 찾기 분류
/*
 * 문제
어떤 나라에는 1번부터 N번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1이다.

이 때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성하시오. 또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정한다.

예를 들어 N=4, K=2, X=1일 때 다음과 같이 그래프가 구성되어 있다고 가정하자.



이 때 1번 도시에서 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 2인 도시는 4번 도시 뿐이다.  2번과 3번 도시의 경우, 최단 거리가 1이기 때문에 출력하지 않는다.

입력
첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다. (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N) 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다. 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다. (1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수이다.

출력
X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.

이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.

예제 입력 1 
4 4 2 1
1 2
1 3
2 3
2 4

예제 출력 1 
4
 */


package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18352 {

//	static int MAX = Integer.MAX_VALUE;
//	static int cityCount, roadInfo;
//	static int[][] doubleArr;
//	static int[] minPath;
//	
//	

	public static int n, m, k, x;
	public static ArrayList<ArrayList<Integer>> graph 
		= new ArrayList<ArrayList<Integer>>();
	
	public static int[] d = new int[300001];
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 도시의 갯수
		m = Integer.parseInt(st.nextToken()); // 도로의 갯수
		k = Integer.parseInt(st.nextToken()); // 거리 정보
		x = Integer.parseInt(st.nextToken()); // 출발 도시의 번호
		
		for(int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			d[i] = -1;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
		}
			
		d[x]=0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(x);
		
		while(!q.isEmpty()){
			int now = q.poll();
			for(int i = 0; i < graph.get(now).size(); i++){
				int nextNode = graph.get(now).get(i);
				
				if(d[nextNode] == -1) {
					d[nextNode] = d[now]+1;
					q.offer(nextNode);
				}
			}
		}
		
		boolean check = false;
		for(int i = 1 ; i <= n; i++) {
			if(d[i] == k) {
				System.out.println(i);
				check=true;
			}
		}
		
		if(!check) {
			System.out.println("-1");
		}
		
		
		
		
		
		// 메모리 초과..
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		String[] tempArr = br.readLine().split(" ");
//		StringBuilder sb = new StringBuilder();
//		
//		cityCount = Integer.parseInt(tempArr[0]); 	// 도시의 개수
//		int roadCount =  Integer.parseInt(tempArr[1]); 	// 도로의 개수
//		roadInfo =  Integer.parseInt(tempArr[2]); 	// 도로 정보
//		int start =  Integer.parseInt(tempArr[3])-1;		// 출발점
//		
//		doubleArr = new int[cityCount][cityCount];	// 도로 거리 배열
//		minPath = new int[cityCount];					// 최소 거리 배열
//		
//		Arrays.fill(minPath, MAX);		// 최소 거리 배열 초기화
//		
//		for(int n = 0; n < roadCount; n++) {
//			String s = br.readLine();
//			doubleArr[Integer.parseInt(s.split(" ")[0])-1][Integer.parseInt(s.split(" ")[1])-1] = 1;
//		}
//		
//		br.close();
//		
//		isExist(start, 1);
//		
//		for(int n = 0; n < minPath.length; n++) {
////			System.out.println("minPath[" + n + "] : " + minPath[n]);
//			if(minPath[n] == roadInfo) sb.append(n+1+"\n");
//		}
//		
//		if(sb.toString().equals("")) sb.append("-1"); 
//		
//		System.out.println(sb);
//	}
//	
//	public static boolean isExist(int start, int increase) {
//		for(int n = 0; n < cityCount; n++) {
//			if(doubleArr[start][n] != 0) {
////				System.out.println("start = " + start + " n = " + n + "   Increase : " + increase);
//				if(minPath[n] > increase)minPath[n] = increase;
//				isExist(n, increase+1);
//				
//			}
//		}
//		return false;
		
		
		
		
	}	
}
