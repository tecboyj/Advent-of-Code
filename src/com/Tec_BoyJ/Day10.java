package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

import static com.Tec_BoyJ.Main.Main.ANSI_RESET;
import static com.Tec_BoyJ.Main.Main.ANSI_CYAN;
import static com.Tec_BoyJ.Main.Main.ANSI_GREEN;

public class Day10 {
    File[] file;
    public Day10(String fileLocation, String practiceLocation) throws URISyntaxException {
        this.file = new File[2];
        this.file[0] = new File(Objects.requireNonNull(getClass().getResource(practiceLocation)).toURI());
        this.file[1] = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day10 main = new Day10("/Day10.txt", "/Day10 Practice.txt");

        for (int f = 0; f < main.file.length; f++) {
            if (f == 0)
                System.out.println(ANSI_CYAN + "Example: ----------------------------------------" + ANSI_RESET);
            else System.out.println(ANSI_CYAN + "Problem: ----------------------------------------" + ANSI_RESET);
            Scanner scanner = new Scanner(main.file[f]);

            int length = 0;
            while (scanner.hasNextLine()) {
                length++;
                scanner.nextLine();
            }
            String[] arr = new String[length];

            int i = 0;
            scanner = new Scanner(main.file[f]);
            while (scanner.hasNextLine()) {
                arr[i] = scanner.nextLine();
                i++;
            }
            System.out.println(ANSI_GREEN + "Part 1: --------------------" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Part 2: --------------------" + ANSI_RESET);
        }
    }
}