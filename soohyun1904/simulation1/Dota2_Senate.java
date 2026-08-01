import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> Rque = new ArrayDeque<>();
        Queue<Integer> Dque = new ArrayDeque<>();

        for(int i = 0; i < senate.length(); i++){
            char word = senate.charAt(i);
            if(word == 'R') {
                Rque.offer(i);
            }
            else{
                Dque.offer(i);
            }
        }
    
        while(!Rque.isEmpty() && !Dque.isEmpty()) {
            int r = Rque.poll();
            int d = Dque.poll();

            if(r > d) {
                Dque.offer(d+senate.length());
            }
            else{
                Rque.offer(r+senate.length());
        
            }
        }

        if(Rque.isEmpty()) {
            return "Dire";
        }

        return "Radiant";
    }
}
 {
    
}
