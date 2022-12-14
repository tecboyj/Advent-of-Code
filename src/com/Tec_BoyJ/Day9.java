package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;

import static com.Tec_BoyJ.Main.Main.*;

public class Day9 {
    public static void main(String[] args) throws IOException {
        Main main = new Main("/Tec_BoyJ/Problem/Day9.txt", "/Tec_BoyJ/Example/Day9 Practice.txt", "/Others/Day9.txt");

        for (int f = 0; f < main.file.length; f++) {
            String[] arr = main.setUp(f, main.file[f]);
            System.out.println(ANSI_GREEN + "Part 1: --------------------" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Part 2: --------------------" + ANSI_RESET);
        }
    }
}