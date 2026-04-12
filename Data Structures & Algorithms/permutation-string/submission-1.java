class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1count = new int[26];
        int[] window = new int[26];
        
        // store s1 frequency
        for(char c : s1.toCharArray()){
            s1count[c - 'a']++;
        }

        int k = s1.length();
        
        // s1 size window freq
        for(int i = 0; i < k; i++){
            window[s2.charAt(i) - 'a']++;
        }
        
        // check it is equal or not
        if(Arrays.equals(s1count, window)) return true;

        // sliding
        for (int i = k; i < s2.length(); i++){
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - k) - 'a']--;
            if(Arrays.equals(s1count, window)) return true;
        }

        return false;

    }
}
