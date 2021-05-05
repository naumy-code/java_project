package Java8.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Administrator
 *
 * 1.
 * 1.1 stream 自己不会存储函数
 * 1.2 不会改变源对象，相反，他们会返回一个持有结果的新的stream
 * 1.3 stream 操作是延迟执行的，这意味这他们会等到需要结果的时候执行
 *
 * 2. Stream的执行流程
 * 2.1 Stream的实例化
 * 2.2 一系列的中间操作
 * 2.3 终止操作
 *
 *
 *3. 说明
 * 3.1 一个中间操作链，对数据源的数据进行处理
 * 3.2 一旦执行终止操作，就执行中间操作链，并产生结果，之后，不会再被使用
 *
 * 测似stream的实例化
 *
 */
public class StreamTest {

    public static void main(String[] args) {

    }

    /**
     *  创建 Stream方式一： 通过集合
      */
    public static void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //   default Stream<E> stream : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //    default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();

    }

    /**
     *  创建Stream方式二 ： 通过数组
      */
    public static void test2() {
        int[] arr = {1,2,3,4,5,6};
        // 调用Arrays类的static <T> Stream(T[] array): 返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"tom",10,200);
        Employee e2 = new Employee(1002,"tom",10,200);

        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    /**
     * 创建Stream方式三：  通过Stream的of（）
     */
    public static void test3() {
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5,6);
    }


    /**
     * 创建Stream方式四：创建无限流
     */
    public static void test4() {
        // 迭代
        // public statc<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)
        // 遍历前十个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);

        // 生成
        // public static<T> Stream<T> generate(<T> s) {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
     }
}
