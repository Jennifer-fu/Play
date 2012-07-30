/*
* 有N种物品和一个容量为V的背包，每种物品都有无限件可用。
* 第i件物品的体积是w[i]，价值是m[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
*
* f[i][v] = max{f[i-1][v-k*w[i]]+k*m[i]} (0<=k*w[i]<=V)
*
* 现存在一堆面值为 V1、V2、V3 … 个单位的硬币，问最少需要多少个硬币才能找出总值为 M 个单位的零钱
* */
public class P02 {

    public int normal(int[] money, int[] weights, int i, int leftWeight) {
        int max = 0;
        if (i == 0) {
            return (leftWeight / weights[0]) * money[0];
        }
        for (int k = 0; k < leftWeight / weights[k]; k++) {
            int temp = normal(money, weights, i - 1, leftWeight - k * weights[i]) + k * money[i];
            if (temp > max) max = temp;
        }
        return max;
    }

    public int recursive(int[] coins, int money, int i, int min){
        if(i==0 && money%coins[0]==0)return  money/coins[0];
        if(i==0 && money%coins[0]!=0) return -1;

        for (int k = 0; k <= money / coins[i]; k++) {
            int resultWithKCoinsI = recursive(coins, money - k * coins[i], i - 1, min) + k;
            if(resultWithKCoinsI <min)min = resultWithKCoinsI;
        }
        return min;
    }
}
