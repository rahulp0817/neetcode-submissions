class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        // count frequency
        int[] freq = new int[26];

        for(char task: tasks) {
            freq[task - 'A']++;
        }

        // create maxHeap and add the count frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // add all the freq in heap
        for(int f : freq) {
            if(f > 0) {
              maxHeap.offer(f);  
            }
        }

        int time = 0;

        // process tasks
        while(!maxHeap.isEmpty()) {
            // stores tasks
            List<Integer> temp = new ArrayList<>();
            // one cycle window size
            int cycle = n + 1;
            // No. of task executed in one cycle
            int tasksDone = 0;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int current = maxHeap.poll();
                current--;

                tasksDone++;
                if (current > 0) {
                    temp.add(current);
                }

                cycle--;
            }

            // Put remaining tasks back into heap
            for (int remaining : temp) {
                maxHeap.offer(remaining);
            }

            if (maxHeap.isEmpty()) {
                time += tasksDone;
            } else {
                time += (n + 1);
            }

        }

        return time;
    }
}
