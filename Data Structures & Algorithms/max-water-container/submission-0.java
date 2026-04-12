class Solution {
    public int maxArea(int[] heights) {
        int right = heights.length - 1;
        int left  = 0;
        int ans = 0;

        while(left < right){
            int width = right - left;
            int height = Math.min(heights[left], heights[right]); 
            int area = width * height;
            ans = Math.max(ans, area);

            if (heights[left] < heights[right]){
                left++;
            }
            else {
                right--;
            }
        }

        return ans;
    }
}
