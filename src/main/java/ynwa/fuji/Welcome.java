package ynwa.fuji;

/**
 * Created by David Wang on 2016/4/27.
 */
public class Welcome {
    static {
    }

    private String hi;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
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


        System.out.println("ynwa.fuji.Welcome !!");
        System.err.println("ssss");
    }
}
