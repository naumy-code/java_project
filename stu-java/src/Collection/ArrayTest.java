package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Administrator
 */
public class ArrayTest {
    public static void main(String[] args) {
        // 1.创建数组
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[]{1,2,3};
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = i+1;
        }
        System.out.println(Arrays.toString(arr2));

        // 2.通过Arraylist创建数组
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i + 1);
        };
        System.out.println(list);

        // 添加元素
        list.add(99);
        System.out.println(list);

        // 特定位置添加元素
        list.add(3,88);
        System.out.println(list);

        // 根据下标查找元素
        int num = arr1[1];
        int num1 = list.get(1);
        System.out.println(num);
        System.out.println(num1);

        // 更新元素
        arr1[1] = 11;
        list.set(1,11);
        System.out.println(Arrays.toString(arr1));
        System.out.println(list);

        // 移除元素
        list.remove(1);
        System.out.println(list);

        // 数组长度
        int length = arr.length;
        int length1 = list.size();
        System.out.println(length);
        System.out.println(length1);

        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 查找一个元素
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println("we fonud 1 in this string");
            }
        }

        // 从查找一个元素是否正在数组中
        boolean is1 = list.contains(1);
        System.out.println("we are found?" + is1);

        // 对数组进行排序
        int[] c = {2,3,1};
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(1);
        System.out.println(Arrays.toString(c));
        System.out.println(list1);

        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        Collections.sort(list1);
        System.out.println(list1);

        // 使数组倒序
        Collections.sort(list1,Collections.reverseOrder());
        System.out.println(list1);
    }
}
