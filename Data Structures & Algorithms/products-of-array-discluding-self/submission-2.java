class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        for (int n = 0; n < nums.length; n++) {
            if (n == 0) prefix[n] = 1;
            else prefix[n] = nums[n-1] * prefix[n-1];
        }

        for (int k = nums.length-1; k >= 0; k--) {
            if (k == nums.length-1) suffix[k] = 1;
            else suffix[k] = nums[k+1] * suffix[k+1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefix[i] * suffix[i];
        }
        return nums; 
    }
}  
