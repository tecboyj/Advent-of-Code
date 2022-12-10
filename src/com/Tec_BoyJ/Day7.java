package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

import static com.Tec_BoyJ.Main.ANSI_RESET;
import static com.Tec_BoyJ.Main.ANSI_CYAN;
import static com.Tec_BoyJ.Main.ANSI_GREEN;

public class Day7 {
    File[] file;
    public Day7(String fileLocation, String practiceLocation) throws URISyntaxException {
        this.file = new File[2];
        this.file[0] = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
        this.file[1] = new File(Objects.requireNonNull(getClass().getResource(practiceLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
    Day7 main = new Day7("/Day7.txt", "/Day7 Practice.txt");
        Scanner scanner = new Scanner(main.file[0]);

        int length = 0;
        while (scanner.hasNextLine()) {
            length++;
            scanner.nextLine();
        }
        String[] arr = new String[length];

        int i = 0;
        scanner = new Scanner(main.file[0]);
        while (scanner.hasNextLine()) {
            arr[i] = scanner.nextLine();
            i++;
        }

        Stack<String> stack = new Stack<>();
        int size = 0;
        for (String s : arr) {
            if (numCheck(s) && !stack.contains(s)) {
                stack.add(s);
                int fileSize = Integer.parseInt(s.substring(0, s.indexOf(" ")));
                if (fileSize <= 100000) {
                    size += fileSize;
                }
            }
        }
        System.out.println(ANSI_GREEN + "Part 1: Size of directory's --------------------" + ANSI_RESET);
        System.out.println(size);
    }
    public static boolean numCheck(String s) {
        return s.contains(".") && !s.equals("$ cd ..");
        //for (int i = 1; i < 10; i++) if (s.contains(String.valueOf(i))) return true; else return false;
    }
}