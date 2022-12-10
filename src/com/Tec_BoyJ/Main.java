package com.Tec_BoyJ;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        System.out.println("Day 1");
        System.out.println("--------------------");
        Day1.main(args);

        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        System.out.println("Day 2");
        System.out.println("--------------------");
        Day2.main(args);

        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        System.out.println("Day 3");
        System.out.println("--------------------");
        Day3.main(args);

        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        System.out.println("Day 4");
        System.out.println("--------------------");
        Day4.main(args);

        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        System.out.println("Day 5");
        System.out.println("--------------------");
        Day5.main(args);

        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        System.out.println("Day 6");
        System.out.println("--------------------");
        Day6.main(args);

    }
}
