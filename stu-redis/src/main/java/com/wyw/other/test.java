package com.wyw.other;

class father {
    //int num = 4;
    void show() {
        System.out.print("father");
    }

}

class son extends father {
    //int num = 5;
    String id = "1234";

    public son(String id1) {
        id = id1;
    }

    void show() {
        System.out.print("son");
    }
}

public class test {
    public static void main(String[] args) {
        //father f = new son();
        son s = new son("000");
        //System.out.print(f.num);
        //System.out.print(s.num);
        //f.show();
        s.show();
    }
}
