class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> map = new HashSet<>();

        int maxVal = 0;

        for (int num : nums){
            map.add(num);
        }

        for(int num : nums){
            int streak = 0;
            int curr = num;

            while(map.contains(curr)){
                streak++;
                curr++;
            }

            maxVal = Math.max(maxVal, streak);
        }

        return maxVal;
    }
}
