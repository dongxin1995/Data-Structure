package com.nercel.HeapAndPriorityQueue;

/**
 * @author dongxin
 * @create 2019/7/8
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}
