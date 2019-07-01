package com.nercel.LinkedList;

/**
 * @author dongxin
 * @create 2019/7/1
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
