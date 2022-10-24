package com.wayne;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 * @author wayne
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        System.out.println(maxProfitA(arr));
    }

    /**
     * 时间复杂度高
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        final int length = prices.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                if(prices[j]-prices[i] > maxProfit){
                    maxProfit = prices[j]-prices[i];
                }
            }
        }
        return maxProfit;
    }

    public static int maxProfitA(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        final int length = prices.length;
        for (int i = 0; i < length; i++) {
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else if(prices[i]-minPrice > maxProfit){
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}
