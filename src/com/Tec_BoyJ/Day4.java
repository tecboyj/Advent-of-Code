package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class Day4 {
    File file;
    public Day4(String fileLocation) throws URISyntaxException {
        this.file = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day4 main = new Day4("/day4.txt");
        Scanner scanner = new Scanner(main.file);

        int length = 0;
        while (scanner.hasNextLine()) {
            length++;
            scanner.nextLine();
        }
        String[] arr = new String[length];

        int i = 0;
        scanner = new Scanner(main.file);
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
        System.out.println(count);
        System.out.println(count2);
    }
}