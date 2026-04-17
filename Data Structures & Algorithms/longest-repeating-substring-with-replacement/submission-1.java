class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;
        int maxfreq = 0;

        for(int right = 0; right < s.length(); right++) {
            
            char rightchar = s.charAt(right); // inside
            map.put(rightchar, map.getOrDefault(rightchar, 0) + 1); // freq
            maxfreq = Math.max(maxfreq, map.get(rightchar));

            if((right-left+1) - maxfreq > k) {
                char leftchar = s.charAt(left);
                map.put(leftchar, map.get(leftchar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
        
    }
}
