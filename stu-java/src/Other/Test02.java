package Other;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class Test02 {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,0,2,3,0,4,0,5,6,0};
        String str = "abcdefghijklmn";
        int i = 0;
        System.out.println(str.substring(0,2));

        for (int j = 0; j < 10; j++) {
            System.out.println(j);
        }


        System.out.println();
        //moveZeroes(arr);
        System.out.println(strStr("skkkk","kkk"));
    }
    public static void moveZeroes(int[] nums) {
        int i = 0,j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] =temp;
                i++;
            }
            j++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static int strStr(String haystack, String needle) {
        int L = haystack.length(), n = needle.length();
        for (int i = 0; i < L - n + 1; i++) {
            if (haystack.substring(i,i + n).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
