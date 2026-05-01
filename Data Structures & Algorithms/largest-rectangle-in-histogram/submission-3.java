class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++) {

            int curr_height = (i == heights.length)? 0 : heights[i];
            
            // right element is not found bigger then 0
            while(!stack.isEmpty() && heights[stack.peek()] > curr_height) {
                int element = stack.pop();
                int next_smaller_element = i;  // right boundary
                int prev_element = stack.isEmpty() ? -1 : stack.peek(); // left boundary
                int width = next_smaller_element - prev_element - 1;
                maxArea = Math.max(maxArea, heights[element] * width);
            }

            stack.push(i);
        }

        // left or remaning elements
        // while(!stack.isEmpty()) {
        //     int element = stack.pop();
        //     int next_smaller_element = heights.length;
        //     int prev_element = stack.isEmpty() ? -1 : stack.peek();
        //     int width = next_smaller_element - prev_element - 1;
        //     maxArea = Math.max(maxArea, heights[element] * width);

        // }

        return maxArea;
    }
}
