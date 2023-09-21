package neetcode.slidingwindow;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimeToBuyAndSellStock {

    /*
        Time complexity : O(N)
        Space complexity: O(1)
    */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int minBuyingPriceSoFar = prices[0];
        for (int i = 1; i < n; i++) {
            if (prices[i] > minBuyingPriceSoFar) {
                maxProfit = Math.max(maxProfit, prices[i] - minBuyingPriceSoFar);
            }
            minBuyingPriceSoFar = Math.min(minBuyingPriceSoFar, prices[i]);
        }
        return maxProfit;
    }

    /*
        Time complexity : O(N)
        Space complexity: O(N)
    */
    public static int maxProfitWithExtraSpace(int[] prices) {
        int n = prices.length;
        int[] maxFutureSellPrice = new int[n];
        int maxSoFar = prices[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxFutureSellPrice[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, prices[i]);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < maxFutureSellPrice[i]) {
                maxProfit = Math.max(maxProfit, maxFutureSellPrice[i] - prices[i]);
            }
        }
        return maxProfit;
    }
    /*
        Time complexity : O(N^2)
        Space complexity: O(1)
    */
    public static int maxProfitBruteForce(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[i] < prices[j]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }

    /*
        Time complexity : O(N)
        Space complexity: O(1)
    */
    public static int maxProfitUsingSlidingWindow(int[] prices) {
        int n = prices.length;
        int buyIndex = 0, sellIndex = 1;
        int maxProfit = 0;
        while (sellIndex < n) {
            if (prices[buyIndex] < prices[sellIndex]) {
                maxProfit = Math.max(maxProfit, prices[sellIndex] - prices[buyIndex]);
            } else {
                buyIndex = sellIndex;
            }
            sellIndex++;
        }
        return maxProfit;
    }
}
