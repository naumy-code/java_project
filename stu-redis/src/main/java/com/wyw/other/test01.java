package com.wyw.other;

import java.io.*;
import java.util.zip.GZIPOutputStream;

/**
 * @author Administrator
 */
public class test01 {
    public static void main(String[] args) throws IOException {
        //new BufferedWriter(new FileWriter("a.txt"));
        //new BufferedReader(new FileInputStream("a.txt"));
        //new GZIPOutputStream(new FileOutputStream("a.zip"));
        //new ObjectlnputStream(new FilelnputStream("a.dat"));
        result(12);
    }

    public static int result(int number) {
        if (number > 1) {
            if (number % 2 != 0) {
                System.out.print(result(number + 1) / 2);
            }
            System.out.print(result(number / 2));
        }
        return number;
    }

}
