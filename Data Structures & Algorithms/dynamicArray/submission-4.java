class DynamicArray {

    public int[] l;
    public int elements;

    public DynamicArray(int capacity) {
        l = new int[capacity];
        elements = 0;
    }

    public int get(int i) {
        return l[i];
    }

    public void set(int i, int n) {
        l[i] = n;
        // System.out.println("l["+i+"]="+n);
    }

    public void pushback(int n) {
        // int lastIndex = l.length-1;
        // System.out.println("pushback "+n + " at "+lastIndex);
        // System.out.println("get(lastIndex)="+get(lastIndex));
        if (elements == l.length) { // then full
            resize();
            // System.out.println("resize!");
        }
        set(elements, n); // in case it changed
        elements++;
    }

    public int popback() {
        int lastIndex = elements-1;
        int val = get(lastIndex);
        set(lastIndex, 0);
        elements--;
        return val;
    }

    private void resize() {
        int currSize = l.length;
        l = Arrays.copyOfRange(l, 0, currSize*2);
    }

    public int getSize() {
        return elements;
    }

    public int getCapacity() {
        return l.length;
    }
}
