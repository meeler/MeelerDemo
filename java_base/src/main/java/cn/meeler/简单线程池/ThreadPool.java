package cn.meeler.简单线程池;

public interface ThreadPool {
    //提交任务到线程池
    void execute(Runnable runnable);

    //关闭线程
    void shutdown();

    //获取线程池的初始化大小
    int getInitSize();

    //获取线程核心数
    int getCoreSize();

    //获取线程池最大线程数
    int getMaxSize();

    //获取线程池中用于缓存任务队列的大小
    int getQueueSize();

    //获取线程池中活跃线程的数量
    int getActiveCount();

    //查看线程池中是否被shutdown
    boolean isShutDown();
}
