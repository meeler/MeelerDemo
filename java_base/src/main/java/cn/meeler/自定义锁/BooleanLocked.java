package cn.meeler.自定义锁;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BooleanLocked implements Lock {
    private Thread currentThread;
    private Boolean locked = false;
    private List<Thread> blockedList = new ArrayList<>();
    private Integer count =0;
    @Override
    public void locked() throws InterruptedException {
        synchronized (this) {
            count++;
            System.out.println(count);
            System.out.println(Thread.currentThread().getName()+"进入到了sync方法中");
            System.out.println(locked);
            while (locked) {
                if (!blockedList.contains(Thread.currentThread())) {
                    blockedList.add(Thread.currentThread());

                }
                System.out.println(Thread.currentThread().getName()+"准备进入wait状态");
                this.wait();
            }
            blockedList.remove(Thread.currentThread());
            this.locked = Boolean.TRUE;
            this.currentThread = Thread.currentThread();

        }
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public void locked(Long time) {

    }

    @Override
    public void unlocked() {
        synchronized (this) {
            System.out.println(blockedList);
            if (currentThread == Thread.currentThread()) {
                this.locked = false;
                System.out.println(currentThread.getName() + "release lock");
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
