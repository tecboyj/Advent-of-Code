package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day1 {
    File file;
    public Day1(String fileLocation) throws URISyntaxException {
        this.file = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day1 main = new Day1("/day1.txt");
        Scanner scanner = new Scanner(main.file);

        int length = 0;
        while (scanner.hasNextLine()) {
            length++;
            scanner.nextLine();
        }
        String[] arr = new String[length];
        int [] arr2 = new int[length];

        scanner = new Scanner(main.file);
        int i = 0;
        while (scanner.hasNextLine()) {
            arr[i] = scanner.nextLine();
            i++;
        }
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

        System.out.println(out1);
        System.out.println(out2);
        System.out.println(out3);
        System.out.println("--------------------");
        System.out.println(outTotal);
    }
}