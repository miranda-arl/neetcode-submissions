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
    }

    public void pushback(int n) {
        if (elements == l.length) { // full
            resize();
        }
        set(elements, n);
        elements++;
    }

    public int popback() {
        int lastIndex = elements-1;
        int val = get(lastIndex);
        // set(lastIndex, 0);
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
