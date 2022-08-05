import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ1966 {
    static int[] priorities;
    static Queue<int[]> queue;
    static int n;
    static int m;
    static int answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            priorities = new int[10];
            queue = new ArrayDeque<>();
            answer = 0;
            for (int i = 0; i < n; i++) {
                int paper = scanner.nextInt();
                priorities[paper]++;
                queue.offer(new int[]{i, paper});
            }
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                if (isImportant(poll[1])) {
                    answer++;
                    priorities[poll[1]]--;
                    if (poll[0] == m) break;
                } else {
                    queue.offer(poll);
                }
            }
            System.out.println(answer);
        }

    }

    static boolean isImportant(int prior) {
        for (int i = prior+1; i <= 9; i++) {
            if (priorities[i] > 0) return false;
        }
        return true;
    }
}
