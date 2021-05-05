package Java8.Lambda;

import java.util.function.Consumer;

/**
 * @author Administrator
 *
 * Java内置的四大函数式接口
 * 1. 消费型接口 Consumer<T> void accept(T t)
 * 2. 供给型接口 Supplier<T>   T get()
 * 3. 函数式接口 Function<T, R>   R apply(T t)
 * 4. 断定型接口 Predicate<T>     boolean test(T t)
 *
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        happyTime(500,new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("天上人间买了瓶矿泉水，价格为！！"+aDouble);
            }
        });
        happyTime(400,m -> System.out.println("学习太快乐了" + m));
    }

    public static void happyTime(double money,Consumer<Double> con) {
        con.accept(money);
    }
}
