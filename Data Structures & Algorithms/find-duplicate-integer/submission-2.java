class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        // detect cycle 
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow); // use while loop to run atleast once in case in starting
    
        // entrance
        slow = nums[0];

        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow; 
    }
}
