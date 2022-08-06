package no_1874;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] inputs = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Character> q = new LinkedList<>();
	
		for (int i = 0; i < n; i++) {
			inputs[i] = Integer.parseInt(br.readLine());
		}
		
		int inputs_idx = 0;
		int num = 1;
		
		while(inputs_idx < n && num <= n+1) {
			if (num == inputs[inputs_idx]) {
				q.add('+');
				q.add('-');
				inputs_idx++;
				num++;
			}else if (!stack.empty() && inputs[inputs_idx] == stack.peek()) {
				stack.pop();
				q.add('-');
				inputs_idx++;
			}else {
				stack.add(num++);
				q.add('+');
			}
		}
		
		if (n*2 == q.size()) {
			for (int i = 0, end = q.size(); i < end; i++) {
				System.out.println(q.poll());
			}
		}else {
			System.out.println("NO");
		}
	}
}
