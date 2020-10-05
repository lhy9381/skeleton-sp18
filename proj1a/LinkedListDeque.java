public class LinkedListDeque<T> {
    private class TNode{
        public T item;
        public TNode next;
        public TNode prev;

        public TNode(TNode l, T i, TNode n){
            prev = l;
            item = i;
            next = n;
        }
    }

    private TNode sentinel;
    private int size;

    public LinkedListDeque(){
        // Creates an empty linked list deque.
        sentinel = new TNode(null, null, null);
        size = 0;
    }

    public void addFirst(T item) {
        // Adds an item of type T to the front of the deque.
        if(size == 0){
            sentinel.next = new TNode(sentinel, item, sentinel.next);
            sentinel.next.next = sentinel;
            sentinel.prev = sentinel.next;
        }
        else{
            sentinel.next = new TNode(sentinel, item, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
        }
        size++;
    }

    public void addLast(T item) {
        // Adds an item of type T to the back of the deque.
        if(size == 0){
            sentinel.prev = new TNode(sentinel.prev, item, sentinel);
            sentinel.prev.prev = sentinel;
            sentinel.next = sentinel.prev;
        }
        else{
            sentinel.prev = new TNode(sentinel.prev, item, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
        }
        size++;
    }

    public boolean isEmpty() {
        // Returns true if deque is empty, false otherwise.
        return size==0;
    }

    public int size() {
        // Returns the number of items in the deque.
        return size;
    }


    public void printDeque() {
        // Prints the items in the deque from first to last, separated by a space.
        if (sentinel.next==null)
            System.out.print("");
        else {
            TNode copy_first = sentinel.next;
            while (copy_first.item != null) {
                String last_space = " ";
                if (copy_first.next == null)
                    last_space = "";
                System.out.print(copy_first.item.toString() + last_space);
                copy_first = copy_first.next;
            }
        }
    }

    public T removeFirst() {
        // Removes and returns the item at the front of the deque. If no such item exists, returns null.
        if(isEmpty())
            return null;
        else {
            T first = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size--;
            return first;
        }
    }

    public T removeLast() {
        // TODO: Removes and returns the item at the back of the deque. If no such item exists, returns null.
        if(isEmpty())
            return null;
        else {
            T last = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size--;
            return last;
        }
    }

    public T get(int index) {
        //  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        //  If no such item exists, returns null. Must not alter the deque!
        TNode copy_first = sentinel;
        if (copy_first.next==null)
            return null;
        int counter = 0;
        while (copy_first.next != null){
            if (counter == index + 1)
                break;
            counter++;
            copy_first = copy_first.next;
        }
        return copy_first.item;
    }

    private T getRecursive(TNode p, int index){
        if (p.next==null)
            return null;
        return getRecursive(p.next, index-1);
    }

    public T getRecursive(int index){
        // Same as get, but uses recursion.
        if (size==0)
            return null;
        else
            return getRecursive(sentinel.next, index);
    }
}
