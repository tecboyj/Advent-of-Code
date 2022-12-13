package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.Tec_BoyJ.Main.Main.*;

public class Day2 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Main main = new Main("/Tec_BoyJ/Day2.txt", "/Tec_BoyJ/Day2 Practice.txt", "/Others/Day2.txt");
        for (int f = 0; f < main.file.length; f++) {
            String[] arr = main.setUp(f, main.file[f]);

            int score = 0;
            for (String j : arr) {
                if (j.contains("X")) score++;
                if (j.contains("Y")) score += 2;
                if (j.contains("Z")) score += 3;

                if (j.contains("X") && j.contains("A")) score += 3;
                if (j.contains("Y") && j.contains("B")) score += 3;
                if (j.contains("Z") && j.contains("C")) score += 3;

                if (j.contains("X") && j.contains("C")) score += 6;
                if (j.contains("Y") && j.contains("A")) score += 6;
                if (j.contains("Z") && j.contains("B")) score += 6;
            }
            System.out.println(ANSI_GREEN + "Part 1: What you play --------------------" + ANSI_RESET);
            System.out.println(score);
            score = 0;

            for (String k : arr) {
                if (k.contains("A") && k.contains("X")) score += 3;
                if (k.contains("B") && k.contains("X")) score++;
                if (k.contains("C") && k.contains("X")) score += 2;

                if (k.contains("A") && k.contains("Y")) score += 4;
                if (k.contains("B") && k.contains("Y")) score += 5;
                if (k.contains("C") && k.contains("Y")) score += 6;

                if (k.contains("A") && k.contains("Z")) score += 8;
                if (k.contains("B") && k.contains("Z")) score += 9;
                if (k.contains("C") && k.contains("Z")) score += 7;
            }
            System.out.println(ANSI_GREEN + "Part 2: Outcome --------------------" + ANSI_RESET);
            System.out.println(score);
        }
    }
}