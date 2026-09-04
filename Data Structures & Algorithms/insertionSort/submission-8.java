// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();
        if (pairs.isEmpty()) return result;
        result.add(pairs);

        int index = 0; 
        for (int i = 1; i < pairs.size(); i++) {
            int lPointer = i-1; 
            int rPointer = i; 
            //System.out.println("lPointer="+lPointer+" rPointer="+rPointer);
            List<Pair> temp = new ArrayList<>();
            temp.addAll(result.get(index)); // last state

            Pair first = temp.get(lPointer);
            Pair sec = temp.get(rPointer);
            
            System.out.println("lPointer="+first.key+" rPointer="+sec.key);
            if (first.key > sec.key) {
                while (lPointer > -1 && rPointer > -1) {
                    first = temp.get(lPointer);
                    sec = temp.get(rPointer);
                    if (first.key > sec.key) {
                        // remove, then swap
                        temp.remove(rPointer);
                        temp.remove(lPointer);
                        temp.add(lPointer, sec);
                        temp.add(rPointer, first);
                        // index++;
                    }
                    lPointer--; 
                    rPointer--;
                }
            }
            result.add(temp);
            index++;
        }
        return result; 
    }
}
