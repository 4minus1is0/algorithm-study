/**
 날짜: 2026/05/31
 시간: 35분
 해결 여부: X
 */
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int index = 0;
        int two = nums.length - 1;

        while (index <= two) {
            if (nums[index] == 0) {
                swap(nums, zero, index);
                zero++;
                index++;
                continue;
            }
            if (nums[index] == 2) {
                swap(nums, two, index);
                two--;
                continue;
            }
            index++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
