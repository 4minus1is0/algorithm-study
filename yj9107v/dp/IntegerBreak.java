/**
 날짜: 2026/05/25
 풀이 시간: 13분
 해결 여부: 실패 (어떻게 풀어야 할 지 감이 안 잡힘)
 */

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i - j));
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }

        return dp[n];
    }
}
