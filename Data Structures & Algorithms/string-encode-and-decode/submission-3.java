class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder(); 
        for (String s: strs) {
            int len = s.length(); 
            result.append(String.valueOf(len)+"#"+s);
        }
        return result.toString(); 
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>(); 
        int i = 0;
        while (i < str.length()) {
            int start = i; 
            // System.out.println("start before="+start);
            while (Character.isDigit(str.charAt(i))) {
                i++;
            }
            // System.out.println("i after="+i);
            int len = Integer.parseInt(str.substring(start, i));
            // System.out.println("len="+len);
            i++; 
            int endIndex = i+len;
            if (endIndex >= str.length()) {
                result.add(str.substring(i));
            } else {
                result.add(str.substring(i, endIndex));
            }
            i = endIndex;
        }
        return result; 
    }
}
