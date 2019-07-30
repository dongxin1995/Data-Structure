package com.nercel.SegmentTree;

/**
 * @author dongxin
 * @create 2019/7/9
 *
 * LeetCode303
 * 给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
     sumRange(0, 2) -> 1
     sumRange(2, 5) -> -1
     sumRange(0, 5) -> -3
 */
public class NumArray {

    //自定义辅助接口和类
    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {

        if (nums.length>0){
            Integer[] data = new Integer[nums.length];
            for (int i =0;i<nums.length;i++)
                data[i]=nums[i];
            segmentTree = new SegmentTree<>(data, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a+b;
                }
            });
        }
    }

    public int sumRange(int i, int j) {
        if (segmentTree==null){
            throw new IllegalArgumentException("Segment Tree is null");
        }
        return segmentTree.query(i,j);
    }

//    private int[] sum;
//    // sum[i]存储前i个元素和，
//    // sum[0] = 0 // sum[i]存储nums[0...i-1]的和
//    public NumArray(int[] nums) {
//        sum = new int[nums.length + 1];
//        sum[0] = 0;
//        for (int i = 1 ; i < sum.length ; i ++)
//            sum[i] = sum[i - 1] + nums[i - 1];
//    }
//    public int sumRange(int i, int j) {
//        return sum[j + 1] - sum[i];
//    }

}
