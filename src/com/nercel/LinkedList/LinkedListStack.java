package com.nercel.LinkedList;

/**
 * @author dongxin
 * @create 2019/7/1
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack(){
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peak() {
        return linkedList.getFirst();
    }
}
