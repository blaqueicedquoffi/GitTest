package com.syntax;

class Main {


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
    public static void main(String[] args)
    {
        long start2 = System.currentTimeMillis();
        int size=1000;
        int [][] matrixA=new int[size][size];
        int [][] matrixB=new int[size][size];
        matrixA=initMatrix(matrixA);
        matrixB=initMatrix(matrixB);
        multiplyMatrix(matrixA,matrixB);
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start2);
        System.out.println("new changes are being made to" +
                "this code in feature branch");

    }
}
