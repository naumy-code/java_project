package Sort;

/**
 * @author Administrato0r
 * 进行冒泡排序的例子
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,-1,2,3};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
    }
}
