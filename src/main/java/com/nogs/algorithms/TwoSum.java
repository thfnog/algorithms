package com.nogs.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] twoSum = findTwoSum(nums, 9);
        System.out.printf(Arrays.toString(twoSum));
    }

    /*
        Esse problema pede que, dado um array de números e um valor alvo, você encontre dois números no array cuja soma
        seja igual ao alvo. Usamos um HashMap para otimizar a solução e obter um tempo de execução de O(n).
     */

    public static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // Valor -> Índice

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Retorna os índices
            }
            map.put(nums[i], i); // Adiciona o número e seu índice ao mapa
        }

        throw new IllegalArgumentException("Nenhuma solução encontrada");
    }
}