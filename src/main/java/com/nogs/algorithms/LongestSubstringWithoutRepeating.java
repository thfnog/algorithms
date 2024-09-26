package com.nogs.algorithms;

import java.util.*;

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        var substring = lengthOfLongestSubstring("abcabcbb");
        System.out.printf(String.valueOf(substring));
    }

    /*
        Usamos a técnica de janela deslizante para encontrar a substring mais longa sem caracteres repetidos.
        A complexidade é O(n).
     */

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}