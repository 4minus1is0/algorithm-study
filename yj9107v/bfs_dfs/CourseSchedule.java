class Solution {

    private boolean[] visited;
    private List<List<Integer>> node = new ArrayList<>();
    private boolean result = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            node.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            node.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            visited = new boolean[numCourses];
            dfs(i, i);
        }

        return result;
    }

    private void dfs(int n, int start) {
        if (node.get(n).isEmpty()) return;

        visited[n] = true;

        for (int i : node.get(n)) {
            if (start == i) {
                result = false;
                return;
            }
            if (visited[i]) continue;
            dfs(i, start);
        }

        return;
    }
}
