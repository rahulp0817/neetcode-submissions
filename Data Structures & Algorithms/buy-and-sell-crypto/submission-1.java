class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int maxValue = 0;
        for(int i = 0; i < prices.length; i++){
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxValue = Math.max(profit, maxValue);
            }
            else {
                buyPrice = prices[i];
            }
        }
        return maxValue;
    }
}
