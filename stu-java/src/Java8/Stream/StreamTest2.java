package Java8.Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 *
 * Stream 终止操作
 * 1. -- 匹配与查找
 */
public class StreamTest2 {
    /**
     * 1. -- 匹配与查找
     */
    public static void main(String[] args) {
        test3();
    }
    public static void test1() {
        // allMath(Predicate p) -- 检查是否匹配所有元素
        // 练习：是否所有的员工的年龄大于18
        List<Employee> employees = EmployeeData.getEmployees();
        boolean allMatch = employees.stream().allMatch(m -> m.getAge() > 18);
        System.out.println(allMatch);

        // anyMath(Predicate p) -- 检查是否至少匹配一个元素
        // 练习：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        // noneMatch(Preaicate p) -- 检查是否没有匹配的元素。 练习：是否存在员工姓雷
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        // findFirst -- 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        // findAny -- 返回当前流的任意一个元素
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);

        // count-- 返回流中元素的总个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        // max（Comparator c） -- 返回流中的最大值
        Optional<Double> max = employees.stream().map(m -> m.getSalary()).max(Double::compareTo);
        System.out.println(max);

        // min（Comparator c） -- 返回流中的最小值 练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()));
        System.out.println(min);

        // foreach（Consumer c） -- 内部迭代
        employees.stream().forEach(System.out::println);

    }

    /**
     * 3.2 归约
     */
    public static void test2() {
        /**
         *  练习1 ：计算1-10 的自然数的和
         *  reduce（T identity ，BinaryOprator） 可以将流中元素反复结合起来，得到一个值。返回
         */
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = list.stream().reduce(0,Integer::sum);
        System.out.println(reduce);

        /**
         * 练习二：计算公司所有员工的工资
         */
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> doubleStream = employees.stream().map(Employee::getSalary);
        // Optional<Double> reduce1 = doubleStream.reduce(Double::sum);
        Optional<Double> reduce1 = doubleStream.reduce((d1,d2) -> d1 + d2);
        System.out.println(reduce1.get());
    }

    /**
     * 3.2 收集
     */
    public static void test3() {
        // collect(Collector c) -- 将流转换为其它形式，接受一个Collector接口的实现，用于给Stream中做元素汇总的方法
        List<Employee> employees2 = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = employees2.stream().filter(e -> e.getSalary() > 6000);
        System.out.println(employeeStream);
        System.out.println("*************************************************");

        /**
         *  练习一 ： 查找工资大于一的员工，结果返回一个list或者set
         */
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("**************************************************");
        List<Employee> employees1 = EmployeeData.getEmployees();
        Set<Employee> collect1 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        collect.forEach(System.out::println);


    }


}
