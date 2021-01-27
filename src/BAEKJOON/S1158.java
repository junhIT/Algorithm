package BAEKJOON;
/*
 * 요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class S1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String result = "<";
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// Integer형 Queue 생성
		Queue<Integer> queue = new LinkedList<>();
		
		// input : N  K >> N = Person, K는 순서
		String[] inputArr = br.readLine().split(" ");
		int person = Integer.parseInt(inputArr[0]);
		int index = Integer.parseInt(inputArr[1]);

		//1 ~ person까지 값을 queue에 넣음
		for(int n = 1; n <= person; n++) {
			queue.offer(n);
		}
		
		// n == index >> 제외되어야 하는 순서 
		int n=1;
		
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			
			// K번째 순서일 경우 사람 제외
			if(n==index) {
				result+=temp+", ";
				n=0;
			//K번째 순서가 아닐 경우 다시 queue에 값 넣음 
			}else {
				queue.offer(temp);
			}
			n++;
		}
		
		result = result.substring(0, result.length()-2)+">";
		bw.write(result);
		
		bw.flush();
		bw.close();
		br.close();
	}

}
