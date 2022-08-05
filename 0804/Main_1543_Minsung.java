import java.util.Scanner;

public class BJ1543 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String paper = scanner.nextLine();
        String word = scanner.nextLine();
        int paperLength = paper.length(), wordLength = word.length();
        int i = 0;
        int answer = 0;
        while (i <= paperLength - wordLength) {
            if (paper.charAt(i) == word.charAt(0)) {
                if(isSame(paper, word, i)) {
                    answer++;
                    i+=wordLength-1;
                }
            }
            i++;
        }
        System.out.println(answer);
    }

    private static boolean isSame(String paper, String word,int start) {
        int length = word.length();
        for (int j = 0; j < length; j++) {
            if (paper.charAt(start + j) != word.charAt(j)) {
                return false;
            }

        }
        return true;
    }
}
