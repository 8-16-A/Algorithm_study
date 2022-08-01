package no_14225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static int n;
   static int[] s;
   static boolean[] arr;
   
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      n = Integer.parseInt(br.readLine());
      s = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int max = 0;
      
      for (int i = 0; i < n; i++) {
         s[i] = Integer.parseInt(st.nextToken());
         max += s[i];
      }
      
      // 1부터 max까지 모두 나올 수 있는 숫자이면 max+1 값이 출력되야 하므로 배열 크기는 max+2
      arr = new boolean[max+2];
      
      dfs(0, 0);
      
      for (int i = 1; i < max+2; i++) {
         if (!arr[i]) {
            System.out.println(i);
            break;
         }
      }
   }
   
   public static void dfs(int height, int sum) {
	   if (height==n) {
		   arr[sum] = true;
		   return;
	   }
	   
	   // 포함 안하는 경우
	   dfs(height+1, sum);
	   
	   // 포함하는 경우
	   sum += s[height];
	   dfs(height+1, sum);
   }
   
}