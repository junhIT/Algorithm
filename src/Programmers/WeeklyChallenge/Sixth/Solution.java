package Programmers.WeeklyChallenge.Sixth;

import java.util.*;

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int len = head2head.length;
        int[] answer = new int[len];
        int[][] rank = new int[len][4];
        int win = 0;
        int over = 0;
        int cnt = 0;
        char fight;
                
        for(int i = 0; i < len; i++) {
            win= 0;
            over = 0;
            cnt = 0;
            for(int j = 0; j < len; j++) {
                fight = head2head[i].charAt(j);
                
                win += (fight == 'W') ? 1 : 0;
                over += (fight == 'W' && weights[i] < weights[j]) ? 1 : 0;
                cnt += (fight == 'N') ? 0 : 1;
            }
            rank[i][0] += (int)((double) win / cnt * 10000000) ;  // 승패
            rank[i][1] = weights[i];    // 몸무게
            rank[i][2] = over;          // 자신보다 무거운 몸무게를 이긴 횟수
            rank[i][3] = i+1;           // 랭킹
        }
                
        Arrays.sort(rank, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o2[0] - o1[0];
                if(o1[2] != o2[2]) return o2[2] - o1[2];
                if(o1[1] != o2[1]) return o2[1] - o1[1];
                return o1[3] - o2[3];
            }
        });

        for(int i = 0; i < len; i++) answer[i] = (int)rank[i][3];
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] param1 = {50, 82, 75, 120};
    	
    	String[] param2 = {"NLWL", "WNLL", "LWNW", "WWLN"};
    	Solution sol = new Solution();
    	
    	int[] result = sol.solution(param1,param2);
    	
    	for(int n : result) {
    		System.out.print(n + " ");
    	}
    }
}