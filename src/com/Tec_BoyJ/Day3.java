package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

import static com.Tec_BoyJ.Main.ANSI_RESET;
import static com.Tec_BoyJ.Main.ANSI_CYAN;
import static com.Tec_BoyJ.Main.ANSI_GREEN;

public class Day3 {
    static int priorityValue = 0;
    static String[] alpha = new String[52];


    File[] file;
    public Day3(String fileLocation, String practiceLocation) throws URISyntaxException {
        this.file = new File[2];
        this.file[0] = new File(Objects.requireNonNull(getClass().getResource(practiceLocation)).toURI());
        this.file[1] = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day3 main = new Day3("/Day3.txt", "/Day3 Practice.txt");

        for (int f = 0; f < main.file.length; f++) {
            if (f == 0)
                System.out.println(ANSI_CYAN + "Example: ----------------------------------------" + ANSI_RESET);
            else System.out.println(ANSI_CYAN + "Problem: ----------------------------------------" + ANSI_RESET);
            Scanner scanner = new Scanner(main.file[f]);

            int length = 0;
            while (scanner.hasNextLine()) {
                length++;
                scanner.nextLine();
            }
            String[] arr = new String[length];

            scanner = new Scanner(main.file[f]);
            int i = 0;
            while (scanner.hasNextLine()) {
                arr[i] = scanner.nextLine();
                i++;
            }

            charArray();

            for (String j : arr) {
                int rucksack = j.length() / 2;
                String half1 = j.substring(0, rucksack);
                String half2 = j.substring(rucksack);

                String string = null;

                for (int k = 0; k < 52; k++) {
                    if (half1.contains(alpha[k]) && half2.contains(alpha[k])) {
                        string = alpha[k];
                        break;
                    }
                }

                assert string != null;
                priorityValue(string);
            }
            System.out.println(ANSI_GREEN + "Part 1: Priority value of matching items --------------------" + ANSI_RESET);
            System.out.println(priorityValue);
            priorityValue = 0;

            int group = 0;
            for (int l = 0; l < arr.length / 3; l++) {
                String string = null;
                for (String m : alpha) {
                    if (arr[group].contains(m) && arr[group + 1].contains(m) && arr[group + 2].contains(m)) {
                        string = m;
                        break;
                    }
                }
                assert string != null;
                priorityValue(string);
                group += 3;
            }
            System.out.println(ANSI_GREEN + "Part 2: Priority value of elf groups --------------------" + ANSI_RESET);
            System.out.println(priorityValue);
        }
    }

    public static void priorityValue(String string) {
        switch (string) {
            case "a" -> priorityValue++;
            case "b" -> priorityValue += 2;
            case "c" -> priorityValue += 3;
            case "d" -> priorityValue += 4;
            case "e" -> priorityValue += 5;
            case "f" -> priorityValue += 6;
            case "g" -> priorityValue += 7;
            case "h" -> priorityValue += 8;
            case "i" -> priorityValue += 9;
            case "j" -> priorityValue += 10;
            case "k" -> priorityValue += 11;
            case "l" -> priorityValue += 12;
            case "m" -> priorityValue += 13;
            case "n" -> priorityValue += 14;
            case "o" -> priorityValue += 15;
            case "p" -> priorityValue += 16;
            case "q" -> priorityValue += 17;
            case "r" -> priorityValue += 18;
            case "s" -> priorityValue += 19;
            case "t" -> priorityValue += 20;
            case "u" -> priorityValue += 21;
            case "v" -> priorityValue += 22;
            case "w" -> priorityValue += 23;
            case "x" -> priorityValue += 24;
            case "y" -> priorityValue += 25;
            case "z" -> priorityValue += 26;
            case "A" -> priorityValue += 27;
            case "B" -> priorityValue += 28;
            case "C" -> priorityValue += 29;
            case "D" -> priorityValue += 30;
            case "E" -> priorityValue += 31;
            case "F" -> priorityValue += 32;
            case "G" -> priorityValue += 33;
            case "H" -> priorityValue += 34;
            case "I" -> priorityValue += 35;
            case "J" -> priorityValue += 36;
            case "K" -> priorityValue += 37;
            case "L" -> priorityValue += 38;
            case "M" -> priorityValue += 39;
            case "N" -> priorityValue += 40;
            case "O" -> priorityValue += 41;
            case "P" -> priorityValue += 42;
            case "Q" -> priorityValue += 43;
            case "R" -> priorityValue += 44;
            case "S" -> priorityValue += 45;
            case "T" -> priorityValue += 46;
            case "U" -> priorityValue += 47;
            case "V" -> priorityValue += 48;
            case "W" -> priorityValue += 49;
            case "X" -> priorityValue += 50;
            case "Y" -> priorityValue += 51;
            case "Z" -> priorityValue += 52;
        }
    }
    public static void charArray() {
        alpha[0] = "a";
        alpha[1] = "b";
        alpha[2] = "c";
        alpha[3] = "d";
        alpha[4] = "e";
        alpha[5] = "f";
        alpha[6] = "g";
        alpha[7] = "h";
        alpha[8] = "i";
        alpha[9] = "j";
        alpha[10] = "k";
        alpha[11] = "l";
        alpha[12] = "m";
        alpha[13] = "n";
        alpha[14] = "o";
        alpha[15] = "p";
        alpha[16] = "q";
        alpha[17] = "r";
        alpha[18] = "s";
        alpha[19] = "t";
        alpha[20] = "u";
        alpha[21] = "v";
        alpha[22] = "w";
        alpha[23] = "x";
        alpha[24] = "y";
        alpha[25] = "z";
        alpha[26] = "A";
        alpha[27] = "B";
        alpha[28] = "C";
        alpha[29] = "D";
        alpha[30] = "E";
        alpha[31] = "F";
        alpha[32] = "G";
        alpha[33] = "H";
        alpha[34] = "I";
        alpha[35] = "J";
        alpha[36] = "K";
        alpha[37] = "L";
        alpha[38] = "M";
        alpha[39] = "N";
        alpha[40] = "O";
        alpha[41] = "P";
        alpha[42] = "Q";
        alpha[43] = "R";
        alpha[44] = "S";
        alpha[45] = "T";
        alpha[46] = "U";
        alpha[47] = "V";
        alpha[48] = "W";
        alpha[49] = "X";
        alpha[50] = "Y";
        alpha[51] = "Z";
    }
}