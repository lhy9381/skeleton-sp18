public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private int firstInd;
    private int lastInd;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        firstInd = 0;
        lastInd = 0;
    }

    private void resize(int capacity, Boolean isFront) {
        T[] newArray = (T[]) new Object[capacity];
        if (!isFront) {
            System.arraycopy(array, firstInd, newArray, 0, size);
        } else {
            System.arraycopy(array, 0, newArray, size, size);
        }
        array = newArray;
    }

    public void addFirst(T item) {
        if (size == 0) {
            array[0] = item;
        } else {
            if (firstInd == 0) {
                int capacity = size * 2;
                resize(capacity, true);
                firstInd = capacity - size;
                lastInd = firstInd + size - 1;
            }
            array[firstInd - 1] = item;
            firstInd--;
        }
        size++;
    }

    public void addLast(T item) {
        if (size == 0) {
            array[0] = item;
        } else {
            if (lastInd == array.length - 1) {
                int capacity = size * 2;
                resize(capacity, false);
                firstInd = 0;
                lastInd = firstInd + size - 1;
            }
            array[lastInd + 1] = item;
            lastInd++;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public void printDeque() {
        if (size == 0) {
            System.out.print("");
        } else {
            int counter = firstInd;
            while (counter < firstInd + size) {
                String lastSpace = " ";
                if (counter + 1 == firstInd + size) {
                    lastSpace = "";
                }
                System.out.print(array[counter].toString() + lastSpace);
                counter++;
            }
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T first = array[firstInd];
            array[firstInd] = null;
            size--;
            if (size == 0) {
                firstInd = 0;
                lastInd = 0;
            } else {
                firstInd++;
            }
            if (size * 2 == array.length) {
                resize(size, false);
                firstInd = 0;
                lastInd = size - 1;
            }
            return first;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T last = array[lastInd];
            array[lastInd] = null;
            size--;
            if (size == 0) {
                firstInd = 0;
                lastInd = 0;
            } else {
                lastInd--;
            }
            if (size * 2 == array.length) {
                resize(size, false);
                firstInd = 0;
                lastInd = size - 1;
            }
            return last;
        }
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }
        return array[firstInd + index];
    }
}
