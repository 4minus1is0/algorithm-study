class Solution {
    int[] dx = {-1, -1, 0, 1, 1, 1, 0 , -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tmp[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                int nCount = 0;
                for(int k = 0; k < 8; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                        if (tmp[ni][nj] == 1) {
                            nCount++;
                        }
                    }
                }


                if (tmp[i][j] == 1) {
                    if (nCount < 2 || nCount > 3) {
                        board[i][j] = 0;
                    }
                } else {
                    if (nCount == 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }
}