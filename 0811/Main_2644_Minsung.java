import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] line = bf.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int m = Integer.parseInt(bf.readLine());
        List<List<Integer>> graph = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            line = bf.readLine().split(" ");
            int parent = Integer.parseInt(line[0]);
            int child = Integer.parseInt(line[1]);
            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        boolean[] visited = new boolean[n + 1];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{a, 0});
        visited[a] = true;
        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            List<Integer> adjacent = graph.get(current[0]);

            for (Integer ad : adjacent) {

                if (!visited[ad]) {
                    if (current[0] == b) {
                        System.out.println(current[1]);
                        return;
                    }
                    visited[ad] = true;
                    stack.push(new int[] {ad,current[1]+1});
                }
            }
        }
        System.out.println(-1);
    }
}
