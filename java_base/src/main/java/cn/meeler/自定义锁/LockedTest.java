package cn.meeler.自定义锁;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;

public class LockedTest {

    private BooleanLocked lock = new BooleanLocked();

    public void syncMethod() {
        try {
            lock.locked();
            int i = current().nextInt(10);
            System.out.println(Thread.currentThread().getName() + " get locked");
            TimeUnit.SECONDS.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlocked();
        }
    }

    public static void main(String[] args) {
        LockedTest lt = new LockedTest();
        IntStream.range(0, 10).mapToObj(i -> new Thread(lt::syncMethod)).forEach(Thread::start);
    }
}
