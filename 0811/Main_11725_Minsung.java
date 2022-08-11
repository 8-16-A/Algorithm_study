import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11725 {

    static int n;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder(10);
        n = Integer.parseInt(bf.readLine());
        String[] line;
        graph = new ArrayList<>(n + 1);
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            line = bf.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);
        for (int i = 2; i < n + 1; i++) {
            result.append(parent[i]).append('\n');
        }
        System.out.println(result);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            List<Integer> adjacent = graph.get(current);
            for (Integer node : adjacent) {
                if (!visited[node]) {
                    visited[node] = true;
                    parent[node] = current;
                    queue.offer(node);
                }
            }
        }

    }
}
