package com.Tec_BoyJ.Main;

import com.Tec_BoyJ.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\033[0;32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    static boolean run;

    public String[] file = new String[3];
    public Main(String fileLocation, String practiceLocation, String otherPerson) throws URISyntaxException {
        this.file[0] = practiceLocation;
        this.file[1] = fileLocation;
        this.file[2] = otherPerson;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Scanner scanner = new Scanner(System.in);
        //run = scanner.nextBoolean();
        run = true;
        if (run) {
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
        } else {
            int x = scanner.nextInt();
            switch (x) {
                case 1: Day1.main(args);break;
                case 2: Day2.main(args);break;
                case 3: Day3.main(args);break;
                case 4: Day4.main(args);break;
                case 5: Day5.main(args);break;
                case 6: Day6.main(args);break;
                case 7: Day7.main(args);break;
                case 8: Day8.main(args);break;
                case 9: Day9.main(args);break;
                case 10: Day10.main(args);break;
                case 11: Day11.main(args);break;
                case 12: Day12.main(args);break;
                case 13: Day13.main(args);break;
                //case 14: Day14.main(args);break;
                //case 15: Day15.main(args);break;
                //case 16: Day16.main(args);break;
                //case 17: Day17.main(args);break;
                //case 18: Day18.main(args);break;
                //case 19: Day19.main(args);break;
                //case 20: Day20.main(args);break;
                //case 21: Day21.main(args);break;
                //case 22: Day22.main(args);break;
                //case 23: Day23.main(args);break;
                //case 24: Day24.main(args);break;
                //case 25: Day25.main(args);break;
            }
        }
    }
    public String[] setUp(int f, String string) throws IOException {
        if (f == 0) System.out.println(ANSI_CYAN + "Example: ---------------------------------------- 95437" + ANSI_RESET);
        else if (f == 1) System.out.println(ANSI_CYAN + "Problem: ----------------------------------------" + ANSI_RESET);
        else System.out.println(ANSI_CYAN + "Other Person: -----------------------------------" + ANSI_RESET);

        File file = new File("Day.txt");
        Scanner scanner;
        if (run) scanner = new Scanner(getClass().getResource(string).openStream());
        else scanner = new Scanner(file);

        int length = 0;
        while (scanner.hasNextLine()) {
            length++;
            scanner.nextLine();
        }
        String[] arr = new String[length];

        int i = 0;
        if (run) scanner = new Scanner(getClass().getResource(string).openStream());
        else scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            arr[i] = scanner.nextLine();
            i++;
        }
        return arr;
    }
}
