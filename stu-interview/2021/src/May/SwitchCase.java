package May;

import java.util.*;

/**
 * 学习 Switch的使用
 * @author Administrator
 */
public class SwitchCase {
    public static void main(String[] args) {
        System.out.println(getValue(1));
    }

    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result += i;
            case 2:
                result += i * 2;
                break;
            case 3:
                result = result + i * 3;
        }
        return result;
    }
}
