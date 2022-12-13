package com.Tec_BoyJ.Main;

import com.Tec_BoyJ.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\033[0;32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    public File[] file;
    public Main(String fileLocation, String practiceLocation, String otherPerson) throws URISyntaxException {
        this.file = new File[3];
        this.file[0] = new File(Objects.requireNonNull(getClass().getResource(practiceLocation)).toURI());
        this.file[1] = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
        this.file[2] = new File(Objects.requireNonNull(getClass().getResource(otherPerson)).toURI());
    }

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
    public static String[] setUp(int f, File file) throws FileNotFoundException {
        if (f == 0) System.out.println(ANSI_CYAN + "Example: ---------------------------------------- 95437" + ANSI_RESET);
        else System.out.println(ANSI_CYAN + "Problem: ----------------------------------------" + ANSI_RESET);

        Scanner scanner = new Scanner(file);

        int length = 0;
        while (scanner.hasNextLine()) {
            length++;
            scanner.nextLine();
        }
        String[] arr = new String[length];

        int i = 0;
        scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            arr[i] = scanner.nextLine();
            i++;
        }
        return arr;
    }
}
