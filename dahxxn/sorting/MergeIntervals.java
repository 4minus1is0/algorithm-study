class Solution {
    public int[][] merge(int[][] intervals) {

        // start 기준으로 정렬
        // end와 다음의 start 비교, end > start 이면 다음과 병합

        Arrays.sort(intervals, (one, other) -> one[0] - other[0]);

        int[] previous = intervals[0];
        int[][] result = new int[intervals.length][2];
        int index = 0;

        for(int i = 1; i<intervals.length ; i++){
            int[] current = intervals[i];
            if(previous[1] >= current[0]){
                //merge
                previous[1] = Math.max(previous[1], current[1]);
            }else{
                result[index][0] = previous[0];
                result[index][1] = previous[1];
                previous = current;
                index++;
            }
        }
        result[index][0] = previous[0];
        result[index][1] = previous[1];
        return Arrays.copyOf(result, index+1);
    }
}
