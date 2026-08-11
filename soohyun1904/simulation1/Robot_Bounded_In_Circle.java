class Solution {
    public boolean isRobotBounded(String instructions) {
        int[] point = new int[]{0, 0};

        int[] direction = new int[]{0, 1};
        for(char ch: instructions.toCharArray()) {
            if(ch == 'G'){
                point[0] += direction[0];
                point[1] += direction[1];
            } else if (ch == 'R') {
                int newDx = direction[1];
                int newDy = -direction[0];
                direction[0] = newDx;
                direction[1] = newDy;
            } else if (ch == 'L') {
                int newDx = -direction[1];
                int newDy = direction[0];
                direction[0] = newDx;
                direction[1] = newDy;
            }
        }

        return (point[0] == 0 && point[1] == 0) 
            || !(direction[0] == 0 && direction[1] == 1);
    }
}