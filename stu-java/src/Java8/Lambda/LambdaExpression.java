package Java8.Lambda;

/**
 * 接口
 */
@FunctionalInterface
interface Foo {
    //public void sayHello();
    public int add(int x, int y);
    default int mul(int x,int y) {
        return x * y;
    }
    public static int div(int x,int y) {
        return x/y;
    }
}

/**
 * Java 中的Lambda表达式学习
 * @author Administrator
 * 1. 拷贝小括号， 写死右箭头， 落地大括号    函数式接口才能使用Lamda表达式
 * 2. @FunctionalInterface加了这个注解的接口，里面只能够有一个方法；
 * 3. default 可以定义多个default
 * 4. static  只能定义一个
 */
public class LambdaExpression {
    public static void main(String[] args) {
//        Foo foo = new Foo() {
//            @Override
//            public void sayHello() {
//                System.out.println("********hello 1205");
//            }
//
//            @Override
//            public int add(int x,int y) {
//                return 0;
//            }
//        };
//        foo.sayHello();

//        Foo foo1 = (int x, int y) -> {System.out.println("********hello 1205 Lamda Express");};
//        foo1.sayHello();

        Foo foo = (int x, int y) -> {
            System.out.println("comme in LamdaExpress add_method");
            return x + y;
        };
        System.out.println(foo.add(1,2));
        System.out.println(foo.mul(3,5));
        System.out.println(Foo.div(10,2));
    }
}
