package Other;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("hello   world!"));
    }
    public static String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        System.out.println(Arrays.toString(str));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) {
                continue;
            }
            stringBuilder.append(str[i] + " ");
        }
        return stringBuilder.toString().trim();
    }
}
