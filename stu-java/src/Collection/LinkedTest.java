package Collection;

import java.util.LinkedList;

/**
 * @author Administrator
 */
public class LinkedTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        // 添加元素
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.toString());

        // 插入元素
        list.add(2,99);
        System.out.println(list);

        // 根据元素位置得到元素
        int element = list.get(2);
        System.out.println(element);

        // 得到元素的位置
        int index = list.indexOf(99);
        System.out.println(index);

        // 更新元素
        list.set(1,22);
        System.out.println(list.toString());

        //链表的长度
        int length = list.size();
        System.out.println(length);

        // 移除元素
        list.remove(3);
        System.out.println(list);
    }
}
