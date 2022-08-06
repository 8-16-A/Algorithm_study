package no_2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] arr;
	static List<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				func(0, i, j, "");
			}
		}
		
		System.out.println(list.size());
	}
	public static void func(int cnt, int x, int y, String str) {
		if (cnt == 6) {
			if (list.indexOf(str) < 0) {
				list.add(str);
			}
			return;
		}
		
		str += arr[x][y];
//		System.out.println(str);
		for (int i = 0; i < 4; i++) {
			if (x+dx[i] < 0 || x+dx[i] >= 5 || y+dy[i] < 0 || y+dy[i] >= 5)
				continue;

			func(cnt+1, x+dx[i], y+dy[i], str);
		}
	}
}
