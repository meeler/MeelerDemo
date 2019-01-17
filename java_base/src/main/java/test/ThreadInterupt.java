package test;

import java.util.concurrent.TimeUnit;

public class ThreadInterupt {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1L);
            } catch (InterruptedException e) {
                System.out.println("dddddddd");
            }
            System.out.println("hhhhhhh");
        });
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
