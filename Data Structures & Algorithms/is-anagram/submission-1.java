class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int sl = s.length();
        int st = t.length();

        if(sl != st) return false;

        for(int i = 0; i < sl; i++){
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            map.put(sc, map.getOrDefault(sc, 0) + 1);
            map.put(tc, map.getOrDefault(tc, 0) - 1);
        }

        for(int i:map.values()){
            if(i != 0) return false;
        }
        return true;
    }
}