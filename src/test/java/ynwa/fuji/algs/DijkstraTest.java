package ynwa.fuji.algs;

import edu.princeton.cs.algs4.DijkstraAllPairsSP;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import org.junit.Test;

/**
 * Created by David Wang on 2016-07-22.
 */
public class DijkstraTest {

    @Test
    public void dd() {
        In in = new In("E:\\myDoc\\algs4-data\\tinyEWDAG.txt");
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);

        DijkstraAllPairsSP d = new DijkstraAllPairsSP(G);
        assert !d.hasPath(0,5);
    }
}
