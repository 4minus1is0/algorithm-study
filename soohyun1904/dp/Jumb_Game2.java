// 재귀
class Solution {
    private int min = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, 0, 0);
        return min;
    }

    private void backtrack(int[] nums, boolean[] visited, int idx, int count) {
        if(idx >= nums.length){
            return;
        }
 
        if(idx==nums.length -1){
            min = Math.min(min, count);
            return;
        }

        if(visited[idx]) return;

        visited[idx] = true;
        for(int i = 1; i <= nums[idx]; i++){
            backtrack(nums, visited, idx+i, count+1);
        }

        visited[idx] = false;
    }
}


//DP
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);          // -1 = 아직 계산 안 함
        return solve(nums, 0, dp);    // 인덱스 0에서 끝까지 = 정답
    }

    private int solve(int[] nums, int idx, int[] dp) {
        if (idx >= nums.length - 1) {     // 끝에 도달 → 더 점프 필요 없음
            return 0;
        }

        if (dp[idx] != -1) return dp[idx]; // 이미 계산했으면 재사용

        int best = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[idx] && idx + j < nums.length; j++) {
            int sub = solve(nums, idx + j, dp);
            if (sub != Integer.MAX_VALUE) {
                best = Math.min(best, sub + 1);   // 한 번 점프 + 그 이후 최소
            }
        }
        return dp[idx] = best;            // 저장하고 반환
    }
}