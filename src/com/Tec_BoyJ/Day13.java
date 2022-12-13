package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.Tec_BoyJ.Main.Main.*;

public class Day13 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Main main = new Main("/Tec_BoyJ/Day13.txt", "/Tec_BoyJ/Day13 Practice.txt", "/Others/Day13.txt");
        for (int f = 0; f < main.file.length; f++) {
            String[] arr = main.setUp(f, main.file[f]);

            System.out.println(ANSI_GREEN + "Part 1: --------------------" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Part 2: --------------------" + ANSI_RESET);
        }
    }
}