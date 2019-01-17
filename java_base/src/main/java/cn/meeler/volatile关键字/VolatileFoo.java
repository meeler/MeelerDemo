package cn.meeler.volatile关键字;

import java.util.concurrent.TimeUnit;

public class VolatileFoo {
    private final static int MAX = 5;
    private static volatile int init_value = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int local_value = init_value;
            while (local_value < MAX) {
                if (local_value != init_value) {
                    System.out.printf("The init_value is updated to [%d]\n", init_value);
                }
                local_value = init_value;
            }
        }, "reader").start();

        new Thread(() -> {
            int local_value = init_value;
            while (local_value < MAX) {
                System.out.printf("The init_value will change to [%d]\n", ++local_value);
                init_value = local_value;
                try {
                    TimeUnit.SECONDS.sleep(2L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Update").start();
    }
}
