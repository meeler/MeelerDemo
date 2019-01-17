package cn.meeler.简单线程池;

/**
 * 上限通知策略
 */
@FunctionalInterface
public interface DenyPolicy {
    void reject(Runnable runnable, ThreadPool threadPool);

    class DiscardDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            //do nothing
        }
    }

    class AbortDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDencyException("the runnale" + runnable + "will be abort");
        }
    }

    class RunnerDenyPolicy implements DenyPolicy {

        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutDown()) {
                runnable.run();
            }
        }
    }
}
