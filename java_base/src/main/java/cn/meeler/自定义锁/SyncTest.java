package cn.meeler.自定义锁;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SyncTest{
   public void syncMethod(){
       synchronized (this){
           System.out.println(Thread.currentThread().getName()+"进入sync");
           try {
               TimeUnit.MINUTES.sleep(10L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }

    public static void main(String[] args) {
       SyncTest st = new SyncTest();
        IntStream.range(0,2).mapToObj(i-> new Thread(st::syncMethod)).forEach(Thread::start);
    }
}
