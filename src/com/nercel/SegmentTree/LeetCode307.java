package com.nercel.SegmentTree;

/**
 * @author dongxin
 * @create 2019/7/9
 *
 * LeetCode307
 *
给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。

Given nums = [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8

数组仅可以在 update 函数下进行修改。
你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。

 */
public class LeetCode307 {

    private SegmentTree<Integer> segmentTree;

    public LeetCode307(int[] nums){
        if (nums.length>0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0;i<nums.length;i++)
                data[i] = nums[i];
            segmentTree = new SegmentTree<>(data,(a, b) -> a+b);
        }
    }

    public void update(int index ,int val){
        if (segmentTree==null)
            throw new IllegalArgumentException("Segment Tree is null.");
        segmentTree.set(index,val);
    }

    public int sumRange(int i , int j){
        if (segmentTree==null)
            throw new IllegalArgumentException("Segment Tree is null.");
        return segmentTree.query(i,j);
    }

}
