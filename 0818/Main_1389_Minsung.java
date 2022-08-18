import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1389 {

    static int n;
    static LinkedList<Integer>[] graph;
    static int[] baconSum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new LinkedList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new LinkedList<>();
        }
        baconSum = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i < n + 1; i++) {
            bfs(i);
        }
        int min = baconSum[1], minIdx = 1;
        for (int i = 1; i < n + 1; i++) {
            if (min > baconSum[i]) {
                min = baconSum[i];
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }

    static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start,0});
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current[] = queue.poll();
            int depth = current[1];
            baconSum[start] += depth;
            for (int adjacent : graph[current[0]]) {
                if (visited[adjacent]) continue;
                visited[adjacent] = true;
                queue.offer(new int[]{adjacent,depth+1});
            }
        }
    }
}
