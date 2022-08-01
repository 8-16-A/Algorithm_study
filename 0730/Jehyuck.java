package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_ {

	public static void main(String[] args) throws Exception{
		Stack<Integer> st = new Stack<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(bf.readLine());
			if (input == 0)
				st.pop();
			else
				st.push(input);
		}
		int answer = 0;
		for (Integer i: st) {
			answer += i;
		}
		System.out.println(answer);
	}
}
