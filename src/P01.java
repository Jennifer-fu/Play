/*
*有N件物品和一个容量为V的背包。第i件物品的体积是w[i]，价值是m[i]。求解将哪些物品装入背包可使价值总和最大
*f[i][v] = max{f[i-1][v],f[i-1][v-w[i]]+m[i]]}
*
* 输入两个整数n和m，从数列1、2、3...n中随意取几个数，使其和等于m，要求将其所有可能的组合列出来
* */

import java.util.*;

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

    public List<List<Integer>> recursive(int n, int sum) {
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

        if (n > sum) result.addAll(recursive(n - 1, sum));
        else {
            if (n == sum) {
                List<Integer> integers = new ArrayList<Integer>();
                integers.add(n);
                result.add(integers);
            }
            result.addAll(recursive(n - 1, sum));
            List<List<Integer>> minusNResult = recursive(n - 1, sum - n);
            for (List<Integer> integers : minusNResult) {
                integers.add(n);
            }
            result.addAll(minusNResult);
        }
        return result;
    }

    /*
    * 二维数组实现，计算出所有二维数组的值，初始化很重要
    * */
    public List<List<Integer>> noRecursive(int n, int sum) {
        Map<Map.Entry<Integer, Integer>, List<List<Integer>>> midResult = new HashMap<Map.Entry<Integer, Integer>, List<List<Integer>>>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == j && i > 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
                    lists.add(list);
                    midResult.put(new AbstractMap.SimpleEntry(i, j), lists);
                } else {
                    midResult.put(new AbstractMap.SimpleEntry(i, j), new ArrayList<List<Integer>>());
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                midResult.get(new AbstractMap.SimpleEntry(i, j)).addAll(midResult.get(new AbstractMap.SimpleEntry(i - 1, j)));
                if (i > j) continue;
                ArrayList<List<Integer>> needAddIMidResult = deepCopy(midResult.get(new AbstractMap.SimpleEntry(i - 1, j - i)));
                midResult.get(new AbstractMap.SimpleEntry(i, j)).addAll(needAddIMidResult);

                for (List<Integer> integers : needAddIMidResult) {
                    integers.add(i);
                }
            }
        }
        return midResult.get(new AbstractMap.SimpleEntry(n, sum));
    }

    /*
    * optimize 空间复杂度，降为1维数组，即:
    * for i=1..N
    * for v=V..0
    *    f[v]=max{f[v],f[v-c[i]]+w[i]};
    * V需倒序
    * */

    public List<List<Integer>> noRecursiveOptimization(int n, int sum) {
        HashMap<Integer, List<List<Integer>>> midResult = new HashMap<Integer, List<List<Integer>>>();
        for (int i = 0; i <= sum; i++) {
            midResult.put(i, new ArrayList<List<Integer>>());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = sum; j > 0; j--) {
//                midResult.get(j).addAll(midResult.get(j));  //not used this line any more
                if (j < i) continue;
                if (j == i) {
                    ArrayList<Integer> integers = new ArrayList<Integer>();
                    integers.add(i);
                    ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
                    lists.add(integers);
                    midResult.get(j).addAll(lists);
                } else {
                    List<List<Integer>> needAddIMidResult = deepCopy(midResult.get(j - i));
                    midResult.get(j).addAll(needAddIMidResult);
                    for (List<Integer> integers : needAddIMidResult) {
                        integers.add(i);
                    }
                }
            }
        }
        return midResult.get(sum);
    }


    private ArrayList<List<Integer>> deepCopy(List<List<Integer>> src) {
        ArrayList<List<Integer>> desc = new ArrayList<List<Integer>>();
        for (List<Integer> list : src) {
            ArrayList<Integer> integers = new ArrayList<Integer>(list);
            Collections.copy(integers, list);
            desc.add(integers);
        }
        return desc;
    }

    public List<List<Integer>> calculate(int n, int sum) {
//        return recursive(n,sum);
//        return noRecursive(n, sum);
        return noRecursiveOptimization(n, sum);
    }

    public static void main(String[] args) {
        P01 p01 = new P01();
        long start = System.currentTimeMillis();
        List<List<Integer>> result = p01.calculate(10, 16);
        System.out.println(System.currentTimeMillis() - start);
        for (List<Integer> integers : result) {
            System.out.println(integers.size() + ":");
            for (Integer integer : integers) {
                System.out.print(integer + ",");
            }
            System.out.println("\n--------------");
        }
    }
}
