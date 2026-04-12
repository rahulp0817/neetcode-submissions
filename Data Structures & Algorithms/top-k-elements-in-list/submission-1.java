class Solution {
    public int[] topKFrequent(int[] nums, int k) {

       HashMap<Integer, Integer> map = new HashMap<>();

       // get the frequent elements
       for(int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
       }
       
       // { 1: 1, 2: 2, 3: 3} unorder

       // Priority Quque 
       PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
       maxHeap.addAll(map.entrySet());

       // { 3: 3, 2: 2, 1: 1} order

       int[] result = new int[k];
       for(int i = 0; i < k; i++){
        result[i] = maxHeap.poll().getKey();
       }

       return result;
    }
}
