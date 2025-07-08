package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Sort2DArray {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 5, 1},
                {1, 8, 2},
                {4, 2, 7}
        };

        // Sort by the first column (index 0) in ascending order
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] row1, int[] row2) {
                return Integer.compare(row1[0], row2[0]);
            }
        });

        // Print the sorted matrix
        System.out.println("Sorted by first column:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        // Sort by the second column (index 1) in descending order (using lambda)
        Arrays.sort(matrix, (row1, row2) -> Integer.compare(row2[1], row1[1]));

        System.out.println("\nSorted by second column (descending):");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}