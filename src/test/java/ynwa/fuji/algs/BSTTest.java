package ynwa.fuji.algs;

import edu.princeton.cs.algs4.BST;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by David Wang<wdw@winbaoxian.com> on 2016-07-05.
 */
public class BSTTest {
    @Test
    public void t1() {
        BST<String, Integer> st = new BST<String, Integer>();
//        String[] example = "S E R C H X A M P L D".split(" ");
        String[] example = "E R C S H X M P L D".split(" ");
        for (int i = 0; i < example.length; i++) {
            String key = example[i];
            st.put(key, i);
        }
//        st.height();
//        for (String s : st.levelOrder())
//            StdOut.println(s + " " + st.get(s));

        st.deleteMin();
    }
}
