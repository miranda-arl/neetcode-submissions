class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 1; i < prices.length; i++) {
            int prevIndex = i-1; 
            minValue = Math.min(minValue, prices[prevIndex]);
            int profit = prices[i] - minValue; 
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit; 
    }
}
