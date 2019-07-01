package com.nercel.Stack;

/**
 * @author dongxin
 * @create 2019/6/27
 */
public interface Stack<E>{
    int getSize();
    boolean isEmpty();
    //入栈
    void push(E e);
    //出栈
    E pop();
    //查看栈顶元素(不出)
    E peak();
}
