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
        if (elements == l.length) resize();
        set(elements, n);
        elements++;
    }

    public int popback() {
        int val = get(elements-1);
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
