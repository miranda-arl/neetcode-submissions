class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(
            Map.of('(', ')', '[', ']', '{', '}'));

        if (s.length() <= 1) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char brace = s.charAt(i);
            if (map.containsKey(brace)) {
                stack.push(brace);
            } else {
                if (stack.isEmpty()) return false;
                Character top = stack.peek();
                if (map.get(top) == brace) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
