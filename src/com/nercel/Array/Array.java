package com.nercel.Array;

/**
 * 二次封装我们自己的数组
 */

public class Array {

    private int[] data;
    private int size;

    //构造函数，传入数组的容量capacity构造array
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    //无参构造函数，默认数组的容量为10
    public Array() {
        this(10);
    }

    //获取数组中的元素个数
    public int getSize() {
        return size;
    }

    //获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //向所有元素后添加一个新元素
    public void addLast(int e) {
        add(size, e);
    }

    //向数组指定位置添加元素
    public void add(int index, int e) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("Index is error");
        if (index == data.length)
            throw new IllegalArgumentException("add is failed.array is full");
        for (int i = size - 1; i >= index; i--) {
            data[size + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //在所有元素前添加一个新元素
    public void addFirst(int e) {
        add(0, e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d,capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(",");
            }
        }
        res.append(']');
        return res.toString();
    }

    //获取index索引位置的元素
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,index is illegal");
        return data[index];
    }

    public int getLast() {
        return data[size - 1];
    }

    public int getFirst() {
        return data[0];
    }

    //修改index索引位置的元素e
    public void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,index is illegal");
        data[index] = e;
    }

    //查找数组中是否有元素e
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    //查找数组中的元素e所在的索引，如果不存在元素e,则返回-1
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    //从数组中删除index位置的元素，返回删除的元素
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get failed,index is illegal");
        int res = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        return res;
    }

    //从数组中删除第一个元素，返回删除的元素
    public int removeFirst() {
        return remove(0);
    }

    //从数组中删除最后一个元素，返回删除的元素
    public int removeLast() {
        return remove(size - 1);
    }

    //从数组中删除e
    public void removeElement(int e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }
}
