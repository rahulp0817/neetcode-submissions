class Solution {
    public int lastStoneWeight(int[] stones) {
       
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        // add elements
        for(int stone: stones) {
            maxHeap.offer(stone);
        }

       // process untill no stones left
       while(maxHeap.size() > 1) {
        int x = maxHeap.poll(); // largest element and also destroyed 
        int y = maxHeap.poll(); // second largest and also destroyed

        if(x != y) {
            maxHeap.offer(x - y);
        }

       }
       return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
