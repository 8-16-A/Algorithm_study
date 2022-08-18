import java.io.IOException;
import java.util.*;

public class BJ11000 {

    static class Class implements Comparable<Class> {
        int start, end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class o) {
            int time = start - o.start;
            if (time == 0) time = end - o.end;
            return time;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Class> classList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            classList.add(new Class(start, end));
        }

        Collections.sort(classList);

        Queue<Class> queue = new PriorityQueue();
        Class first = classList.get(0);
        queue.add(first);

        for (int i = 1; i < n; i++) {
            Class current = classList.get(i);
            if (queue.peek().end <= current.start) {
                queue.poll();
            }
            queue.offer(current);
        }
        System.out.println(queue.size());
    }

}
