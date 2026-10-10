

import java.util.Scanner;

public class PracticeProblem6 {

    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int streak = 0;
        int longest = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                streak++;

                if (streak > longest) {
                    longest = streak;
                }
            } else {
                streak = 0;
            }
        }

        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0]
                + ", Longest streak: " + result[1]);

        sc.close();
    }
}
