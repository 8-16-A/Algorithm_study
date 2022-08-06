package no_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String doc;
	static String word;
//	static String temp_word;
	static int max_count = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		doc = br.readLine();
		word = br.readLine();
		
		dfs(0, 0);
		System.out.println(max_count);
	}

	private static void dfs(int cnt, int equal_cnt) {
		if (cnt > doc.length()-word.length()) {
			max_count = Math.max(max_count, equal_cnt);
			return;
		}
		
		String temp_word = doc.substring(cnt, cnt+word.length());
		
		if (temp_word.equals(word)) {
//			dfs(cnt+1, equal_cnt+1);
			dfs(cnt+word.length(), equal_cnt+1);
		}else {
			dfs(cnt+1, equal_cnt);
		}
	}
	
}
