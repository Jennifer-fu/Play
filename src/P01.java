/*
*有N件物品和一个容量为V的背包。第i件物品的重量是w[i]，价值是m[i]。求解将哪些物品装入背包可使价值总和最大
*f[i][v] = max{f[i-1][v],f[i-1][v-w[i]]+m[i]]}
*
* 输入两个整数n和m，从数列1、2、3...n中随意取几个数，使其和等于m，要求将其所有可能的组合列出来
* */

import java.util.ArrayList;
import java.util.List;

public class P01 {

    public int normal(int[] money, int[] weights, int i, int leftWeight) {
        if (i == 1) {
            if (weights[1] > leftWeight) return 0;
            return money[1];
        }
        if (weights[i] > leftWeight) return normal(money, weights, i - 1, leftWeight);
        return Math.max(
                normal(money, weights, i - 1, leftWeight),
                normal(money, weights, i - 1, leftWeight - weights[i] + weights[i]));
    }

    public List<List<Integer>> calculate(int n, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (n == 1) {
            if (sum != 1) {
                return result;
            }
            List<Integer> integers = new ArrayList<Integer>();
            integers.add(1);
            result.add(integers);
            return result;
        }
        if (n == sum) {
            List<Integer> integers = new ArrayList<Integer>();
            integers.add(n);
            result.add(integers);
        }
        if (n > sum) result.addAll(calculate(n - 1, sum));
        else {
            result.addAll(calculate(n - 1, sum));
            List<List<Integer>> minusNResult = calculate(n - 1, sum - n);
            for (List<Integer> integers : minusNResult) {
                integers.add(n);
            }
            result.addAll(minusNResult);
        }
        return result;
    }

    public static void main(String[] args) {
        P01 p01 = new P01();
        List<List<Integer>> result = p01.calculate(10, 16);
        for (List<Integer> integers : result) {
            System.out.println(integers.size() + ":");
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println("\n--------------");
        }
    }
}
