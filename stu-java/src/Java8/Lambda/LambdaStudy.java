package Java8.Lambda;


import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda表达式的使用举例
 *
 * 1.举例 (o1,o2) -> Integer.compare(o1,o2);
 * 2. 格式：
 *    -> lambda操作符 或 箭头操作符
 *    左边：lambda的形参列表 (其实就是接口中的抽象方法的形参列表 )
 *    右边：lambda抽象体 （其实就是抽象方法的方法体）
 * 3.lambda的使用
 *      3.1 无参 无返回值
 *      3.2 需要一个参数 无返回值
 *      3.3 类型推断
 *      3.4 lambda如果只有一个参数时，参数的小括号可以省略
 *      3.5 lambda如果有两个以上参数时候，多条中执行语句，有返回值
 *      3.6 lambda体如果只有一条语句，return与大括号若有，可以省略
 * 4.lambda表达式的本质：作为接口的实例
 *  接口的要求：函数式接口的实现
 * 5. 函数式接口 ：如果一个接口，只声明了一个抽象方法，则此接口就称为函数式接口。@FunctionalInterface可以用于检测是否为函数接口
 * 6. 所以以前用匿名实现类来实现的都可以用lambda表达式来实现。
 * @author Administrator
 */
public class LambdaStudy {
    public static void main(String[] args) {
        test02();
    }

    public static void test01() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        System.out.println("******************lambda改写");
        //lambda改写
        Runnable r2 = () -> {
            System.out.println("我爱北京故宫");
        };
        r2.run();
    }

    public static void test02() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(1,2);
        System.out.println(compare1);
        System.out.println("******************lambda改写");

        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        int compare2 = com2.compare(3,2);
        System.out.println(compare2);

        System.out.println("******************方法引用");
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(3,2);
        System.out.println(compare3);
    }

   public static void test2() {
       // 语法格式二: lambda 需要一个参数，但是没有返回值
       Consumer<String> con = new Consumer<String>() {
           @Override
           public void accept(String s) {
               System.out.println(s);
           }
       };
       con.accept("谎言与誓言的区别是什么呢?");

       // lambda改写
       Consumer<String> con1 = (String s) -> System.out.println(s);
       con1.accept("一个是听的人当真了，一个是说的人当真了！");
   }

   public static void test3() {
        // 类型推断
       Consumer<String> con1 = (s) -> {
           System.out.println(s);
       };
       con1.accept("一个是听的人当真了，一个是说的人当真了！");
   }

   public static void test4() {
       // lambda如果只有一个参数时，参数的小括号可以省略
       Consumer<String> con1 = s -> {
           System.out.println(s);
       };
       con1.accept("一个是听的人当真了，一个是说的人当真了！");
   }

   public static void test5() {
        // lambda如果有两个以上参数时候，多条中执行语句，有返回值
       Comparator<Integer> com1 = new Comparator<Integer>() {
           @Override
           public int compare(Integer o1,Integer o2) {
               return o1.compareTo(o2);
           }
       };
       System.out.println(com1.compare(12,21));

       System.out.println("*****************************");

       Comparator<Integer> com2 = (o1,o2) -> {
           System.out.println(o1);
           System.out.println(o2);
           return o1.compareTo(o2);
       };
       System.out.println(com2.compare(12,21));
   }

   // lambda体如果只有一条语句，return与大括号若有，可以省略
    public static void test6() {
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12,21));
    }

    public static void test7() {
        // 类型推断
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("一个是听的人当真了，一个是说的人当真了！");
    }

}

