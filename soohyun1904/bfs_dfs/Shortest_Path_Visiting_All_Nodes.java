class Solution {
    public int shortestPathLength(int[][] graph) {
        int count = graph.length;

        boolean[][] visited = new boolean[count][1<<count];
        Deque<int []> que = new ArrayDeque<>();
        for(int i = 0; i < count; i++) {
            visited[i][1<<i] = true;
            que.offer(new int[]{i, 1<<i}); 
        }

        int target = (1 << count) - 1;
        int steps = 0;
        while(!que.isEmpty()) {
            int size = que.size();

            for(int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int node = cur[0];
                int mask = cur[1];

                if(target==mask) {
                    return steps;
                }

                for(int j = 0; j < graph[node].length; j++) {
                    int newMask = mask | (1 << graph[node][j]);

                    if(visited[graph[node][j]][newMask]) continue;

                    visited[graph[node][j]][newMask] = true;
                    que.add(new int[] {graph[node][j], newMask});
                }
            }

            steps++;
        }
        return -1;
    }
}