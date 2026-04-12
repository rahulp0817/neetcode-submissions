class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        // added in hashset
        for(int num: nums) {
            set.add(num);
        }

        int maxValue = 0;
        for(int num: nums){
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



























//  Set<Integer> map = new HashSet<>();

//         int maxVal = 0;

//         for (int num : nums){
//             map.add(num);
//         }

//         for(int num : nums){
//             int streak = 0;
//             int curr = num;

//             while(map.contains(curr)){
//                 streak++;
//                 curr++;
//             }

//             maxVal = Math.max(maxVal, streak);
//         }

//         return maxVal;