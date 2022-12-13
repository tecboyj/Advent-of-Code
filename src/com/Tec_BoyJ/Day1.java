package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;

import static com.Tec_BoyJ.Main.Main.*;
import static java.lang.Integer.parseInt;

public class Day1 {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Main main = new Main("/Tec_BoyJ/Day1.txt", "/Tec_BoyJ/Day1 Practice.txt", "/Day1.txt");
        for (int f = 0; f < main.file.length; f++) {
            String[] arr = Main.setUp(f, main.file[f]);
            int[] arr2 = new int[arr.length];

            int zero = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == null) arr[j] = "0";
                if (Objects.equals(arr[j], "")) arr[j] = "0";
                arr2[j] = parseInt(arr[j]);
                if (arr2[j] == 0) zero++;
            }

            int next = 0;
            zero++;

            int[] arr3 = new int[zero];
            for (int k : arr2) {
                if (k == 0) next++;
                arr3[next] += k;
            }

            int out1 = 0;
            int out2 = 0;
            int out3 = 0;

            for (int l : arr3) if (l > out1) out1 = l;
            for (int m : arr3) if (m > out2 && m != out1) out2 = m;
            for (int n : arr3) if (n > out3 && n != out2 && n != out1) out3 = n;

            int outTotal = out1 + out2 + out3;

            System.out.println(ANSI_GREEN + "Part 1: Elf with most snacks --------------------" + ANSI_RESET);
            System.out.println(out1);
            System.out.println(ANSI_GREEN + "Part 2: Top 3 elves total --------------------" + ANSI_RESET);
            System.out.println(out2);
            System.out.println(out3);
            System.out.println(outTotal);
        }
    }
}