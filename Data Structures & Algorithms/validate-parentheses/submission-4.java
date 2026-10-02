class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(
            Map.of('(', ')', '[', ']', '{', '}'));

        if (s.length() <= 1) return false;

        Stack<Character> stack = new Stack<>();
        System.out.println("beg. stack: "+stack);
        for (int i = 0; i < s.length(); i++) {
            char brace = s.charAt(i);
            System.out.println("brace="+brace);
            if (map.containsKey(brace)) {
                stack.push(brace);
                System.out.println("stack: "+stack);
            } else {
                if (stack.isEmpty()) return false;
                Character top = stack.peek();
                System.out.println("top: "+top);
                if (map.get(top) == brace) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        System.out.println("end stack: "+stack);
        return stack.isEmpty();
    }
}
