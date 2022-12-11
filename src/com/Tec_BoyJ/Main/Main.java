package com.Tec_BoyJ.Main;

import com.Tec_BoyJ.*;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\033[0;32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        System.out.println(ANSI_RED + "Day 1: ------------------------------------------------------------" + ANSI_RESET);
        Day1.main(args);

        System.out.println(ANSI_RED + "Day 2: ------------------------------------------------------------" + ANSI_RESET);
        Day2.main(args);

        System.out.println(ANSI_RED + "Day 3: ------------------------------------------------------------" + ANSI_RESET);
        Day3.main(args);

        System.out.println(ANSI_RED + "Day 4: ------------------------------------------------------------" + ANSI_RESET);
        Day4.main(args);

        System.out.println(ANSI_RED + "Day 5: ------------------------------------------------------------" + ANSI_RESET);
        Day5.main(args);

        System.out.println(ANSI_RED + "Day 6: ------------------------------------------------------------" + ANSI_RESET);
        Day6.main(args);

    }
}
