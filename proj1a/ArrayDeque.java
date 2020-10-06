public class ArrayDeque<T>{
    private T[] array;
    private int size;
    private int first_ind;
    private int last_ind;

    public ArrayDeque(){
        array=(T[]) new Object[8];
        size=0;
        first_ind=0;
        last_ind=0;
    }

    private void resize(int capacity, Boolean is_front){
        T[] new_array=(T[]) new Object[capacity];
        if (!is_front){
            System.arraycopy(array, first_ind, new_array, 0, size);
        }else{
            System.arraycopy(array, 0, new_array, size, size);
        }
        array=new_array;
    }

    public void addFirst(T item){
        if (size==0){
            array[0]=item;
        }else{
            if (first_ind==0){
                int capacity=size*2;
                resize(capacity, true);
                first_ind=capacity-size;
                last_ind=first_ind+size-1;
            }
            array[first_ind-1]=item;
            first_ind--;
        }
        size++;
    }

    public void addLast(T item){
        if (size==0){
            array[0]=item;
        }else{
            if(last_ind==array.length-1){
                int capacity=size*2;
                resize(capacity, false);
                first_ind=0;
                last_ind=first_ind+size-1;
            }
            array[last_ind+1]=item;
            last_ind++;
        }
        size++;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }


    public void printDeque(){
        if (size==0){
            System.out.print("");
        }else{
            int counter=first_ind;
            while (counter<first_ind+size){
                String last_space=" ";
                if (counter+1==first_ind+size)
                    last_space="";
                System.out.print(array[counter].toString()+last_space);
                counter++;
            }
        }
    }

    public T removeFirst(){
        if (size==0){
            return null;
        }else{
            T first=array[first_ind];
            array[first_ind]=null;
            size--;
            if(size==0){
                first_ind=0;
                last_ind=0;
            }else
                first_ind++;
            if (size*2==array.length){
                resize(size, false);
                first_ind=0;
                last_ind=size-1;
            }
            return first;
        }
    }

    public T removeLast(){
        if(size==0){
            return null;
        }else{
            T last=array[last_ind];
            array[last_ind]=null;
            size--;
            if(size==0){
                first_ind=0;
                last_ind=0;
            }else
                last_ind--;
            if (size*2==array.length){
                resize(size, false);
                first_ind=0;
                last_ind=size-1;
            }
            return last;
        }
    }

    public T get(int index){
        if(size==0){
            return null;
        }
        return array[first_ind+index];
    }
}
