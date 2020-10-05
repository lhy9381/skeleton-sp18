public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int first_ind;
    private int last_ind;

    public ArrayDeque(){
        // Creates an empty array deque.
        array = (T[]) new Object[8];
        size = 0;
        first_ind = 0;
        last_ind = 0;
    }

    private void resize(int capacity, Boolean is_front) {
        T[] new_array = (T[]) new Object[capacity];
        if (!is_front)
            System.arraycopy(array, first_ind, new_array, 0, size);
        else
            System.arraycopy(array, 0, new_array, size, size);
        array = new_array;
    }

    public void addFirst(T item) {
        // Adds an item of type T to the front of the deque.
        if (size==0) {
            array[0] = item;
        }
        else {
            if (first_ind==0) {
                int capacity = size * 2;
                resize(capacity, true);
                first_ind = capacity - size;
                last_ind = first_ind + size - 1;
            }
            array[first_ind - 1] = item;
            first_ind--;
        }
        size++;
    }

    public void addLast(T item) {
        // Adds an item of type T to the back of the deque.
        if (size==0){
            array[0] = item;
        }
        else{
            if(last_ind==array.length-1){
                int capacity = size * 2;
                resize(capacity, false);
                first_ind = 0;
                last_ind = first_ind + size - 1;
            }
            array[last_ind + 1] = item;
            last_ind++;
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
        if (size==0)
            System.out.print("");
        else {
            int counter = first_ind;
            while (counter < first_ind + size) {
                String last_space = " ";
                if (counter + 1 == first_ind + size)
                    last_space = "";
                System.out.print(array[counter].toString() + last_space);
                counter++;
            }
        }
    }

    public T removeFirst() {
        // Removes and returns the item at the front of the deque. If no such item exists, returns null.
        if (size==0)
            return null;
        else {
            T first = array[first_ind];
            array[first_ind] = null;
            first_ind++;
            size--;
            if (size * 2 == array.length) {
                resize(size, false);
                first_ind = 0;
                last_ind = size - 1;
            }
            return first;
        }
    }

    public T removeLast() {
        // Removes and returns the item at the back of the deque. If no such item exists, returns null.
        if(size==0)
            return null;
        else {
            T last = array[last_ind];
            array[last_ind] = null;
            last_ind--;
            size--;
            if (size * 2 == array.length) {
                resize(size, false);
                first_ind = 0;
                last_ind = size - 1;
            }
            return last;
        }
    }

    public T get(int index) {
        //  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
        //  If no such item exists, returns null. Must not alter the deque!
        if(size==0)
            return null;
        return array[first_ind + index];
    }
}
