class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); 
        int result = 1;
        for(int i = 1; i <nums.length; i++) {
            int max = dp[i];
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            result  = Math.max(result, dp[i]);
        }

        return result;
    }
}

