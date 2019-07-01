package com.nercel.LinkedList;

/**
 * @author dongxin
 * @create 2019/7/1
 */
public class LinkedListBasic<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

    }

    private Node head;
    private int size;

    public LinkedListBasic(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    //在链表头添加新的元素
    public void addFirst(E e){
//        Node node = new Node(e);
////        node.next=head;
////        head=node;
        head = new Node(e,head);
        size++;
    }

    //在链表的(0-based)位置添加新的元素
    public void add(int index,E e){
        if (index<0|| index>size)
            throw new IllegalArgumentException("add failed.llegal index.");
        if (index==0){
            addFirst(e);
        }else {
            Node prev = head;
            for (int i = 0;i<index-1;i++)
                prev = prev.next;
//                Node node = new Node(e);
//                node.next = prev.next;
//                prev.next =node;

            prev.next = new Node(e,prev.next);
            size++;

        }
    }

    //在链表末尾添加元素
    public void addLast(E e){
        add(size,e);
    }

}
