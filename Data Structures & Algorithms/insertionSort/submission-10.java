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
            List<Pair> temp = new ArrayList<>();
            temp.addAll(result.get(index)); // last state

            int lPointer = i-1; 
            int rPointer = i; 
            Pair l = temp.get(lPointer);
            Pair r = temp.get(rPointer);
            
            if (l.key > r.key) {
                while (lPointer > -1 && rPointer > -1) {
                    l = temp.get(lPointer);
                    r = temp.get(rPointer);
                    if (l.key > r.key) { // remove, then swap
                        temp.remove(rPointer);
                        temp.remove(lPointer);
                        temp.add(lPointer, r);
                        temp.add(rPointer, l);
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
