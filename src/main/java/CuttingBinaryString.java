package main.java;

import java.io.IOException;

//https://www.geeksforgeeks.org/problems/cutting-binary-string1342/1
public class CuttingBinaryString {

    public static void main(String[] args) {
        String s = "";
        System.out.println(cuts(s));

        try {
            throw new RuntimeException(new IOException("ex"));
        }  catch (RuntimeException e) {
            System.out.println("ex caught ");
        }
    }

    public static int cuts(String s) {
        // code here
        return 0;
    }
}
