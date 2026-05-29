package bfs_dfs;
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> lists = new ArrayList<>();
        for(int i =0 ; i<n;i++){
            lists.add(new ArrayList<>());
        }
        for(int[] flight: flights) {
          lists.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        return bfs(src, dst, k, lists);
    }
private int bfs(int src, int dst, int k, List<List<int[]>> lists) {
    int[] minCost = new int[lists.size()];
    Arrays.fill(minCost, Integer.MAX_VALUE);
    
    Deque<int[]> que = new ArrayDeque<>();
    que.offer(new int[]{src, 0, 0}); 
    int answer = Integer.MAX_VALUE;
    
    while (!que.isEmpty()) {
        int[] cur = que.poll();
        int city = cur[0];
        int cost = cur[1];
        int stop = cur[2];
        
        if (city == dst) {
            answer = Math.min(answer, cost);
            continue;
        }
        if (stop > k) continue;
        
        for (int[] next : lists.get(city)) {
            int newCost = cost + next[1];
            if (newCost >= minCost[next[0]]) {
                continue;
            }
            minCost[next[0]] = newCost;
            que.offer(new int[]{next[0], newCost, stop + 1});
        }
    }
    
    return answer == Integer.MAX_VALUE ? -1 : answer;
}

   
}