package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;
import java.util.*;

import static com.Tec_BoyJ.Main.Main.*;

public class Day5 {
    public static void main(String[] args) throws IOException {
        Main main = new Main("/Tec_BoyJ/Problem/Day5.txt", "/Tec_BoyJ/Example/Day5 Practice.txt", "/Others/Day5.txt");
        Main stack = new Main("/Tec_BoyJ/Problem/Day5 Stack.txt", "/Tec_BoyJ/Example/Day5 Stack Practice.txt", "/Others/Day5 Stack.txt");
        Day5 day5 = new Day5();

        for (int f = 0; f < main.file.length; f++) {
            String[] arr = main.setUp(f, main.file[f]);


            //Stack Array ------------------------------------------------------
            Scanner scannerStack = day5.scanner(stack.file[f]);
            int lengthStack = 0;
            while (scannerStack.hasNextLine()) {
                lengthStack++;
                scannerStack.nextLine();
            }
            String[] arrStack = new String[lengthStack];

            int j = 0;
            int stackSize = 1;
            scannerStack = day5.scanner(stack.file[f]);
            while (scannerStack.hasNextLine()) {
                arrStack[j] = scannerStack.nextLine();
                if (arrStack[j].equals("") || arrStack[j] == null) stackSize++;
                j++;
            }


            //Adding to Stack ------------------------------------------------------
            Stack[] stackTemp1 = new Stack[stackSize];
            Stack[] stackTemp2 = new Stack[stackSize];
            for (int k = 0; k < stackSize; k++) {
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


            Stack[] stack1 = new Stack[stackSize];
            Stack[] stack2 = new Stack[stackSize];
            for (int k = 0; k < stackSize; k++) {
                stack1[k] = new Stack<String>();
                stack2[k] = new Stack<String>();
            }

            for (int k = 0; k < stackSize; k++) {
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
                out1 += peek.charAt(1);
            }
            for (Stack value : stack2) {
                String peek = (String) value.peek();
                out2 += peek.charAt(1);
            }
            System.out.println(ANSI_GREEN + "Part 1: Top crate letters; one at a time --------------------" + ANSI_RESET);
            System.out.println(out1);
            System.out.println(ANSI_GREEN + "Part 2: Top crate letters; multiple at a time --------------------" + ANSI_RESET);
            System.out.println(out2);

            for (Stack value : stack1) {
                value.clear();
            }
            for (Stack value : stack2) {
                value.clear();
            }
        }
    }

    public static Stack reverse(Stack stack) {
        Stack temp = new Stack();
        while (!stack.isEmpty()) {
            temp.add(stack.pop());
        }
        return temp;
    }

    public Scanner scanner(String string) throws IOException {
        return new Scanner(getClass().getResource(string).openStream());
    }
}