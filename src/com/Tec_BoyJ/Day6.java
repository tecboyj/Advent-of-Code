package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

import static com.Tec_BoyJ.Main.ANSI_RESET;
import static com.Tec_BoyJ.Main.ANSI_CYAN;
import static com.Tec_BoyJ.Main.ANSI_GREEN;

public class Day6 {
    File file;
    public Day6(String fileLocation) throws URISyntaxException {
        this.file = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day6 main = new Day6("/Day6.txt");
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

        System.out.println(ANSI_GREEN + "Part 1: 4 Unique characters" + ANSI_RESET);
        System.out.println();
        System.out.println("Corster100: ----------");

        for (String s : arr) {
            Corster100(s, 4);
        }
        System.out.println("Me: ----------");

        int[] count1 = new int[length];
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



        System.out.println();
        System.out.println(ANSI_GREEN + "Part 2: 14 Unique characters --------------------" + ANSI_RESET);
        System.out.println();
        System.out.println("Corster100: ----------");
        for (String s : arr) {
            Corster100(s, 14);
        }

        System.out.println("Me: ----------");

        int[] count2 = new int[length];
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