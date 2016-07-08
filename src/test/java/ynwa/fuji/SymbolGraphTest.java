package ynwa.fuji;

import edu.princeton.cs.algs4.*;
import org.junit.Test;

/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-08.
 * 4.1.7 符号表和间隔度数 P366
 */
public class SymbolGraphTest {
    @Test
    public void testSg() {
        String filename = "routes.txt";
        String delim = " ";
        String source = "JFK";
//        String filename1 = "movies.txt";
//        String delim1 = "/";
        SymbolGraph sg = new SymbolGraph(filename,delim);
        Graph g = sg.G();

        for (int w : g.adj(sg.index(source))) {
            StdOut.println("  " + sg.name(w));
        }
    }
    @Test
    public void testBfs() {
        String filename = "routes.txt";
        String delim = " ";
        SymbolGraph sg = new SymbolGraph(filename,delim);
        Graph G = sg.G();

        String source = "JFK";
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database.");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        String sink = "LAS";
        if (sg.contains(sink)) {
            int t = sg.index(sink);
            if (bfs.hasPathTo(t)) {
                for (int v : bfs.pathTo(t)) {
                    StdOut.println("   " + sg.name(v));
                }
            }
            else {
                StdOut.println("Not connected");
            }
        }
        else {
            StdOut.println("   Not in database.");
        }
    }
}
