package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.*;

public class Day5 {
    File file;
    File stack;

    public Day5(String fileLocation, String stackLocation) throws URISyntaxException {
        this.file = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
        this.stack = new File(Objects.requireNonNull(getClass().getResource(stackLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day5 main = new Day5("/Day5.txt", "/Day5 Stack.txt");



        //Moves ------------------------------------------------------
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



        //Stack ------------------------------------------------------
        Scanner scannerStack = new Scanner(main.stack);
        int lengthStack = 0;
        while (scannerStack.hasNextLine()) {
            lengthStack++;
            scannerStack.nextLine();
        }
        String[] arrStack = new String[lengthStack];

        int j = 0;
        scannerStack = new Scanner(main.stack);
        while (scannerStack.hasNextLine()) {
            arrStack[j] = scannerStack.nextLine();
            System.out.println(arrStack[j]);
            j++;
        }



        //Moving ------------------------------------------------------
        Stack[] stack = new Stack[9];
        for (int k = 0; k < 9; k++) {
            stack[k] = new Stack<String>();
        }

        int stackNum = 0;
        for (String s : arrStack) {
            if (Objects.equals(s, "") || s == null) {
                stackNum++;
            } else {
                stack[stackNum].add(s);
            }
        }
    }
}