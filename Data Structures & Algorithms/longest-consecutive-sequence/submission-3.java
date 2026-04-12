class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        // added in hashset
        for(int num: nums) {
            set.add(num);
        }

        int maxValue = 0;
        for(int num: set){
           // starts from sequence
            if(!set.contains(num - 1)) {
                int streak = 1;
                int curr = num;

                while(set.contains(curr + 1)) {
                    streak++;
                    curr++;
                }

                maxValue = Math.max(maxValue, streak);
            }

        }

        return maxValue;
    }
}