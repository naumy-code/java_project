package Java8.optional;

import java.util.Optional;

/**
 * @author Administrator
 * Optional 为了再程序中避免空指针异常而出现
 *
 * 常用的方法： ofnullable(T t)
 *            ofElse(T t)
 *
 */
public class OptinalTest {
    public static void main(String[] args) {
        test4();
    }


    public static void test1() {
        /**
         *  Option.of(T t) : 创建一个Optional 实例，t必须非空
         *  Option.empty() : 船舰一个空的Optionl 实例
         *  Optional.ofNullable(T t) : t 可以为null
         */
        Girl girl = new Girl();
        Optional<Girl> girl1 = Optional.of(girl);


        girl = null;

        // ofnullable(T t) :t 可以为null
        Optional<Object> objectOptional = Optional.ofNullable(girl);
        System.out.println(girl1);
        // orelse(T t1):如果当前的optional内部封装的t是非空的，则返回内部的t
        // 如果内部的t是空的，则返回oeElse()方法参数中的t1.
        Object o = objectOptional.orElse(new Girl("赵丽颖",21));
        System.out.println(o);
    }

    public static void testt2() {
        Girl girl = new Girl();
        girl = null;
        Optional<Object> objectOptional = Optional.ofNullable(girl);
        System.out.println(objectOptional);
    }

    public static String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    /**
     * 会造成空指针异常
     */
    public static void test3() {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    /**
     * 优化后的方法
     */
    public static String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    /**
     * 优化后的方法 使用Optional类
     *
     */
    public static String getGirlName2(Boy boy) {
        Optional<Boy> boy1 = Optional.ofNullable(boy);

        // 此时boy1一定非空
        Boy boy2 = boy1.orElse(new Boy(new Girl("迪丽热巴",22)));

        Girl girl = boy2.getGirl();

        Optional<Girl> girl1 = Optional.ofNullable(girl);

        // 此时girl1一定非空
        Girl girl2 = girl1.orElse(new Girl("古力娜扎",23));

        return girl2.getName();
    }

    public static void test4() {
        Boy boy = null;

        Boy boy1 = new Boy();

        Boy boy2 = new Boy(new Girl("苍老师",23));
        String girlName = getGirlName2(boy2);
        System.out.println(girlName);
    }


}
