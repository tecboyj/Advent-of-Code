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
        Stack[] stackTemp1 = new Stack[9];
        Stack[] stackTemp2 = new Stack[9];
        for (int k = 0; k < 9; k++) {
            stackTemp1[k] = new Stack<String>();
            stackTemp2[k] = new Stack<String>();
        }

        int stackNumTemp = 0;
        for (String s : arrStack) {
            if (Objects.equals(s, "") || s == null) {
                stackNumTemp++;
            } else {
                stackTemp1[stackNumTemp].add(s);
                stackTemp2[stackNumTemp].add(s);
            }
        }


        Stack[] stack1 = new Stack[9];
        Stack[] stack2 = new Stack[9];
        for (int k = 0; k < 9; k++) {
            stack1[k] = new Stack<String>();
            stack2[k] = new Stack<String>();
        }

        for (int k = 0; k < 9; k++) {
            stack1[k] = reverse(stackTemp1[k]);
            stack2[k] = reverse(stackTemp2[k]);
        }



        //Moving CrateMover 9000 ------------------------------------------------------
        for (String s : arr) {
            int moves = Integer.parseInt(s.substring(s.indexOf("move") + 5, s.indexOf("from") - 1));
            int moveFromParse = Integer.parseInt(s.substring(s.indexOf("from") + 5, s.indexOf("to") - 1));
            int moveToParse = Integer.parseInt(s.substring(s.indexOf("to") + 3));
            int moveFrom = moveFromParse - 1;
            int moveTo = moveToParse - 1;

            for (int k = 0; k < moves; k++) {
                stack1[moveTo].add(stack1[moveFrom].pop());
            }
        }



        //Moving CrateMover 9001 ------------------------------------------------------
        Stack<Object> stackTransfer = new Stack<>();
        for (String s : arr) {
            int moves = Integer.parseInt(s.substring(s.indexOf("move") + 5, s.indexOf("from") - 1));
            int moveFromParse = Integer.parseInt(s.substring(s.indexOf("from") + 5, s.indexOf("to") - 1));
            int moveToParse = Integer.parseInt(s.substring(s.indexOf("to") + 3));
            int moveFrom = moveFromParse - 1;
            int moveTo = moveToParse - 1;

            for (int k = 0; k < moves; k++) {
                stackTransfer.add(stack2[moveFrom].pop());
            }
            while (!stackTransfer.isEmpty()) {
                stack2[moveTo].add(stackTransfer.pop());
            }
        }



        //Printing ------------------------------------------------------
        String out1 = "";
        String out2 = "";
        for (Stack value : stack1) {
            String peek = (String) value.peek();
            out1 += peek.substring(1, 2);
        }
        for (Stack value : stack2) {
            String peek = (String) value.peek();
            out2 += peek.substring(1, 2);
        }
        System.out.println(out1);
        System.out.println(out2);
    }

    public static Stack reverse(Stack stack) {
        Stack temp = new Stack();
        while (!stack.isEmpty()) {
            temp.add(stack.pop());
        }
        return temp;
    }
}