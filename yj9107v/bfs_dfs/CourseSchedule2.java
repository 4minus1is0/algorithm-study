import java.util.*;

class Solution {

    private static final int NOT_VISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    private List<List<Integer>> graph;
    private int[] visitStatus;
    private List<Integer> order;
    private boolean hasCycle;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = createGraph(numCourses, prerequisites);
        visitStatus = new int[numCourses];
        order = new ArrayList<>();
        hasCycle = false;

        for (int course = 0; course < numCourses; course++) {
            if (visitStatus[course] == NOT_VISITED) {
                dfs(course);
            }

            if (hasCycle) {
                return new int[0];
            }
        }

        Collections.reverse(order);
        return toArray(order);
    }

    private List<List<Integer>> createGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int course = 0; course < numCourses; course++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            graph.get(prerequisiteCourse).add(course);
        }

        return graph;
    }

    private void dfs(int course) {
        if (visitStatus[course] == VISITING) {
            hasCycle = true;
            return;
        }

        if (visitStatus[course] == VISITED) {
            return;
        }

        visitStatus[course] = VISITING;

        for (int nextCourse : graph.get(course)) {
            dfs(nextCourse);

            if (hasCycle) {
                return;
            }
        }

        visitStatus[course] = VISITED;
        order.add(course);
    }

    private int[] toArray(List<Integer> order) {
        int[] result = new int[order.size()];

        for (int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        }

        return result;
    }
}
