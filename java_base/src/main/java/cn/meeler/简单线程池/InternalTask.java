package cn.meeler.简单线程池;

/**
 * 从RunnableQueue中获取Runnable
 */
public class InternalTask implements Runnable {
    private final RunnableQueue runnableQueue;
    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                Runnable take = runnableQueue.take();
                take.run();
            } catch (Exception e) {
                running = Boolean.FALSE;
                break;
            }
        }
    }

    public void stop() {
        running = false;
    }
}
