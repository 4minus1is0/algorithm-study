class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; 
        Arrays.fill(dp, amount + 1); 

        dp[0] = 0; 

        for(int target = 1; target <= amount; target++){
            for(int coin : coins){
                if(target >= coin){
                    dp[target] = Math.min(dp[target], dp[target-coin] + 1); 
                }
            }
        }

        if(dp[amount] == amount+1) return -1; 
        return dp[amount]; 
    }
}
