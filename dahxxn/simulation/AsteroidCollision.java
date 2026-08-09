
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> alive = new ArrayDeque<>();

        for(int current : asteroids){
            boolean isAlive = true;

            while(isAlive){
                if(current >= 0) break;
                if(alive.isEmpty()) break;
                if(alive.peekLast() <= 0 ) break;

                int top = alive.peekLast();

                if(top < current * (-1)){
                    alive.pollLast();
                }else if(top == current * (-1)){
                    alive.pollLast();
                    isAlive = false;
                }else{
                    isAlive = false;
                }
            }

            if(isAlive){
                alive.addLast(current);
            }
        }

        int[] result = new int[alive.size()];
        int index = 0;

        for(int asteroid: alive){
            result[index++] = asteroid;
        }

        return result;
    }
}
