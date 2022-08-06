package no_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int T;
	static Queue<int[]> q;
	static List<Integer> list;
	static int N, target;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			q = new LinkedList<>();
			list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			target = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if (i == target) {
					q.offer(new int[] {1, temp});
				}else {
					q.offer(new int[] {0, temp});
				}
				
				list.add(temp);
			}
			
			int count = 0;
			int[] temp = null;
			
			while(true) {
				for (int i = 1; i < q.size(); i++) {
					if (list.get(i) > q.peek()[1]) {
						temp = q.poll();
						list.remove(0);
						break;
					}
				}
				
				if (temp == null) {
					temp = q.poll();
					list.remove(0);
					count++;
					
					if (temp[0] == 1) {
						System.out.println(count);
						break;
					}
				}else {
					q.offer(temp);
					list.add(temp[1]);
				}
				
				temp = null;
			}
		}
	}
	
}
