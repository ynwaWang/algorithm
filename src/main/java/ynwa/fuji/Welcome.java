package ynwa.fuji;

/**
 * Created by David Wang on 2016/4/27.
 */
public class Welcome {
    static {
    }

    private String hi;

    public String getHi() {
        return hi;
    }

    public void getxxxx() {
        Thread x = new Thread(new Runnable() {
            @Override
            public void run() {
                Welcome.this.getHi();
            }
        });
    }

    public static void main(String[] args) throws Exception {



        System.out.println("ynwa.fuji.Welcome !!");
        System.err.println("ssss");
    }
}
