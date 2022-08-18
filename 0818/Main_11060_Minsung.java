import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ11060 {

    static int[] array;
    static int n;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(bfs(0));
    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(new int[]{start,0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int step = current[1];
            if (value == n-1) {
                return step;
            }
            for (int i = 1; i <= array[value]; i++) {
                if (value + i < n && !visited[value + i]) {
                    visited[value+i] = true;
                    queue.offer(new int[] {value + i,step+1});
                }
            }
        }
        return -1;
    }

}
