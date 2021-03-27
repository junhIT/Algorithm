//더하기 사이클

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1110 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str = br.readLine();
		String num = (str.length() == 1) ? "0"+str : str; 
		
		int sum = 0;
		int count = 0;
		String newNum = "";
		while(!num.equals(newNum)) {
			if(newNum=="") newNum = num;
			for(String s : newNum.split("")) {
				sum += Integer.parseInt(s);
			}
			if (sum < 10) newNum += sum;
			else newNum += sum%10;
			newNum = newNum.substring(1,3);
			System.out.println( " num : " + num + " newNum : " + newNum );
			count++;
		}
		System.out.println(count);
	}
}
