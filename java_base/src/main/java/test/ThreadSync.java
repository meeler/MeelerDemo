package test;

import java.util.concurrent.TimeUnit;


public class ThreadSync {
    public static final Object MIUNX = new Object();

    public void accessResource() {
        synchronized (MIUNX) {
            try {
                TimeUnit.MINUTES.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadSync threadSync = new ThreadSync();
        for (int i = 0; i < 5; i++) {
            new Thread().start();
            new Thread(threadSync::accessResource).start();
        }
    }
}
