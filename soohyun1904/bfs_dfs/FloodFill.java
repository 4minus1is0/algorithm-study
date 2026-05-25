package bfs_dfs;


class Solution {
    static boolean[][] visited;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited = new boolean[image.length][image[0].length];
        int target = image[sr][sc];
        if(target == color) {
            return image;
        }
        bfs(sr, sc, color, target, image);
        return image;
    }

    void bfs(int x, int y, int color, int target, int[][] image) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;
		while (!que.isEmpty()) {
		    int[] cur = que.poll();
	        int curRow = cur[0];
		    int curCol = cur[1];
            image[curRow][curCol] = color;
        
		
	        for (int i = 0; i < 4; i++) {		
                int nextRow = curRow + dr[i];
	            int nextCol = curCol + dc[i];
	            if (0 <= nextRow && nextRow < image.length && 0 <= nextCol && nextCol<image[0].length) {
                    if (!visited[nextRow][nextCol] && image[nextRow][nextCol] == target) {
		                que.offer(new int[]{nextRow, nextCol});
    					visited[nextRow][nextCol] = true;
		            }
		        }
		    }
		}
    }
}