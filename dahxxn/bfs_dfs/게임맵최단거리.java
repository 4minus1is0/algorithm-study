import java.util.*;
import java.io.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int startX, startY = 0;

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];
        distance[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0 ; i<4 ; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >=n || nextY >= m) continue;
                if(visited[nextX][nextY] || maps[nextX][nextY] == 0) continue;

                visited[nextX][nextY] = true;
                distance[nextX][nextY] = distance[x][y] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }

        return distance[n-1][m-1] == 0 ? -1 : distance[n-1][m-1];
    }
}
