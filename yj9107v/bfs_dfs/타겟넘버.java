class Solution {

    private final static int[] dx = {1, -1}; // +, - 여부

    private int[] numbers; // 숫자가 담긴 배열
    private int target; // 타겟 넘버
    private int answer = 0; // 결과값

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;

        dfs(0, 0);

        return answer;
    }

    private void dfs(int sum, int idx) {
        if (idx == numbers.length) { // 배열을 다 탐색했을 경우 return
            if (sum == target) { // 합계가 target인 경우 결과값 개수 증가
                answer++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            dfs(sum + numbers[idx] * dx[i], idx + 1);
        }
        return;
    }

}
