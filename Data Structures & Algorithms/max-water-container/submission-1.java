class Solution {
    public int maxArea(int[] heights) {
        
        int leftBar = 0;
        int rightBar = heights.length - 1;
        int maxValue = 0;

        while (leftBar < rightBar) {
            int width = rightBar - leftBar;
            int ht = Math.min(heights[leftBar], heights[rightBar]);
            int area = width * ht;
            maxValue = Math.max(area, maxValue);

            if(heights[leftBar] < heights[rightBar]){
                leftBar++;
            } else { 
                rightBar--;
            }
        }

        return maxValue;
    }
}
























// int right = heights.length - 1;
//         int left  = 0;
//         int ans = 0;

//         while(left < right){
//             int width = right - left;
//             int height = Math.min(heights[left], heights[right]); 
//             int area = width * height;
//             ans = Math.max(ans, area);

//             if (heights[left] < heights[right]){
//                 left++;
//             }
//             else {
//                 right--;
//             }
//         }

//         return ans;