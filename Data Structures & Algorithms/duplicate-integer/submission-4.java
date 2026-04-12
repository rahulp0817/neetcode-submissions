class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
        
    }
}


// Brute force method

// for (int i = 0; i < nums.length; i++){
//             for (int j = i + 1; j < nums.length; j++){
//                 if (nums[i] == nums[j]) return true;
//             }
//         }

//         return false;

// HashSet<Integer> value = new HashSet<>();

//         for(int i: nums){
//             if (value.contains(i)) return true;
//             value.add(i);
//         }

//         return false;