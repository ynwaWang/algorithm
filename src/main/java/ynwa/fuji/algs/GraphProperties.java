package ynwa.fuji.algs;

import edu.princeton.cs.algs4.Graph;

/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-08.
 * TODO 实现习题4.1.16 图的属性 P372
 */
public class GraphProperties {
    /**
     * @param graph 不是连通的，抛出异常
     */
    public GraphProperties(Graph graph) {
    }

    /**
     * 顶点v的离心率是它和离它最远的顶点的最短距离
     * @param v
     * @return
     */
    public int eccentricity(int v) {
        return 0;
    }

    /**
     * G的直径是所有顶点的最大离心率
     * @return
     */
    public int diameter() {
        return 0;
    }

    /**
     * G的半径是所有顶点的最小离心率
     * @return
     */
    public int radius() {
        return 0;
    }

    /**
     * G的某个中点为离心率和半径相等的顶点
     * @return
     */
    public int center() {
        return 0;
    }
}
