package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

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

        for (String s : arr) {
            Corster100(s);
        }
        System.out.println("--------------------");

        int[] count = new int[length];
        for (int j = 0; j < arr.length; j++) {
            int l = 0;
            while (true) {
                char[] check = arr[j].substring(l, l + 4).toCharArray();
                if (check[0] == check[1] || check[0] == check[2] || check[0] == check[3] || check[1] == check[2] || check[1] == check[3] || check[2] == check[3]) {
                    count[j]++;
                    l++;
                } else {
                    break;
                }
            }
        }

        for (int j : count) {
            j += 4;
            System.out.println(j);
        }



        /*
        //What GitHub Copilot wrote

        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            String[] split = arr[j].split("");
            for (int k = 0; k < split.length; k++) {
                boolean found = false;
                for (int l = 0; l < arr.length; l++) {
                    if (j != l) {
                        if (arr[l].contains(split[k])) {
                            found = true;
                            break;
                        }
                    }
                }
                if (!found) {
                    count++;
                }
            }
        }
        System.out.println(count);

         */
    }
    public static void Corster100(String str) {
        final int l = 4;
        char[] arr = str.substring(0, l).toCharArray();
        int s = l;
        while(s < str.length())
        {
            boolean mark = true;
            for(int x = 0; x < arr.length; x++)
            {
                for(int y = 0; y < arr.length; y++)
                {
                    if(arr[x] == arr[y] && x != y)
                    {
                        mark = false;
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