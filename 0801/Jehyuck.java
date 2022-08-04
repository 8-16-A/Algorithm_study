package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main__ {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int arr[];
	static boolean visit[];
	
	static void comb(int i, int value) {
		if (value > 200000) return ;
		visit[value] = true;
		for (int j = i + 1; j < N; j++) {
//			System.out.println(value + arr[j]);
			comb(j, value + arr[j]);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		arr = new int[N];
		visit =  new boolean[200000 + 2];
		
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		comb(-1, 0);
		int i;
		for (i = 1; i < 200001; i++) {
			if (!visit[i]) break;
		}
		System.out.println(i);
	}
}
