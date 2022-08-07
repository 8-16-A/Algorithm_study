import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(10);
        int next = 1;
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(bufferedReader.readLine());
            while (next <= target) {
                stack.push(next++);
                sb.append('+').append('\n');
            }
            int pop = stack.pop();
            if (pop == target) {
                sb.append('-').append('\n');
            } else {
                sb = new StringBuilder("NO\n");
                break;
            }
        }
        System.out.println(sb);
    }
}
