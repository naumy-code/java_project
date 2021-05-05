package JUC.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 继承callable 接口
 */
class MyThreaad implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("*********************come in Callable");
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
        return 1024;
    }
}

/**
 * 1.Callable 接口有返回值 Runnable接口无返回值
 * 2.Callable 能抛出异常
 * 3.接口实现的方法不一样 一个是run 一个是call
 *
 */

/**
 * 学习线程池
 * @author Administrator
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 两个线程 一个是main线程，一个是AAfutureTask
        // Thread(Runnable target, String name) 分配一个新的 Thread对象。
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThreaad());
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThreaad());
        new Thread(futureTask,"AA").start();
        new Thread(futureTask2,"BB").start();
        //int result02 = futureTask.get();

        System.out.println(Thread.currentThread().getName()+"*****************");
        int result01 = 100;

//        while (!futureTask.isDone()) {
//
//        }

        // 如无必要建议放在最后，要求获得callable接口的获取结果，如果没有计算完成就要去强求，会导致堵塞，直到计算完成
        int result02 = futureTask.get();

        System.out.println("*******************Result is"+(result01 + result02));


    }

}
