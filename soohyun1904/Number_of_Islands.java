class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public int numIslands(char[][] grid) {
        int xL = grid.length;
        int yL = grid[0].length;

        visited = new boolean[xL][yL];
        int count = 0;
        for(int i = 0; i < xL; i++){
            for(int j = 0; j < yL; j++) {
                if(!visited[i][j]&& grid[i][j] == '1') {
                    count++;
                    bfs(i, j, xL, yL, grid);
                }
            }
        }

        return count;
    }

    public void bfs(int x, int y, int xL, int yL, char[][] grid) {
        Deque<Node> que = new ArrayDeque<>();
        que.offer(new Node(x, y));
        visited[x][y] =true;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            for(int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                if(0 <= nextX && nextX < xL && 0 <= nextY && nextY < yL) {
                    if(!visited[nextX][nextY] && grid[nextX][nextY] == '1') {
                        que.offer(new Node(nextX, nextY));
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
