package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;

import static com.Tec_BoyJ.Main.Main.*;

public class Day3 {
    static int priorityValue = 0;
    static String[] alpha = new String[52];

    public static void main(String[] args) throws IOException {
        //Main setup for all files
        Main main = new Main("/Tec_BoyJ/Problem/Day3.txt", "/Tec_BoyJ/Example/Day3 Practice.txt", "/Others/Day3.txt");
        for (int f = 0; f < main.file.length; f++) {
            String[] arr = main.setUp(f, main.file[f]);

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
            case "a": priorityValue++; break;
            case "b": priorityValue += 2; break;
            case "c": priorityValue += 3; break;
            case "d": priorityValue += 4; break;
            case "e": priorityValue += 5; break;
            case "f": priorityValue += 6; break;
            case "g": priorityValue += 7; break;
            case "h": priorityValue += 8; break;
            case "i": priorityValue += 9; break;
            case "j": priorityValue += 10; break;
            case "k": priorityValue += 11; break;
            case "l": priorityValue += 12; break;
            case "m": priorityValue += 13; break;
            case "n": priorityValue += 14; break;
            case "o": priorityValue += 15; break;
            case "p": priorityValue += 16; break;
            case "q": priorityValue += 17; break;
            case "r": priorityValue += 18; break;
            case "s": priorityValue += 19; break;
            case "t": priorityValue += 20; break;
            case "u": priorityValue += 21; break;
            case "v": priorityValue += 22; break;
            case "w": priorityValue += 23; break;
            case "x": priorityValue += 24; break;
            case "y": priorityValue += 25; break;
            case "z": priorityValue += 26; break;
            case "A": priorityValue += 27; break;
            case "B": priorityValue += 28; break;
            case "C": priorityValue += 29; break;
            case "D": priorityValue += 30; break;
            case "E": priorityValue += 31; break;
            case "F": priorityValue += 32; break;
            case "G": priorityValue += 33; break;
            case "H": priorityValue += 34; break;
            case "I": priorityValue += 35; break;
            case "J": priorityValue += 36; break;
            case "K": priorityValue += 37; break;
            case "L": priorityValue += 38; break;
            case "M": priorityValue += 39; break;
            case "N": priorityValue += 40; break;
            case "O": priorityValue += 41; break;
            case "P": priorityValue += 42; break;
            case "Q": priorityValue += 43; break;
            case "R": priorityValue += 44; break;
            case "S": priorityValue += 45; break;
            case "T": priorityValue += 46; break;
            case "U": priorityValue += 47; break;
            case "V": priorityValue += 48; break;
            case "W": priorityValue += 49; break;
            case "X": priorityValue += 50; break;
            case "Y": priorityValue += 51; break;
            case "Z": priorityValue += 52; break;
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