package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;
import java.util.Objects;

import static com.Tec_BoyJ.Main.Main.*;
import static java.lang.Integer.parseInt;

public class Day1 {
    public static void main(String[] args) throws IOException {
        //Main setup for all files
        Main main = new Main("/Tec_BoyJ/Problem/Day1.txt", "/Tec_BoyJ/Example/Day1 Practice.txt", "/Others/Day1.txt");
        for (int f = 0; f < main.file.length; f++) {
            String[] arr = main.setUp(f, main.file[f]);
            int[] arr2 = new int[arr.length];

            //Converting String[] to int[]
            int zero = 0;
            for (int i = 0; i < arr.length; i++) {
                if (Objects.equals(arr[i], "")) arr[i] = "0";
                arr2[i] = parseInt(arr[i]);
                if (arr2[i] == 0) zero++;
            }


            //Adding the calories together
            int next = 0;
            zero++;

            int[] arr3 = new int[zero];
            for (int k : arr2) {
                if (k == 0) next++;
                arr3[next] += k;
            }


            //Comparing who has the most calories

            int out1 = 0;
            int out2 = 0;
            int out3 = 0;

            for (int i : arr3) if (i > out1) out1 = i;
            for (int i : arr3) if (i > out2 && i != out1) out2 = i;
            for (int i : arr3) if (i > out3 && i != out2 && i != out1) out3 = i;

            int outTotal = out1 + out2 + out3;

            //Printing out the results

            System.out.println(ANSI_GREEN + "Part 1: Elf with most snacks --------------------" + ANSI_RESET);
            System.out.println(out1);
            System.out.println(ANSI_GREEN + "Part 2: Top 3 elves total --------------------" + ANSI_RESET);
            System.out.println(out2);
            System.out.println(out3);
            System.out.println(outTotal);
        }
    }
}