/**
 날짜: 2026/08/03
 시간: 26분
 풀이: O
 */

class Solution {

    private int[] valueToAdd;
    private int length;

    public int[] twoSum(int[] numbers, int target) {
        length = numbers.length;
        valueToAdd = new int[length];

        calculateValueToAdd(numbers, target);

        int[] result = new int[2];
        int start = 0;
        int last = length - 1;

        for (int i = 0; i < length; i++) {
            if (valueToAdd[last] == numbers[start]) {
                result[0] = start + 1;
                result[1] = last + 1;
                break;
            }
            if (valueToAdd[last] < numbers[start]) {
                last--;
                continue;
            }
            start++;
        }

        return result;
    }

    private void calculateValueToAdd(int[] numbers, int target) {
        for (int i = 0; i < length; i++) {
            valueToAdd[i] = target - numbers[i];
        }
    }
}
