package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class Day6 {
    File file;
    public Day6(String fileLocation) throws URISyntaxException {
        this.file = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day6 main = new Day6("/Day6.txt");
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

        int[] count = new int[length];
        for (int j = 0; j < arr.length; j++) {
            String[] split = arr[j].split("");
            String test = split[0];
            for (int k = 1; k < split.length; k++) {
                if (test.contains(split[k])) {
                    test += split[k];
                    count[j]++;
                } else {
                    break;
                }
            }


        }
        for (int j : count) {
            System.out.println(j);
        }


        /*

        //What GitHub Copilot wrote

        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            String[] split = arr[j].split("");
            for (int k = 0; k < split.length; k++) {
                boolean found = false;
                for (int l = 0; l < arr.length; l++) {
                    if (j != l) {
                        if (arr[l].contains(split[k])) {
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    count++;
                }
            }
        }
        System.out.println(count);

         */
    }
}