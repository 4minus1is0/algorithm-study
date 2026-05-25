class Solution {
    int[] nodeGroup;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; // 0~n-1
        nodeGroup = new int[n]; // 1 혹은 -1, 그룹 배분 전은 0

        for(int i = 0 ; i<n ; i++){
            if(nodeGroup[i] != 0) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            nodeGroup[i] = 1;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                int[] nextNodes = graph[cur];

                int curGroup = nodeGroup[cur];
                int nextGroup = curGroup * (-1);

                for(int next : nextNodes){
                    if (nodeGroup[next] == 0) {
                        nodeGroup[next] = nextGroup;
                        queue.offer(next);
                    } else if (nodeGroup[next] == curGroup) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
