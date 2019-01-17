package cn.meeler.简单线程池;

/**
 * 创建线程工厂
 */
@FunctionalInterface
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
