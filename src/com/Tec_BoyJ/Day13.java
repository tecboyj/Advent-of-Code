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

            for (int i = 0; i < list.length; i++) {
                if (list[i] != null) {
                    System.out.println(list[i]);
                } else System.out.println();
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

            //System.out.println(hashMap);

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
                if (l1.size() > l2.size()) part1 += mapHash.get(l1);
                else if (!(b || l1.isEmpty() || l2.isEmpty())) {
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
                    part1 += containsList(l1, l2, mapHash, map, i);
                } else if(l2.isEmpty() && !l1.isEmpty()) part1 += mapHash.get(l1);
            }
            System.out.println("13");
            System.out.println(part1);




            //System.out.println(ANSI_GREEN + "Part 1: --------------------" + ANSI_RESET);
            //System.out.println(ANSI_GREEN + "Part 2: --------------------" + ANSI_RESET);
        }
    }
    public static int containsList(List l1, List l2, LinkedHashMap<List, Integer> mapHash, LinkedHashMap<Integer, List> map, int m) {
        if (l1.size() == l2.size()) {
            for (int i = 0; i < l1.size(); i++) {
                String s1 = l1.get(i).toString();
                String s2 = l2.get(i).toString();
                //System.out.println(s1 + " " + s2);
                if (!(s1.contains("[") || s2.contains("[") || s1.equals("") || s2.equals(""))) {
                    int x1 = Integer.parseInt(s1);
                    int x2 = Integer.parseInt(s2);
                    if (x1 > x2) {
                        return m + 1;
                    }
                } else if (s1.equals("") || s2.equals("")) {
                    if (s2.equals("") && !s1.equals("")) {
                        return m + 1;
                    }
                } else {
                    String s3 = null;
                    String s4 = null;
                    if (s1.contains("[")) {
                        s3 = s1.substring(1, s1.length() - 1);
                    }
                    if (s2.contains("[")) {
                        s4 = s2.substring(1, s2.length() - 1);
                    }
                    List l3 = Arrays.asList(s3.split(","));
                    List l4 = Arrays.asList(s4.split(","));
                    return containsList(l3, l4, mapHash, map, i);
                }
            }
        }
        return 0;
    }
}