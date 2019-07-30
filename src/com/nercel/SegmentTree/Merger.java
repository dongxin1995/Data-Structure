package com.nercel.SegmentTree;

/**
 * @author dongxin
 * @create 2019/7/9
 */
public interface Merger<E> {

    //自定义merge方法定义融合规则
    E merge(E a ,E b);

}
