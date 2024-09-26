package com.nogs.algorithms;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        var result = wordBreak("leetcode", Arrays.asList("leet", "code"));
        System.out.printf(String.valueOf(result));
    }

    /*
        Verifica se uma string pode ser segmentada em palavras válidas de um dicionário. Utilizamos programação dinâmica com
        um Set para armazenar o dicionário. A complexidade é O(n²), onde n é o tamanho da string.
     */

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}