package Java8.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Administrator
 *
 * 测试Stream的中间操作
 *
 *
 */
public class StreamTest1 {
    public static void main(String[] args) {
        test4();

    }

    /**
     * 1-筛选与切片
     */
    public static void test1() {
        // 1.1 filter(Predicate p)  -  接受lambda，从流中排除某些数据
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        // 员工表中大于7000的员工工资
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println("****************************************************");
        employees.stream().filter(m -> m.getSalary() > 8000).forEach(System.out::println);


        // 1.2 limit(n) -- 截断流，使其元素不超过给定数量
        employees.stream().limit(10).forEach(System.out::println);

        // 1.3 skip(n) -- 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个元素，则返回一个空流
        employees.stream().skip(44).forEach(System.out::println);

        // 1.4 distinct() -- 筛选，通过流生成元素的hashcode（）与equals（）去除重复元素
        employees.add(new Employee(1010,"刘情",20,800));
        employees.add(new Employee(1010,"刘情",22,800));
        employees.add(new Employee(1010,"刘情",20,800));
        employees.add(new Employee(1010,"刘情",20,800));
        employees.add(new Employee(1010,"刘情",20,800));

        employees.stream().distinct().forEach(System.out::println);
    }

    /**
     * 2. 映射
     */
    public static void test2() {
        // map(Function f) -- 接收一个函数作为参数，将元素转换为其它形式或提取信息，该函数会被应用到每个元素上，并将其映射为一个新的元素
        // 练习：获取员工姓名长度大于3的员工姓名
        // flatmap（Function f） -- 接受一个函数作为参数，将流中的每个值都转成另一个流，然后把所有的流连接成一个流
        List<String> list = Arrays.asList("a","bb","cc","dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name -> name.length() > 3).forEach(System.out::println);

        System.out.println("**************************************************");
        // 练习二
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest1::formStringStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println("***************************************************");
        Stream<Character> characterStream = list.stream().flatMap(StreamTest1::formStringStream);
        characterStream.forEach(System.out::println);

    }

    /**
     * 3. flatmap(function f) - 接受一个函数作为参数，将流中的每个值都换成另一个值，然后把所有流连接成一个新的流
     *
     */
    public static void test3() {
        ArrayList list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }

    /**
     * 将字符串中的多个字符构成的集合转换为对应的Stream的实例
     * @param str
     * @return
     */
    public static Stream<Character> formStringStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c: str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    /**
     * 3.
     * 3.1 sourted() - 自然排序
     */
    public static void test4() {
        // 自然排序
        List<Integer> list = Arrays.asList(12,43,65,34,87,0,-98,7);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        // 抛出异常，原因：Employee类没有实现Comparable接口
        //employees.stream().sorted().forEach(System.out::println);

        // sorted（Comparator com） -- 定制排序
        List<Employee> employeeList = EmployeeData.getEmployees();
        employeeList.stream().sorted((e1,e2) -> {
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(System.out::println);
    }



}
