package com.nercel.Queue;

/**
 * @author dongxin
 * @create 2019/6/27
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
