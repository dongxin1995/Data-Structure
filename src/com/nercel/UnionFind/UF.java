package com.nercel.UnionFind;

/**
 * @author dongxin
 * @create 2019/7/30
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);


}
