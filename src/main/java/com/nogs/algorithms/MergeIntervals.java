package com.nogs.algorithms;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        var results = merge(intervals);
        Arrays.stream(results).forEach(r -> System.out.printf(Arrays.toString(r)));
    }

    /*
        Dado um conjunto de intervalos, o objetivo é mesclar intervalos sobrepostos. Ordenamos os intervalos e então os
        mesclamos sequencialmente. A complexidade é O(n log n) devido à ordenação.
     */

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // Ordena pelos tempos de início
        List<int[]> merged = new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Se há sobreposição, mescla os intervalos
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Caso contrário, adiciona um novo intervalo
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}