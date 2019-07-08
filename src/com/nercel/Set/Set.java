package com.nercel.Set;

/**
 * @author dongxin
 * @create 2019/7/8
 */
public interface Set<E> {

    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();

}
