public class Array<E> {
    private E[] data;
    private int size;

    //constructor, put capacity into array
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //default capacity = 10;
    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");

        if (size == data.length)
            resize(2 * data.length);

        for (int i = size - 1; i >= index; i --)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
//        if (size == data.length)
//            throw new IllegalArgumentException("AddLast failed, Array is full");
//
//        data[size] = e;
//        size++;
    }

    //insert a new element into position index


    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed");
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }
    //update the data[index]
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed");
        data[index] = e;
    }

    //contain data[index] = e or not
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //find the index when the element is e, if does not find e, return -1;
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //delete the data[index], and return the element
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size");

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if(size == data.length/4 && data.length / 2 != 0){
            resize(data.length/2);
        }
        return ret;
    }

    //delete the first element
    public E removeFirst() {
        return remove(0);
    }

    //delete the last element
    public E removeLast() {
        return remove(size - 1);
    }

    //if the element exists, remove it
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
