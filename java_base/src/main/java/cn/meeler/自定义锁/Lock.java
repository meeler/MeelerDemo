package cn.meeler.自定义锁;

import java.util.List;

public interface Lock {
    void locked() throws InterruptedException;
    void locked(Long time);
    void unlocked();
    List<Thread> getBlockedThreads();
}
