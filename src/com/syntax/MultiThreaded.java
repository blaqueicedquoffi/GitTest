package com.syntax;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreaded {
    static void multiplyMatrix( int[][] a, int[][] b)
    {
        int[][] C = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < b.length; k++)
                    C[i][j] += a[i][k] * b[k][j];
            }
        }

    }

    public static int[][] initMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=1;
            }
        }
        return matrix;
    }

    public static void main(String[] args) throws InterruptedException {

        long start2 = System.currentTimeMillis();
        int numberOfThreads=16;
        int size=1000/numberOfThreads;
        int [][] matrixA = new int[size][size];
        int [][] matrixB = new int[size][size];
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i=0;i<numberOfThreads;i++) {

            es.execute(() -> {
                initMatrix(matrixA);
                initMatrix(matrixB);
                multiplyMatrix(matrixA, matrixB);
            });
        }
        es.shutdown();
        boolean finished = es.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(finished);
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);

    }
}
