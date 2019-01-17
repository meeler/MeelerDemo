package cn.meeler.简单线程池;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {
    private final int limit;
    private final DenyPolicy denyPolicy;
    private final ThreadPool threadPool;
    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void offer(Runnable runnable) {
        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                denyPolicy.reject(runnable, threadPool);
            } else {
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList) {
            while (runnableList.isEmpty()) {
                try {
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
