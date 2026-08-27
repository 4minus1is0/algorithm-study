class Solution {
    int min = Integer.MAX_VALUE;

    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int i = 0;
        int n = nums.length;

        while (currentSum < target && i < n) {
            currentSum += nums[i];
            i++;
        }

        if (currentSum < target) {
            return 0;
        }

        min = i;

        int start = 0;

        while (true) {
            while (currentSum >= target) {
                min = Math.min(min, i - start);
                currentSum -= nums[start];
                start++;
            }

            if (i == n) {
                break;
            }

            currentSum += nums[i];
            i++;
        }

        return min;
    }
}
