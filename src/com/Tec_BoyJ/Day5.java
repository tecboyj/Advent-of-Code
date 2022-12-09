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



        //Stack Array ------------------------------------------------------
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
            j++;
        }

        //Adding to Stack ------------------------------------------------------

        Stack[] stackTemp = new Stack[9];
        for (int k = 0; k < 9; k++) {
            stackTemp[k] = new Stack<String>();
        }

        int stackNumTemp = 0;
        for (String s : arrStack) {
            if (Objects.equals(s, "") || s == null) {
                stackNumTemp++;
            } else {
                stackTemp[stackNumTemp].add(s);
            }
        }


        Stack[] stack = new Stack[9];
        for (int k = 0; k < 9; k++) {
            stack[k] = new Stack<String>();
        }

        for (int k = 0; k < 9; k++) {
            stack[k] = reverse(stackTemp[k]);
        }


        //Moving ------------------------------------------------------
        for (String s : arr) {
            int moves = Integer.parseInt(s.substring(s.indexOf("move") + 5, s.indexOf("from") - 1));
            int moveFromParse = Integer.parseInt(s.substring(s.indexOf("from") + 5, s.indexOf("to") - 1));
            int moveToParse = Integer.parseInt(s.substring(s.indexOf("to") + 3));
            int moveFrom = moveFromParse - 1;
            int moveTo = moveToParse - 1;

            for (int k = 0; k < moves; k++) {
                stack[moveTo].add(stack[moveFrom].pop());
            }
        }

        //Printing ------------------------------------------------------

        String out = "";
        for (Stack value : stack) {
            String peek = (String) value.peek();
            out += peek.substring(1, 2);
        }
        System.out.println(out);
    }
    public static Stack reverse(Stack stack) {
        Stack temp = new Stack();
        while (!stack.isEmpty()) {
            temp.add(stack.pop());
        }
        return temp;
    }
}