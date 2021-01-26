package Programmers;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Level2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*
		 * String
		 */
		//Scanner scan = new Scanner(System.in);
		//String message = scan.nextLine();
		
		
		/*
		 * int배열
		 */
		
		
		int nums[] = new int[50];
		int n = 0;
		do {
			Scanner scan = new Scanner(System.in);
			if(scan.nextInt() != -1) nums[n] = scan.nextInt();
			n++;
		}while(nums[n-1] != -1);
		System.out.println(solution3(nums));
	}
	// 정상적인 괄호만 제거하는 Function
    static boolean solution1(String s) { 
        int length1=0, length2=0;
        boolean exit = false;
        length1 = s.length();
        while(exit == false) {
        	if(length1==0) return true;
        	if(length1 == length2) return false;
        	length1 = s.length();
        	s=s.replace("()", "");
        	length2 = s.length();
        }
        return false;
    }
    
    // 배열에서 첫 문자를 대문자로 만드는 Function  
    public static String solution2(String s) {
        String answer = "";
        String preS = "";
        String[] sArr = s.split(" ");
        for(int n = 0; n < sArr.length ; n++) {
        	if(!sArr[n].isEmpty()) {
	        	String first = sArr[n].substring(0, 1).toUpperCase();
	        	sArr[n] = first+sArr[n].substring(1, sArr[n].length()).toLowerCase();
        	}
    	}
        return String.join(" ", sArr);
    }

	/************************************************************************************************************************************
				문제 설명
				주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
				nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
			
				제한사항
				nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
				nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
	*************************************************************************************************************************************/
	
	 public static int solution3(int[] nums) {
	        int answer = -1;

	        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
	        System.out.println("Hello Java");

	        return answer;
	    }
	
}
