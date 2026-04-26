class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // store the result array
        int[] result = new int[n - k + 1];

        // Deque
        Deque<Integer> deque = new ArrayDeque<>();

        for(int right = 0; right < n; right++) {

            // Remove indices outside current window
            while(!deque.isEmpty() && deque.peekFirst() < right - k + 1) {
                deque.pollFirst();
            }

            // Maintain decreasing order and remove if smaller then new element
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }

            // Add current index from back bcz new element comes from back
            deque.offerLast(right);

            // window formed; valid window 
            if(right >= k - 1) {
                result[right - k + 1] = nums[deque.peekFirst()];
            }
        } 

        return result;
    }
}







































// class Solution {

//     public int[] maxSlidingWindow(int[] nums, int k) {

//         int n = nums.length;

//         int[] result = new int[n - k + 1];

//         Deque<Integer> deque = new ArrayDeque<>();

//         for (int right = 0; right < n; right++) {

//             // Remove indices outside current window
//             while (!deque.isEmpty() &&
//                     deque.peekFirst() < right - k + 1) {

//                 deque.pollFirst();
//             }

//             // Maintain decreasing order
//             while (!deque.isEmpty() &&
//                     nums[deque.peekLast()] <= nums[right]) {

//                 deque.pollLast();
//             }

//             // Add current index
//             deque.offerLast(right);

//             // Window formed
//             if (right >= k - 1) {

//                 result[right - k + 1] =
//                         nums[deque.peekFirst()];
//             }
//         }

//         return result;
//     }
// }  