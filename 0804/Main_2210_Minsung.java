import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ2210 {
    static int N = 5;
    static int[][] board = new int[N][N];
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};

    static Set<Integer> set = new HashSet<>(30);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rec(i, j, 0, 0);
            }
        }

        System.out.println(set.size());
    }

    static void rec(int y, int x, int length, int result) {
        if (length == 6) {
            set.add(result);
            return;
        }
        result = result * 10 + board[y][x];
        for (int i = 0; i < 4; i++) {
            if (y + dy[i] < 0 || y + dy[i] >= N ||
                    x + dx[i] < 0 || x + dx[i] >= N) continue;
            rec(y + dy[i], x + dx[i], length + 1, result);
        }
    }
}
