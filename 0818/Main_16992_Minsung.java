import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ16992 {

    static int n;
    static int[] values = {1, 5, 10, 50};
    static Set<Integer> set = new HashSet<>(50);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        combination(0, 0, 0);
        System.out.println(set.size());
    }

    static void combination(int cnt, int start, int value) {
        if (cnt == n) {
            set.add(value);
            return;
        }
        for (int i = start; i < 4; i++) {
            combination(cnt + 1, i, value + values[i]);
        }
    }
}