package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;

import static com.Tec_BoyJ.Main.Main.*;

public class Day4 {
    public static void main(String[] args) throws IOException {
        Main main = new Main("/Tec_BoyJ/Problem/Day4.txt", "/Tec_BoyJ/Example/Day4 Practice.txt", "/Others/Day4.txt");

        for (int f = 0; f < main.file.length; f++) {
            String[] arr = main.setUp(f, main.file[f]);

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