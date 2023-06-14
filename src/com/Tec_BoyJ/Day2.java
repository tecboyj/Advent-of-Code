package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;

import static com.Tec_BoyJ.Main.Main.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        //Main setup for all files
        Main main = new Main("/Tec_BoyJ/Problem/Day2.txt", "/Tec_BoyJ/Example/Day2 Practice.txt", "/Others/Day2.txt");
        for (int f = 0; f < main.file.length; f++) {
            String[] arr = main.setUp(f, main.file[f]);

            //Part 1

            int score = 0;
            for (String i : arr) {
                if (i.contains("X")) score++;
                if (i.contains("Y")) score += 2;
                if (i.contains("Z")) score += 3;

                if (i.contains("X") && i.contains("A")) score += 3;
                if (i.contains("Y") && i.contains("B")) score += 3;
                if (i.contains("Z") && i.contains("C")) score += 3;

                if (i.contains("X") && i.contains("C")) score += 6;
                if (i.contains("Y") && i.contains("A")) score += 6;
                if (i.contains("Z") && i.contains("B")) score += 6;
            }
            System.out.println(ANSI_GREEN + "Part 1: What you play --------------------" + ANSI_RESET);
            System.out.println(score);
            score = 0;

            //Part 2

            for (String i : arr) {
                if (i.contains("A") && i.contains("X")) score += 3;
                if (i.contains("B") && i.contains("X")) score++;
                if (i.contains("C") && i.contains("X")) score += 2;

                if (i.contains("A") && i.contains("Y")) score += 4;
                if (i.contains("B") && i.contains("Y")) score += 5;
                if (i.contains("C") && i.contains("Y")) score += 6;

                if (i.contains("A") && i.contains("Z")) score += 8;
                if (i.contains("B") && i.contains("Z")) score += 9;
                if (i.contains("C") && i.contains("Z")) score += 7;
            }
            System.out.println(ANSI_GREEN + "Part 2: Outcome --------------------" + ANSI_RESET);
            System.out.println(score);
        }
    }
}