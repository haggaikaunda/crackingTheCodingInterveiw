package com.Questions.Chapter1;

import java.lang.StringBuilder;

/**
 * Created by hkaunda on 11/26/17.
 */
public class matrixRotation {


    public static void main(String... args) {
        int[][] matrix0 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] matrix1 = new int[][]{
                {1,   2,  3,  4,  5},
                {6,   7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        printMatrix(matrix1);
        System.out.println(" ");
        rotateImageInPlace(matrix1);
        printMatrix(matrix1);

    }

    /** Rotate IMAGE by 90 degrees */
    static int[][] rotateImage(int[][] image) {
        int n = image.length;
        int[][] rotatedImage = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j= 0; j < n; j++) {
                rotatedImage[j][n - 1 - i] = image[i][j];
            }
        }
        return rotatedImage;
    }

    /** Rotate IMAGE by 90 degress in place; ie without allocating any more memory */
    static int[][] rotateImageInPlace(int[][] image) {
        int n = image.length;
        for (int layer = 0; layer < Math.ceil(n/2); layer++) {
            rotateLayer(layer, n, image);
        }
        return image;
    }

    /** Rotate a sigle LAYER of IMAGE. think of as LAYER a single peel of an onion */
    static void rotateLayer(int layer, int n, int[][] image) {
        int i = layer, j = layer;
        int layerBoundary = n-1;
        while (i + j < layerBoundary) {
            fourPointRotation(j, n - 1 - i, image[i][j], image, 0);
            j++;
        }
    }

    /** Rotate four points in IMAGE. NOTE: the point (i, j) => (j, IMAGE.length - 1 - i) */
    static void fourPointRotation(int i, int j, int replaceValue, int[][] image, int position) {
        int LIMIT = 4;
        if (position < LIMIT) {
            int temp = image[i][j];
            image[i][j] = replaceValue;

            fourPointRotation(j, image.length - 1 - i, temp, image, ++position);
        }
    }

    /** Print MATRIX in a human readable form */
    static void printMatrix(int[][] matrix) {
        StringBuilder builder = new StringBuilder();
        builder.append("		");
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {

                if (j == matrix.length - 1) builder.append(String.format("%d", matrix[i][j]));
                else if (matrix[i][j] < 10) builder.append(String.format("%d,  ", matrix[i][j]));
                else  builder.append(String.format("%d, ", matrix[i][j]));

                if (j + 1 == matrix.length) {
                    System.out.println(builder.toString());
                    builder = new StringBuilder();
                    builder.append("		");
                }
            }
        }
    }
}

