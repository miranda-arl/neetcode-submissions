class Solution {
    public int maxArea(int[] heights) {
        int maxHeight = Integer.MIN_VALUE;
        int l = 0; 
        int r = heights.length-1;
        while (l < r) {
            int minBar = Math.min(heights[l], heights[r]);
            int total = minBar * (r-l);
            maxHeight = Math.max(maxHeight, total);
            if (heights[l] <= heights[r]) {
                l++;
            } else if (heights[l] > heights[r]) {
                r--;
            } 
            // else {
            //     l++;
            //     r--;  
            // }
        }
        return maxHeight;
    }
}
