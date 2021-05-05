package Other;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        int[] arr1 = {1,2,2,2,3,4,5,6};
        reverseString(arr);
        System.out.println(removeDuplicates(arr1));
        //System.out.println(isFlipedString("sdf","fds"));
        //System.out.println(reverseString("asdfgh"));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s2 + s2;
        return s.contains(s1);
    }

    public static String reverseString1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }


    public  static void reverseString(char[] s) {
        int i = 0 , j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static int removeDuplicates(int[] nums) {
        // 1 2 2 2 3 4 5
        int i = 0, j = 0;
        while (j < nums.length) {
            if (i == 0 || nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }

}
