package com.nercel.HeapAndPriorityQueue;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author dongxin
 * @create 2019/7/8
 *
 *
优先队列的经典问题 LeetCode347
在1000000个元素中选出前100名？
在N个元素中选出M个元素

使用优先队列，维护当前看到的前M个元素
需要使用最小堆

 */
public class Solution {

    private class Freq implements Comparable<Freq>{

        int e,freq;

        public Freq(int e,int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq<another.freq)
                return -1;
            else if (this.freq>another.freq)
                return 1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums , int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }


        //这里我们可以将map中的键值数据对做成可比较的Freq类型的优先队列
        //承载的元素类型一定要是可比较的，这里的PriorityQueue用的是我们自己定义的不是util下的
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();

        for (int key :map.keySet()){
            if (priorityQueue.size()<k)
                priorityQueue.add(new Freq(key,map.get(key)));
            else if (map.get(key)>priorityQueue.peek().freq){
                priorityQueue.remove();
                priorityQueue.add(new Freq(key,map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty())
            res.add(priorityQueue.remove().e);
        return res;

    }
}
