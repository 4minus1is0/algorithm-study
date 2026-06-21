/**
 * 날짜: 2026/06/21
 * 풀이 시간: 25분
 * 해결 여부: O -> 리팩터링 필요
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            copyArray(nums1, nums2);
        }
        if (n == 0) return;

        int idx1 = 0;
        int idx2 = 0;
        int idx = 0;
        int[] result = new int[m + n];

        while (idx1 != m || idx2 != n) {
            if (idx1 >= m) {
                result[idx++] = nums2[idx2++];
                continue;
            }
            if (idx2 >= n) {
                result[idx++] = nums1[idx1++];
                continue;
            }

            int a = nums1[idx1];
            int b = nums2[idx2];

            if (a <= b) {
                result[idx++] = a;
                idx1++;
                continue;
            }
            result[idx++] = b;
            idx2++;
        }

        copyArray(nums1, result);
    }

    private void copyArray(int[] nums1, int[] result) {
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result[i];
        }
    }
}

/**
 * 리팩터링 관점
 * - 공간 복잡도 개선, 불필요한 예외 처리, 메서드 제거
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m - 1;
        int idx2 = n - 1;
        int idx = m + n - 1;

        while (idx2 >= 0) {
            if (idx1 >= 0 && nums1[idx1] > nums2[idx2]) {
                nums1[idx--] = nums1[idx1--];
                continue;
            }

            nums1[idx--] = nums2[idx2--];
        }
    }
}
