class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);

        // 인접한 두 집을 털지 않으면서, 최대 금액 털기
        int[] dp = new int[nums.length + 1];

        // i 집을 털었다면, i-1, i+1 집을 털 수 없음
        // 현재 집을 건너 뛰는 경우 i-1까지의 턴 금액 그대로
        // 현재 집을 터는 경우 i-2까지 금액 + i번째 금액 값
        // 위 두개의 값 중 더 큰것을 택

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i<nums.length ; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
