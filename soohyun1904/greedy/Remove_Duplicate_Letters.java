class Solution {
    public String removeDuplicateLetters(String s) {
        char[] lists = new char[s.length()];
        int idx = -1;

        boolean[] used = new boolean[26];

        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(used[ch - 'a'] == true) continue;

            while(idx >= 0 && ch < lists[idx] && last[lists[idx] -'a'] > i) {
                used[lists[idx] - 'a'] = false;  
                idx--;
            }

            lists[++idx] = ch;
            used[ch - 'a'] = true;
        }
        return new String(lists, 0, idx + 1);
    }
}