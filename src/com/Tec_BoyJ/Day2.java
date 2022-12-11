package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

import static com.Tec_BoyJ.Main.Main.ANSI_RESET;
import static com.Tec_BoyJ.Main.Main.ANSI_CYAN;
import static com.Tec_BoyJ.Main.Main.ANSI_GREEN;

public class Day2 {
    File[] file;
    public Day2(String fileLocation, String practiceLocation) throws URISyntaxException {
        this.file = new File[2];
        this.file[0] = new File(Objects.requireNonNull(getClass().getResource(practiceLocation)).toURI());
        this.file[1] = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day2 main = new Day2("/Day2.txt", "/Day2 Practice.txt");

        for (int f = 0; f < main.file.length; f++) {
            if (f == 0)
                System.out.println(ANSI_CYAN + "Example: ----------------------------------------" + ANSI_RESET);
            else System.out.println(ANSI_CYAN + "Problem: ----------------------------------------" + ANSI_RESET);
            Scanner scanner = new Scanner(main.file[f]);
            int score = 0;

            int length = 0;
            while (scanner.hasNextLine()) {
                length++;
                scanner.nextLine();
            }

            String[] arr = new String[length];

            scanner = new Scanner(main.file[f]);
            int i = 0;
            while (scanner.hasNextLine()) {
                arr[i] = scanner.nextLine();
                i++;
            }

            for (String j : arr) {
                if (j.contains("X")) score++;
                if (j.contains("Y")) score += 2;
                if (j.contains("Z")) score += 3;

                if (j.contains("X") && j.contains("A")) score += 3;
                if (j.contains("Y") && j.contains("B")) score += 3;
                if (j.contains("Z") && j.contains("C")) score += 3;

                if (j.contains("X") && j.contains("C")) score += 6;
                if (j.contains("Y") && j.contains("A")) score += 6;
                if (j.contains("Z") && j.contains("B")) score += 6;
            }
            System.out.println(ANSI_GREEN + "Part 1: What you play --------------------" + ANSI_RESET);
            System.out.println(score);
            score = 0;

            for (String k : arr) {
                if (k.contains("A") && k.contains("X")) score += 3;
                if (k.contains("B") && k.contains("X")) score++;
                if (k.contains("C") && k.contains("X")) score += 2;

                if (k.contains("A") && k.contains("Y")) score += 4;
                if (k.contains("B") && k.contains("Y")) score += 5;
                if (k.contains("C") && k.contains("Y")) score += 6;

                if (k.contains("A") && k.contains("Z")) score += 8;
                if (k.contains("B") && k.contains("Z")) score += 9;
                if (k.contains("C") && k.contains("Z")) score += 7;
            }
            System.out.println(ANSI_GREEN + "Part 2: Outcome --------------------" + ANSI_RESET);
            System.out.println(score);
        }
    }
}