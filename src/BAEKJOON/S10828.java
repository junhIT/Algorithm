package BAEKJOON;
/*스택
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 다섯 가지이다.
push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class S10828 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Buffer Reader, Writer 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> list = new LinkedList<>();
		int index = Integer.parseInt(br.readLine());
		for(int n = 0; n < index; n++) {
			String command = br.readLine();
			
			if(command.contains("push"))  // list에 push
				list.add(Integer.parseInt(command.split(" ")[1]));
			else if(command.contains("pop")) { // list가 비어있다 = -1, list 마지막 값 출력 + 제거
				if(list.isEmpty()) 
					sb.append("-1\n");
				else{
					sb.append(list.getLast() + "\n");
					list.pollLast();
				}
			} else if(command.contains("size")) { // list size 출력
				sb.append(list.size() + "\n");
			} else if(command.contains("empty")) { // list가 비어있다 = 1, list에 값이 있다 = 0
				if(list.isEmpty())
					sb.append("1\n"); 
				else sb.append("0\n");
			} else if(command.contains("top")) { // list가 비어있다 = -1, list 마지막 값 출력
				if(list.isEmpty()) 
					sb.append("-1\n");
				else{
					sb.append(list.getLast() + "\n");
				}
			}
		}
		System.out.println(sb);
		br.close();
	}
}
