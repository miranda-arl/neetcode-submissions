class LinkedList {

    ArrayList<Integer> l;

    public LinkedList() {
        l = new ArrayList<Integer>();
    }

    public int get(int index) {
        if (index >= l.size()) return -1;
        return l.get(index);
    }

    public void insertHead(int val) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(val);
        temp.addAll(l);
        l = temp;
    }

    public void insertTail(int val) {
        l.add(val);
    }

    public boolean remove(int index) {
        if (index >= l.size()) return false;
        l.remove(index);
        return true;
    }

    public ArrayList<Integer> getValues() {
        return l;
    }
}
