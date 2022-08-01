import java.util.Scanner;

public class BJ14225 {

    static int N;
    static int[] array, choice;
    static boolean[] visited;
    static boolean[] isPossibleResult = new boolean[20 * 100000 + 1]; // 배열 요소의 개수 N이 최대 20이고 배열 요소의 최대값이 100,000이므로
                                                                    //   배열 요소들의 합은 최대 20 * 100,000이다. 배열 요소들의 합을 인덱스로 사용하므로 1을 더해준다.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        array = new int[N];
        choice = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        rec(0, 0);

        for (int i = 1; i <= 20 * 100000; i++) {
            if (!isPossibleResult[i]) {
                System.out.println(i);
                break;
            }
        }
    }
    /*
    *  집합으로 만들 수 있는 부분집합들을 전부 구하고 그 합을 배열에 표시
    * */
    static void rec(int start, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += choice[i];
        }
        isPossibleResult[sum] = true;

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice[index] = array[i];
                rec(i, index + 1);
                choice[index] = 0;
                visited[i] = false;
            }
        }
    }
}
