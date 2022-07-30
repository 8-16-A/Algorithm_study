import java.util.Scanner;

public class Minsung {

    static int n, answer;
    static int[] board;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        board = new int[n];
        moveQueen(0);
        System.out.println(answer);
    }

    static void moveQueen(int idx) {
        if (idx == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[idx] = i;
            if (isSafe(idx)) {
                moveQueen(idx + 1);
            }
        }
    }

    static boolean isSafe(int idx) {
        for (int i = 0; i < idx; i++) {
            if (board[idx] == board[i] || // 같은 열에 있는지
                    Math.abs(idx - i) == Math.abs(board[idx] - board[i])) { // 대각선 상에 있는지
                return false;
            }
        }
        return true;
    }
}
