class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        // initialize 2d array
        double[][] cars = new double[n][2]; // n rows and 2 columns

        // fill the array
        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        } 

        // sort it to find which car is ahead and which is behind
        // 2D array sort formula
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        Deque<Double> stack = new ArrayDeque<>();

        for(int i = position.length - 1; i >= 0; i--) {

            double time = cars[i][1];

            // if time is more then create a fleets
            if(stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
