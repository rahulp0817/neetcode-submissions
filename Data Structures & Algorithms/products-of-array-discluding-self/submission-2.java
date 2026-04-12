class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        int leftProduct = 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }
        
        int rightProduct = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];

        }

        return result;
    }
}



























// int[] result = new int[nums.length];
        
//         int leftproduct = 1;
//         for (int i = 0; i < nums.length; i++){
//             result[i] = leftproduct;
//             leftproduct *= nums[i]; 
//         }

//         int rightproduct = 1;
//         for (int i = nums.length - 1; i >= 0; i--){
//             result[i] *= rightproduct;
//             rightproduct *= nums[i];
//         }

//         return result;