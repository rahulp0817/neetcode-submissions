class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int n:nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freq.entrySet());

        int[] result = new int[k];

        for(int i = 0; i < k; i++){
            result[i] = maxHeap.poll().getKey();
        }

        return result;
    }
}
