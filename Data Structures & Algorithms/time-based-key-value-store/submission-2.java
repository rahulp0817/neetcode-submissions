class TimeMap {
    
    class Pair {
        public int timestamp;
        public String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    
    Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        ArrayList<Pair> list = map.get(key); 

        String result = "";

        int left = 0;
        int right = list.size() - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
