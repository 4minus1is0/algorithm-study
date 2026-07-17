class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalSum = 0;
        int curSum = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSum += diff;
            curSum += diff;

                if(curSum < 0){
                    curSum = 0;
                    start = i+1;
                }
            }

        if(totalSum < 0){
            return -1;
        }
        return start;
    }
}
