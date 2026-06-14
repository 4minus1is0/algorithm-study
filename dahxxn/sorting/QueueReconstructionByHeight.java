class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // people[i] = {h,k} : h는 키, k는 본인보다 크거나 같은 사람 수

        Arrays.sort(people, (one, two) -> {
            if(one[0] != two[0]){
                return Integer.compare(two[0],one[0]);
            }
            return Integer.compare(one[1], two[1]);
        });

        List<int[]> result = new ArrayList<>();
        for(int[] person : people){
            result.add(person[1], person);
        }

        int[][] answer = new int[people.length][];
        for(int i = 0 ; i < answer.length ; i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
