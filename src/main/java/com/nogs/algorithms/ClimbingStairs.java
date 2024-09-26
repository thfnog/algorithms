package com.nogs.algorithms;

public class ClimbingStairs {
    public static void main(String[] args) {
        var result = climbStairs(5);
        System.out.printf(String.valueOf(result));
    }

    /*
        Este problema consiste em encontrar o número de maneiras diferentes de subir uma escada com n degraus, onde você pode
        dar um passo de 1 ou 2 degraus. Essa é uma solução de programação dinâmica com complexidade O(n).
     */

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}