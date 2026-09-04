class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int totalLeft = 1;
        for (int n = 0; n < nums.length; n++) {
            prefix[n] = totalLeft;
            totalLeft *= nums[n];
        }

        int totalRight = 1; 
        for (int k = nums.length-1; k >= 0; k--) {
            suffix[k] = totalRight;
            totalRight *= nums[k];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums; 
    }
}  
