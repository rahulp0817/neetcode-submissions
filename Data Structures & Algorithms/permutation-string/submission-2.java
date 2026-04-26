class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;

        // initilize the array
        int[] s1count = new int[26];
        int[] window = new int[26];

        //iterate the loop
        for(char ch: s1.toCharArray()) {
            s1count[ch - 'a']++;
        }

        int k = s1.length();

        // iterate loop on window size
        for(int i = 0; i < k; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        // check
        if(Arrays.equals(s1count, window)) return true;

        // sliding window and remove old
        for(int i = k; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;
            window[s2.charAt(i - k) - 'a']--;
            if(Arrays.equals(s1count, window)) return true;
        }

        return false;

    }
}




