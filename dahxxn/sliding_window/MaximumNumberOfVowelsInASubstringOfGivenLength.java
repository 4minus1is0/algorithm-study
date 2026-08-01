class Solution {

    public int maxVowels(String s, int k) {
        int left = 0;
        int vowelCnt = 0;
        int max = 0;

        for(int right = 0; right < s.length(); right++){
            if(isVowel(s.charAt(right))){
                vowelCnt++;
            }

            if(right - left + 1 > k){
                if(isVowel(s.charAt(left))){
                    vowelCnt--;
                }
                left++;
            }

            if(right - left + 1 == k){
                max = Math.max(max, vowelCnt);
            }

        }

        return max;
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
