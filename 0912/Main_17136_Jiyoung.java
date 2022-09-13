package solving.solve_0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이_붙이기_17136 {

	static int[][] map;
	static int[] paper = {5, 5, 5, 5, 5};
	static int res = Integer.MAX_VALUE;
	
	private static boolean isInside(int x, int y) {
		if(x<0 || y<0 || x>=10 || y>=10) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(res);
		}
	}

	private static void dfs(int x, int y, int cnt) {
		if(x >= 9 && y > 9) {
			res = Math.min(res, cnt);
			return;
		}
		
		if(cnt > res) { //이미 개수가 많아지면 return
			return;
		}
		
		if(y > 9) {
			dfs(x+1, 0, cnt); //다음줄 넘어가기
			return;
		}
		
		if(map[x][y] == 1) {
			for(int i=4; i>=0; i--) {
				if(paper[i]>0 && isOk(x, y, i+1)) {
					put(x, y, i+1);
					paper[i]--;
					dfs(x, y+1, cnt+1);
					del(x, y, i+1);
					paper[i]++;
				}
			}
		}
		else {
			dfs(x, y+1, cnt);
		}
	}

	private static boolean isOk(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(!isInside(i, j) || map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static void put(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j] = 0;
			}
		}
	}
	
	private static void del(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j] = 1;
			}
		}
	}
}
