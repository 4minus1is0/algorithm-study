class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->
                Integer.compare(a[1], b[1])
        ); // end 기준으로 정렬

        int removeCount = 0;
        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart < previousEnd) {
                removeCount++;
            } else {
                previousEnd = currentEnd;
            }
        }

        return removeCount;
    }
}
