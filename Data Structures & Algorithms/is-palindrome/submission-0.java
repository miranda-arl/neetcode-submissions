class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();

        int l = 0;
        int r = lower.length()-1;
        while (l < r) {
            char lChar = lower.charAt(l);
            char rChar = lower.charAt(r);
            if (Character.isLetterOrDigit(lChar) && 
            Character.isLetterOrDigit(rChar)) {
                if (lChar != rChar) {
                    return false;
                }
                l++;
                r--;
            } else if (!Character.isLetterOrDigit(lChar)) {
                l++;
            } else if (!Character.isLetterOrDigit(rChar)) {
                r--;
            } 
        }
            
        
        return true;
    }
}
