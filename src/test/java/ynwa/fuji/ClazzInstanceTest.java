package ynwa.fuji;

import org.junit.Test;

/**
 * Created by ynwa on 16/7/14.
 */
public class ClazzInstanceTest {

    @Test
    public void main() throws Exception {
        Class[] c = new Class[] {Welcome.class};
        String name = "ynwa.fuji.Welcome";
        long start1 = System.currentTimeMillis();
        for (int i=0; i<1000000; i++) {
            Welcome w1 = (Welcome) c[0].newInstance();
        }
        System.err.println(System.currentTimeMillis() - start1);
        long start2 = System.currentTimeMillis();
        for (int i=0; i<1000000; i++) {
            Welcome w2 = (Welcome) Class.forName(name).newInstance();
        }
        System.err.println(System.currentTimeMillis() - start2);
    }
}
