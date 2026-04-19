class Solution {
    public String minWindow(String s, String t) {
        // declare the frequency array
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for(char ch: t.toCharArray()) {
            mapT[ch]++;
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        int startIndex = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            mapS[ch]++;

            // character is there 
            if(mapT[ch] > 0 && mapS[ch] <= mapT[ch]) {
                count++;
            }

            // expand window
            while(count == t.length()) {
                // window size should be smaller then minLength
                if((right - left + 1) < minLength) {
                    minLength = right - left + 1; // minLength updated
                    startIndex = left; // startIndex from left updated
                }

                // remove left
                char leftchar = s.charAt(left);
                mapS[leftchar]--;

                // After removing is it broken window; required length is there
                if(mapT[leftchar] > 0 && mapS[leftchar] < mapT[leftchar]) {
                    count--;
                }
                
                // shrink window
                left++;

            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}