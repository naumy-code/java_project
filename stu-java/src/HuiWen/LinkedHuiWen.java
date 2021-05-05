package HuiWen;

import java.util.Stack;

/**
 * 判断是否为回文
 * @author Administrator
 */
public class LinkedHuiWen {
    public static void main(String[] args) {
       Node head = new Node('a');
       Node b1 = new Node('b');
       Node b2 = new Node('a');
       Node b3 = new Node('b');
       Node b4 = new Node('a');

       head.next = b1;
       b1.next = b2;
       b2.next = b3;
       b3.next = b4;

       System.out.println(f2(head));
    }

    /**
     * 1.首先使用栈进行入栈
     * 2.进行出栈，并做比较
     * @param head
     * @return
     */
    static boolean f1(Node head) {
        Node ref = head;
        Stack<Character> stack = new Stack<>();
        while (ref != null){
            stack.push(ref.data);
            ref = ref.next;
        }

        ref = head;
        while (ref != null) {
            Character pop = stack.pop();
            if (pop != ref.data) {
                return false;
            }
            ref = ref.next;
        }
        return true;
    }

    /**
     * 使用快慢指针来解决这个回文
     * @param head
     * @return
     */
    public static boolean f2(Node head) {
        // 快指针一次走两步
        Node q = head;
        // 慢指针一次走一步
        Node s = head;
        while (q != null && q.next !=null) {
            q = q.next.next;
            s = s.next;
        }
        q = s;

        // 链表的原地反转
        Node temp = new Node(s.data);
        temp.next = s.next;

        while (temp.next != null) {
            Node pre = s;
            s = temp.next;
            temp.data = s.data;
            temp.next = s.next;
            s.next = pre;
        }

        q.next = null;
        q = head;
        while (q.next != null) {
            if (q.data != s.data) {
                return false;
            }
            q = q.next;
            s = s.next;
        }
        return true;
    }

    static class Node {
        public char data;
        public Node next;

        public Node(char data) {
            this.data = data;
        }
    }
}
