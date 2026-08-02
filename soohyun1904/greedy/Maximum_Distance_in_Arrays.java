class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int curMin = arrays.get(0).get(0);
        int curMax = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int min = array.get(0);
            int max = array.get(array.size() - 1);

            result = Math.max(result, Math.abs(max - curMin));
            result = Math.max(result, Math.abs(curMax - min));

            curMin = Math.min(curMin, min);
            curMax = Math.max(curMax, max);
        }

        return result;
    }
}
