import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1388 {

    static int n, m, answer;
    static char[][] room;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        room = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < m; j++) {
                room[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    answer++;

                }
            }
        }
        System.out.println(answer);

    }

    static void bfs(int sy, int sx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sy, sx});
        visited[sy][sx] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int y = poll[0];
            int x = poll[1];
            if (room[y][x] == '-') {
                if (isValidLocation(y, x - 1) && !visited[y][x - 1] &&
                        room[y][x - 1] == '-') {
                    visited[y][x - 1] = true;
                    queue.offer(new int[]{y, x - 1});
                }
                if (isValidLocation(y, x + 1) && !visited[y][x + 1] &&
                        room[y][x + 1] == '-') {
                    visited[y][x + 1] = true;
                    queue.offer(new int[]{y, x + 1});
                }
            } else {
                if (isValidLocation(y - 1, x) && !visited[y - 1][x] &&
                        room[y - 1][x] == '|') {
                    visited[y - 1][x] = true;
                    queue.offer(new int[]{y - 1, x});
                }
                if (isValidLocation(y + 1, x) && !visited[y + 1][x] &&
                        room[y + 1][x] == '|') {
                    visited[y + 1][x] = true;
                    queue.offer(new int[]{y + 1, x});
                }
            }

        }
    }

    private static boolean isValidLocation(int y, int x) {
        if (y < 0 || y >= n || x < 0 || x >= m) return false;
        return true;
    }
}
