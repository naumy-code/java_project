package May;

//import cn.hutool.core.util.BooleanUtil;

import java.util.HashSet;

/**
 * @author Administrator
 * 玉柴学习  ，  使用hutool工具包进行开发
 */
public class YcTest {
    public static void main(String[] args) {
        t2();
    }

    static Boolean t1() {
        Boolean b = true;
        return b;
    }

    static void t2() {
        if (!t1()) {
            System.out.println("-----" + t1());
        }
        if (!t1()) {
            System.out.println("++++++" + t1());
        }
//        if (BooleanUtil.isTrue(t1())) {
//            System.out.println("======"+t1());
//        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1");
    }

}
