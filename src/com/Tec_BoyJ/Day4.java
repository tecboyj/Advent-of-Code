package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

import static com.Tec_BoyJ.Main.Main.*;

public class Day4 {
    File[] file;
    public Day4(String fileLocation, String practiceLocation) throws URISyntaxException {
        this.file = new File[2];
        this.file[0] = new File(Objects.requireNonNull(getClass().getResource(practiceLocation)).toURI());
        this.file[1] = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day4 main = new Day4("/Day4.txt", "/Day4 Practice.txt");

        for (int f = 0; f < main.file.length; f++) {
            if (f == 0) System.out.println(ANSI_CYAN + "Example: ----------------------------------------" + ANSI_RESET);
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

            int count = 0;
            int count2 = 0;

            for (String j : arr) {
                int index = j.indexOf(",");
                String half1 = j.substring(0, index);
                String half2 = j.substring(index + 1);
                int half1Index = half1.indexOf("-");
                int half2Index = half2.indexOf("-");

                int num1 = Integer.parseInt(half1.substring(0, half1Index));
                int num2 = Integer.parseInt(half1.substring(half1Index + 1));
                int num3 = Integer.parseInt(half2.substring(0, half2Index));
                int num4 = Integer.parseInt(half2.substring(half2Index + 1));

                if (num1 >= num3 && num2 <= num4 || num1 <= num3 && num2 >= num4) {
                    count++;
                }
                if (num1 <= num3 && num3 <= num2 && num4 > num2 || num3 <= num1 && num1 <= num4 && num2 > num4 || num1 >= num3 && num2 <= num4 || num1 <= num3 && num2 >= num4) {
                    count2++;
                }
            }
            System.out.println(ANSI_GREEN + "Part 1: How many contain another--------------------" + ANSI_RESET);
            System.out.println(count);
            System.out.println(ANSI_GREEN + "Part 2: How many overlap --------------------" + ANSI_RESET);
            System.out.println(count2);
        }
    }
}