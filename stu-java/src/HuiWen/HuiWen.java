package HuiWen;

import java.util.Stack;

/**
 * 判断是否为回文字符串
 * @author Administrator
 */
public class HuiWen {
    public static void main(String[] args) {
        System.out.println(f1("12321"));
        System.out.println(f2("abcba"));
        System.out.println(f3("Aa           bcb aA "));
    }

    /**
     * 通过数组的方式进行判断
     * 1.创建两个大小为字符串长度大小的数组
     * 2.对字符串转变为数组
     * 3.把久数组的值放入新数组中
     * 4.进行两个数组的判断
     * 注意：字符串有length()方法，而数组有length属性。
     * @param target
     * @return
     */
    private static boolean f1(String target) {
        char[] str = new char[target.length()];
        char[] newStr = new char[target.length()];
        target.getChars(0,target.length(),str,0);
        for (int i = 0; i < str.length; i++) {
            newStr[i] = str[str.length - 1 -i];
        }
        for (int i = 0; i < str.length; i++) {
            if (str[i] != newStr[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过栈的方式进行回文数判断
     * 1.首先创建一个栈
     * 2.对栈进行入栈，然后出栈
     * 3.进行判断
     * @param target
     * @return
     */
    public static boolean f2(String target) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < target.length(); i++) {
            stack.push(target.charAt(i));
            //System.out.println(target.charAt(i));
        }
        for (int i = 0; i < target.length(); i++) {
            Character character = stack.pop();
            if (character != target.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过指针的方式进行回文数判断
     * 1.首先去除输入字符串的空格,以及使所有的字符变成小写
     * 2.创建两个指针，一个头指针，一个尾指针
     * 3.进行判断
     * @param target
     * @return
     */

    public static boolean f3(String target) {
        String newTarget = target.replaceAll(" ","").toLowerCase();
        System.out.println(newTarget);
        int preIndex = -1;
        int lastIndex = newTarget.length();
        for (int i = 0; i < newTarget.length()/2; i++) {
            preIndex++;
            lastIndex--;
            if (newTarget.charAt(preIndex) != newTarget.charAt(lastIndex)) {
                return false;
            }
        }
        return true;
    }
}
