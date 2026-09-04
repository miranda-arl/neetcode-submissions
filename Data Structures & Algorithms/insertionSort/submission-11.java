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
            Pair lVal = temp.get(lPointer);
            Pair rVal = temp.get(rPointer);
            
            if (lVal.key > rVal.key) {
                while (lPointer > -1 && rPointer > -1) {
                    lVal = temp.get(lPointer);
                    rVal = temp.get(rPointer);
                    if (lVal.key > rVal.key) { // remove, then swap
                        temp.remove(rPointer);
                        temp.remove(lPointer);
                        temp.add(lPointer, rVal);
                        temp.add(rPointer, lVal);
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
