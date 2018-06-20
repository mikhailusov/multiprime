package com.fundingcircle.multiprime;

import java.util.ArrayList;
import java.util.List;

public class Multiprime {

    private List<Integer> primes = new ArrayList<>();

    public Multiprime() {
        // pre-populate first 10 values
//        primes.add(2);
//        primes.add(3);
//        primes.add(5);
//        primes.add(7);
//        primes.add(11);
//        primes.add(13);
//        primes.add(17);
//        primes.add(19);
//        primes.add(23);
//        primes.add(29);
    }

    public int[][] getTable(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater than zero.");
        }

        int[][] table = new int[n + 1][n + 1];
        List<Integer> primes = getPrimes(n);

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j > 0) {
                    table[i][j] = primes.get(j - 1);
                } else if (j == 0 && i > 0) {
                    table[i][j] = primes.get(i - 1);
                } else {
                    table[i][j] = table[0][j] * table[i][0];
                }
            }
        }

        return table;
    }

    private List<Integer> getPrimes(int n) {
        if (this.primes.size() >= n) {
            return this.primes;
        }

        if (this.primes.size() < 3) {
            this.primes.add(0, 2);
            this.primes.add(1, 3);
            this.primes.add(2, 5);
        }

        int k = this.primes.get(this.primes.size() - 1) + 2;

        while (this.primes.size() <= n) {
            boolean prime = true;
            for (int i = 2; i <= Math.sqrt(k); i++) {
                if (k % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                this.primes.add(k);
            }
            k++;
        }

        return primes;
    }
}
