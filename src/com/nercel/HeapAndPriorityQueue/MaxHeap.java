package com.nercel.HeapAndPriorityQueue;

import com.nercel.Array.Array2;

/**
 * @author dongxin
 * @create 2019/7/8
 * 实现一个底层数组的最大堆
        */

public class MaxHeap<E extends Comparable<E>> {

    //Array为自定义的数组
    private Array2<E> data;

    public MaxHeap(int capacity){
        data = new Array2<E>(capacity);
    }

    public MaxHeap(){
        data = new Array2<E>();
    }

    public int size(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    public int parent(int index){
        if (index==0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index-1)/2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index){
        return index*2+1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index){
        return index*2+2;
    }

    //向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    public void siftUp(int k){
        while (k>0&&data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
        }
    }

    //取出堆中最大元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    //找出堆中的最大元素
    public E findMax(){
        if (data.getSize()==0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    public void siftDown(int k){
        while (leftChild(k)<data.getSize()){
            int j = leftChild(k);
            //判断是否有右节点且右节点的值是否大于左节点的值
            if (j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0)
                j = rightChild(k);
            //data[j]是左孩子和右孩子中的最大值
            if (data.get(k).compareTo(data.get(j))>=0)
                break;
            data.swap(k,j);
            k=j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
