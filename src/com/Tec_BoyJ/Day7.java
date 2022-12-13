package com.Tec_BoyJ;

import com.Tec_BoyJ.Main.Main;

import java.io.IOException;
import java.util.*;

public class Day7 {
    static HashMap<String, Directory> hashMap = new HashMap<>();
    static Directory[] directories;
    static Stack[] stackContainedDirectories;

    public static void main(String[] args) throws IOException {
        Main main = new Main("/Tec_BoyJ/Day7.txt", "/Tec_BoyJ/Day7 Practice.txt", "/Others/Day7.txt");

        for (int f = 0; f < main.file.length; f++) {
            if (!(f == 0)) return;
            String[] arr = main.setUp(f, main.file[f]);

            Stack<String> stackNoDupe = new Stack<>();
            int directoryArr = 0;
            for (String s : arr) {
                if (s.contains("cd") && !s.equals("$ cd ..") && !stackNoDupe.contains(s)) {
                    directoryArr++;
                    stackNoDupe.add(s);
                }
            }
            directories = new Directory[directoryArr];
            Stack[] stackDirectories = new Stack[directoryArr];
            stackContainedDirectories = new Stack[directoryArr];
            for (int j = 0; j < directoryArr; j++) {
                stackDirectories[j] = new Stack<String>();
                stackContainedDirectories[j] = new Stack<String>();
            }

            stackNoDupe.clear();
            int newDirectory = -1;
            for (String s : arr) {
                if (s.contains("cd") && !s.equals("$ cd ..") && !stackNoDupe.contains(s)) newDirectory++;
                else if (numCheck(s)) stackDirectories[newDirectory].add(s);
                else if (s.contains("dir")) {
                    stackContainedDirectories[newDirectory].add(s);
                }
                stackNoDupe.add(s);
            }

            Stack stackNoDupeNames = new Stack<String>();
            for (int j = 0; j < directories.length; j++) {
                for (String s : arr) {
                    if (s.contains("cd") && !s.equals("$ cd ..") && !stackNoDupeNames.contains(s) && directories[j] == null) {
                        directories[j] = new Directory(s.substring(s.indexOf("cd") + 3), 0, j);
                        stackNoDupeNames.add(s);
                    }
                }
            }
            for (int j = 0; j < directories.length; j++) {
                for (int k = 0; k < stackDirectories[j].size(); k++) {
                    String transfer = (String) stackDirectories[j].pop();
                    directories[j].size += Integer.parseInt(transfer.substring(0, transfer.indexOf(" ")));
                }
            }
            hashDirectory(directories);

            int size = 0;
            for (Directory directory : directories) if (directory.size < 100000) size += directory.size;
            for (Stack stackContainedDirectory : stackContainedDirectories) {
                for (int k = 0; k < stackContainedDirectory.size(); k++) {
                    String transfer = (String) stackContainedDirectory.pop();
                    int index = hashMap.get(transfer.substring(transfer.indexOf("dir") + 4)).size;
                    if (index < 100000) size += index;
                }
            }
            System.out.println(size);
        }
    }

    public static boolean numCheck(String s) {
        //return s.contains(".") && !s.equals("$ cd ..");
        for (int i = 1; i < 10; i++) if (s.contains(String.valueOf(i))) return true;
        return false;
    }
    public static void hashDirectory(Directory[] directories) {
        for (Directory directory : directories) {
            hashMap.put(directory.name, directory);
        }
    }

    private static class Directory {
        String name;
        int size;
        int stack;
        public Directory(String name, int size, int stack) {
            this.name = name;
            this.size = size;
            this.stack = stack;
        }
    }
}