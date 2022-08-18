import java.util.Arrays;
import java.util.Scanner;

public class BJ10819 {

    static int n;
    static int[] nums, choice;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n];
        choice = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        do {
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(nums[i] - nums[i+1]);
            }
            max = Math.max(max, sum);
        } while (nextPermutation(nums));
        System.out.println(max);
    }

    static boolean nextPermutation(int[] numbers) {
        int n = numbers.length;
        int i = n - 1;
        while (i > 0 && numbers[i-1] >= numbers[i]) i--;
        if (i == 0) return false;
        int j = n -1;
        while (numbers[i-1] >= numbers[j]) j--;
        swap(numbers, i-1, j);
        int k = n-1;
        while (i < k) swap(numbers,i++,k--);
        return true;
    }

    static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
