package test;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ThreadYield {
    public static void main(String[] args) {
        List<?> collect = Arrays.asList(Arrays.asList("aaa"), Arrays.asList("bbb")).stream().flatMap(f -> p(f)).collect(toList());
        System.out.println(collect);
        IntStream.range(0, 1).mapToObj(ThreadYield::create).forEach(ThreadYield::start);
        try {
            TimeUnit.SECONDS.sleep(600L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Stream<?> p(List<String> f) {
        Stream<String> stream = f.stream();
        stream.forEach(k-> System.out.println(f));
        System.out.println(f.stream());
        return f.stream();
    }


//    private static Object p(Object f) {
//        System.out.println(f);
//        return f;
//    }

    private static void start(Thread thread) {
        thread.start();
        long id = thread.getId();
        System.out.println(id);
    }

    private static Thread create(int index) {

        return new Thread(() -> {
            if (index == 1) {
                Thread.yield();
            }
            System.out.println(index);
            try {
                TimeUnit.SECONDS.sleep(600L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "meeler" + index);
    }
}
