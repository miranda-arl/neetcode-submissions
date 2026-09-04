class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = 1;
        for (int j = 1; j < n; j++) {
            prefix[j] = nums[j-1] * prefix[j-1];
        }

        suffix[n-1] = 1;
        for (int k = n-2; k >= 0; k--) {
            suffix[k] = nums[k+1] * suffix[k+1];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = prefix[i] * suffix[i];
        }

        return nums; 
    }
}  
