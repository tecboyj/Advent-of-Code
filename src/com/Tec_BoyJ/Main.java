package com.Tec_BoyJ;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        Day1.main(args);
        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        Day2.main(args);
        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        Day3.main(args);
        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        Day4.main(args);
        System.out.println(ANSI_RED + "----------------------------------------" + ANSI_RESET);
        Day5.main(args);

    }
}
