package com.Tec_BoyJ;

public class Testing {
    public static void main(String[] args) {
        String a = "move 2 from 5 to 7";
        String b = "move 21 from 4 to 71";

        int c = a.indexOf("from");
        int d = b.indexOf("from");

        String e = a.substring(c + 5, a.indexOf("to") - 1);

        System.out.println(a.indexOf("from"));
        System.out.println(b.indexOf("from"));

        System.out.println(e);
    }
}