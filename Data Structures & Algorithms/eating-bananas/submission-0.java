class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
         // find maximum pile
        for(int pile: piles) {
            high = Math.max(high, pile);
        }

        while(low < high) {
            int mid = low + (high - low) / 2;
        
            int totalhrs = 0;

            // calculate hours needed with speed = mid
            for(int pile: piles) {
                totalhrs += (pile + mid - 1) / mid;
            }

            // if possible within h hours
            if(totalhrs <= h) {
                high = mid;
            }
            else {
                low = mid + 1;
            } 
        }

        return low;
    }
}
