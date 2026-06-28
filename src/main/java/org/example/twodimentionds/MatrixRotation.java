package org.example.twodimentionds;

public class MatrixRotation {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            // CRITICAL: j starts at 'i' to only traverse the upper right triangle.
            // This prevents double-swapping.
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            // CRITICAL: j goes up to n/2. 
            // We use a two-pointer approach (left and right edges moving inward).
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                // Swap current element with its counterpart on the other side of the row
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // Helper method to print the matrix nicely
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("\nRotated 90 Degrees Clockwise:");
        printMatrix(matrix);
    }
}