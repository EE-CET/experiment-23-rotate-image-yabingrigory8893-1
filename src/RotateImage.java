import java.util.Scanner;

public class RotateImage {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNextInt()) return;
            int n = sc.nextInt();
            if (sc.hasNextInt()) sc.nextInt(); // Consume the second n (dimensions)

            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sc.hasNextInt()) {
                        matrix[i][j] = sc.nextInt();
                    }
                }
            }

            // 1. Transpose the matrix
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            // 2. Reverse each row
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }

            // Print the rotated matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + (j == n - 1 ? "" : " "));
                }
                System.out.println();
            }
        }
    }
}
