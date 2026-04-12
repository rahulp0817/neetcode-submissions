class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // rules: curr window, pop value if curr val >= deque store value 
        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        Deque<Integer> q = new LinkedList<>();
        
        for (int right = 0; right < n; right++) {
            
            // 1. Remove indices out of window
            if (!q.isEmpty() && q.peekFirst() < right - k + 1) {
                q.pollFirst();
            }
            
            // 2. Maintain decreasing order
            while (!q.isEmpty() && nums[q.peekLast()] < nums[right]) {
                q.pollLast();
            }
            
            // 3. Add current index
            q.offerLast(right);
            
            // 4. Window valid → record max
            if (right >= k - 1) {
                result[right - k + 1] = nums[q.peekFirst()];
            }
        }
        
        return result;
    }
}
