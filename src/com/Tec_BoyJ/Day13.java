package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;
import java.util.*;

import static com.Tec_BoyJ.Main.Main.*;

public class Day13 {
    public static void main(String[] args) throws IOException {
        Main main = new Main("/Tec_BoyJ/Problem/Day13.txt", "/Tec_BoyJ/Example/Day13 Practice.txt", "/Others/Day13.txt");
        for (int f = 0; f < main.file.length; f++) {
            if (!(f == 0)) return;
            String[] arr = main.setUp(f, main.file[f]);
            List[] list = new List[arr.length];

            for (int i = 0; i < arr.length; i++) {
                if (!Objects.equals(arr[i], "")) {
                    arr[i] = arr[i].substring(1, arr[i].length() - 1);
                    list[i] = Arrays.asList(arr[i].split(","));
                }
            }

            System.out.println();
            LinkedHashMap<List, List> hashMap = new LinkedHashMap<>();
            LinkedHashMap<Integer, List> map = new LinkedHashMap<>();
            LinkedHashMap<List, Integer> mapHash = new LinkedHashMap<>();
            int count = 0;
            for (int i = 0; i < list.length; i++) {
                hashMap.put(list[i], list[i + 1]);
                map.put(count, list[i]);
                mapHash.put(list[i], count + 1);
                i += 2;
                count++;
            }

            System.out.println(mapHash);

            int part1 = 0;
            for (int i = 0; i < map.size(); i++) {
                List l1 = map.get(i);
                List l2 = hashMap.get(l1);
                boolean b = false;
                for (Object value : l1) {
                    String s1 = (String) value;
                    if (s1.contains("[") || s1.equals("")) {
                        b = true;
                        break;
                    }
                }
                for (Object o : l2) {
                    String s2 = (String) o;
                    if (s2.contains("[") || s2.equals("")) {
                        b = true;
                        break;
                    }
                }
                if (l1.size() != l2.size()) {
                    if (l1.size() > l2.size()) part1 += mapHash.get(l1);
                } else if (!(b || l1.isEmpty() || l2.isEmpty())) {
                    int x = 0;
                    for (int j = 0; j < l1.size(); j++) {
                        int x1 = Integer.parseInt(l1.get(j).toString());
                        int x2 = Integer.parseInt(l2.get(j).toString());
                        if (x1 > x2) {
                            part1 += mapHash.get(l1);
                            break;
                        }
                    }
                } else if (!(l1.isEmpty() || l2.isEmpty())) {
                    //
                } else part1 += mapHash.get(l1);
            }
            System.out.println(part1);




            //System.out.println(ANSI_GREEN + "Part 1: --------------------" + ANSI_RESET);
            //System.out.println(ANSI_GREEN + "Part 2: --------------------" + ANSI_RESET);
        }
    }
}