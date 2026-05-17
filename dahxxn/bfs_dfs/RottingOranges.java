class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};

    public int orangesRotting(int[][] grid) {
        if(hasNoFresh(grid)) return 0;

        // 썩은 오렌지 넣기 -> 꺼내서 사방으로 전파 -> 매 라운드마다 종료 조건 체크
        // 그렇다면 불가능 검증은?
        Queue<int[]> queue = getInitQueue(grid);
        int time = 0;

        while(!queue.isEmpty()){
            int count = queue.size();
            boolean flag = false;

            for(int i = 0 ; i<count ; i++){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for(int d = 0 ; d<4 ; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[0].length) continue;

                    if(grid[nx][ny] != 1) continue;

                    grid[nx][ny] = 2;
                    queue.offer(new int[]{nx,ny});
                    flag = true;
                }
            }

            if(flag){
                time++;
            }
        }

        // bfs 이후, 아직 오렌지 남아있으면 -1
        if(isFreshRemain(grid)){ return -1; }
        return time;

    }

    public boolean isFreshRemain(int[][] grid){
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 1) return true;
            }
        }
        return false;
    }

    public boolean hasNoFresh(int[][] grid){
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                if(grid[i][j] == 1) return false;
            }
        }
        return true;
    }

    public Queue<int[]> getInitQueue(int[][] grid){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0 ; j<grid[0].length; j++){
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
            }
        }
        return queue;
    }
}
