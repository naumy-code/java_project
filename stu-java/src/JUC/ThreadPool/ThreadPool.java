package JUC.ThreadPool;


import java.util.concurrent.*;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * ThreadPoolExecutor
 * @author naumy
 * 第四种获得/使用Java多线程的方式，线程池
 */
public class ThreadPool {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            // 模拟十个用户来办理业务，每个用户就是来自外部的请求线程
            for (int i = 0; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                // 暂停一会儿线程
                //try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }catch (Exception e) {
            e.getStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    /**
     * 线程池Executors创建线程池
     */
    private static void threadPoolInit() {
        // 获得当前电脑的电脑核数
        //System.out.println(Runtime.getRuntime().availableProcessors());
        // 一池5个处理线程
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        // 一池一线程
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 一池N个线程
        ExecutorService threadPool = newCachedThreadPool();

        try {
            // 模拟十个用户来办理业务，每个用户就是来自外部的请求线程
            for (int i = 0; i <= 20; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
                // 暂停一会儿线程
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            }

        }catch (Exception e) {
            e.getStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
