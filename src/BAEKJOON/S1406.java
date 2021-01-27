package BAEKJOON;
/*
  	한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.
	
	이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다. 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
	
	이 편집기가 지원하는 명령어는 다음과 같다.
	
	L	커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
	D	커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
	B	커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
	삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
	P $	$라는 문자를 커서 왼쪽에 추가함
	초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성하시오. 단, 명령어가 수행되기 전에 커서는 문장의 맨 뒤에 위치하고 있다고 한다.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class S1406 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		// Buffer Reader, Writer 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// Stack Left, Right 생성
		Stack<String> left = new Stack<String>();
		Stack<String> right = new Stack<String>();
		
		// 첫번째 입력 Line = 문장
		for(String c : br.readLine().split("")){
			left.push(c);
		}
		
		// 두번째 입력 Line = 명령어 개수
		int length = Integer.parseInt(br.readLine());
		
		// 명령어 개수만큼 반복
		for(int n = 0; n < length; n++) {
			//세번째 입력 Line ~ 명령어
			String command = br.readLine();
			char[] cArr = command.toCharArray();
			char c=cArr[0];
			
			switch(c) {
				// Left Stack에 값이 존재하면 Right Stack으로 1개 옮김	
				case 'L':
					if(!left.isEmpty())right.push(left.pop());
					break;
				// Right Stack에 값이 존재하면 Left Stack으로 1개 옮김
				case 'D':
					if(!right.isEmpty())left.push(right.pop());
					break;
				// Left Stack에 값이 존재하면 Pop
				case 'B':
					if(!left.isEmpty())left.pop();
					break;
				case 'P':
				// left에 값 입력
					left.push(String.valueOf(cArr[2]));
					break;
			}
		}
		
		while(!left.isEmpty()) right.push(left.pop());
		while(!right.isEmpty()) bw.write(right.pop());
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
