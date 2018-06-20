package com.fundingcircle.multiprime;

public class App {

    public static void main(String[] args) {
        Multiprime multiprime = new Multiprime();
        int[][] table = multiprime.getTable(10);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.printf("%5s", table[i][j]);
            }
            System.out.println();
        }
    }
}
