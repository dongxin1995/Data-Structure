package com.nercel.Stack;

import com.nercel.Array.Array2;

/**
 * @author dongxin
 * @create 2019/6/27
 */
public class ArrayStack<E> implements Stack<E> {

    Array2<E> array;

    public ArrayStack(int capacity){
        array = new Array2<>(capacity);
    }

    public ArrayStack(){
        array = new Array2<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peak() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res =  new StringBuilder();
        res.append("Stack:");
        res.append("[");
        for (int i = 0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize()-1)
                res.append(",");
        }
        res.append("] top");
        return res.toString();
    }
}
