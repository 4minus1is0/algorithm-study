/**
 날짜: 2026/06/14
 풀이 시간: 35분
 해결 여부: O -> Integer.compare() 문법 헷갈림
 */

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        if (n == 1) return 1;

        int current = 0;
        int nextIdx = 1;
        int result = n;
        while (nextIdx < n) {
            int a = intervals[current][0];
            int b = intervals[current][1];
            int c = intervals[nextIdx][0];
            int d = intervals[nextIdx][1];

            if (a <= c && b >= d) {
                nextIdx++;
                result--;
                continue;
            }
            if (a == c && b < d) {
                result--;
            }
            current = nextIdx;
            nextIdx++;
        }

        return result;
    }
}

// AI 리팩터링

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int count = 0;
        int maxEnd = 0;

        for (int[] interval : intervals) {
            int end = interval[1];

            if (end > maxEnd) {
                count++;
                maxEnd = end;
            }
        }
        return count;
    }
}
