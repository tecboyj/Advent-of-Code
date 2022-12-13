package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static com.Tec_BoyJ.Main.Main.*;

public class Day6 {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Main main = new Main("/Tec_BoyJ/Day6.txt", "/Tec_BoyJ/Day6 Practice.txt", "/Day6.txt");

        for (int f = 0; f < main.file.length; f++) {
            String[] arr = Main.setUp(f, main.file[f]);

            System.out.println(ANSI_GREEN + "Part 1: 4 Unique characters" + ANSI_RESET);
            System.out.println("Corster100: ----------");

            for (String s : arr) {
                Corster100(s, 4);
            }
            System.out.println("Me: ----------");

            int[] count1 = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                int l = 0;
                while (true) {
                    char[] check = arr[j].substring(l, l + 4).toCharArray();
                    if (check[0] == check[1] || check[0] == check[2] || check[0] == check[3] || check[1] == check[2] || check[1] == check[3] || check[2] == check[3]) {
                        count1[j]++;
                        l++;
                    } else break;
                }
            }

            for (int j : count1) {
                j += 4;
                System.out.println(j);
            }


            System.out.println(ANSI_GREEN + "Part 2: 14 Unique characters --------------------" + ANSI_RESET);
            System.out.println("Corster100: ----------");
            for (String s : arr) {
                Corster100(s, 14);
            }

            System.out.println("Me: ----------");

            int[] count2 = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                int l = 0;
                while (true) {
                    char[] check = arr[j].substring(l, l + 14).toCharArray();
                    boolean mark = true;
                    for (int k = 0; k < check.length; k++) {
                        for (int m = 0; m < check.length; m++) {
                            if (k != m && check[k] == check[m]) {
                                mark = false;
                            }
                        }
                    }
                    if (mark) break;
                    else {
                        count2[j]++;
                        l++;
                    }
                }
            }

            for (int j : count2) {
                j += 14;
                System.out.println(j);
            }
        }
    }
    public static void Corster100(String str, final int l) {
        char[] arr = str.substring(0, l).toCharArray();
        int s = l;
        while(s < str.length())
        {
            boolean mark = true;
            for(int x = 0; x < arr.length; x++)
            {
                for(int y = 0; y < arr.length; y++)
                {
                    if (arr[x] == arr[y] && x != y) {
                        mark = false;
                        break;
                    }
                }
            }
            if(mark)
            {
                break;
            }
            else
            {
                for(int x = 0; x < l - 1; x++)
                {
                    arr[x] = arr[x + 1];
                }
                arr[l - 1] = str.charAt(s);
            }
            s++;
        }
        System.out.println(s);
    }
}