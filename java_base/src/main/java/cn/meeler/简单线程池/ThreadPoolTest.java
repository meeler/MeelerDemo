package cn.meeler.简单线程池;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 1000);
        for (int i = 0; i < 20; i++) {
            threadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10L);
                    System.out.println(Thread.currentThread().getName() + "is running and done");
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            });
        }

//        for (; ; ) {
//            System.out.println("active" + threadPool.getActiveCount());
//            System.out.println("queueSize" + threadPool.getQueueSize());
//            System.out.println("coreSize" + threadPool.getCoreSize());
//            System.out.println("maxSize" + threadPool.getMaxSize());
//            System.out.println("=========================================");
//            TimeUnit.SECONDS.sleep(5L);
//        }
        TimeUnit.SECONDS.sleep(16L);
        System.out.println("do shut down");
        threadPool.shutdown();
//        Thread.currentThread().join();
    }
}
