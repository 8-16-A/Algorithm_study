import java.util.*;

public class BJ2800 {
    static List<int[]> braces;
    static Set<String> result = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();
        char[] operation = original.toCharArray();
        Stack<Integer> stack = new Stack<>();
        braces = new ArrayList<>(10);
        for (int i = 0, length = operation.length; i < length; i++) {
            if (operation[i] == '(') {
                stack.push(i);
            }
            if (operation[i] == ')') {
                int pop = stack.pop();
                braces.add(new int[]{pop, i});
            }
        }
        combination(braces.size(), braces.size()-1,operation);

        for (String s : result) {
            if (s.equals(original)) continue;
            System.out.println(s);
        }
    }

    static void combination(int current, int r, char[] operation) {
        if (current < r) return;
        if (r < 0) {
            StringBuilder sb = new StringBuilder(10);
            for (char c : operation) {
                if (c != ' ') sb.append(c);
            }
            result.add(sb.toString());
            return;
        }
        int[] brace = braces.get(r);
        operation[brace[0]] = ' '; // '('
        operation[brace[1]] = ' '; // ')'
        combination(current - 1, r - 1, operation);

        operation[brace[0]] = '('; // '('
        operation[brace[1]] = ')'; // ')'
        combination(current - 1, r - 1, operation);
    }
}
