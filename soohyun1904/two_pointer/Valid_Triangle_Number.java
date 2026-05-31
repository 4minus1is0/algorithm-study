class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int maxL = nums.length-1;

        int count = 0;

        while(maxL>1){
            int left = 0;
            int right = maxL-1;
            while(left<right){
                if(nums[maxL]<nums[left]+nums[right]){
                    count+=(right-left);
                    right--;
                }
                else {
                    left++;
                }
            }
            maxL--;
        }
        return count;
    }
}