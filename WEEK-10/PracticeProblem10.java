
import java.util.Scanner;

public class PracticeProblem10 {

    static int[] busiestRow(int[][] grid) {
        int maxRow = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int sum = 0;

            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j];
            }

            if (sum > maxTotal) {
                maxTotal = sum;
                maxRow = i;
            }
        }

        return new int[]{maxRow, maxTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int[] result = busiestRow(grid);

        System.out.println("Row " + result[0] +
                ", Total " + result[1]);

        sc.close();
    }
}

