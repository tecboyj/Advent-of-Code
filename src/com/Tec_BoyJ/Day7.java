package com.Tec_BoyJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.*;

import static com.Tec_BoyJ.Main.Main.*;

public class Day7 {

    static HashMap<String, Directory> hashMap = new HashMap<>();
    static Directory[] directories;
    static Stack[] stackContainedDirectories;

    File[] file;
    public Day7(String fileLocation, String practiceLocation) throws URISyntaxException {
        this.file = new File[2];
        this.file[0] = new File(Objects.requireNonNull(getClass().getResource(practiceLocation)).toURI());
        this.file[1] = new File(Objects.requireNonNull(getClass().getResource(fileLocation)).toURI());
    }

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        Day7 main = new Day7("/Day7.txt", "/Day7 Practice.txt");

        for (int f = 0; f < main.file.length; f++) {
            if (f == 0) System.out.println(ANSI_CYAN + "Example: ---------------------------------------- 95437" + ANSI_RESET);
            //else System.out.println(ANSI_CYAN + "Problem: ----------------------------------------" + ANSI_RESET);
            else return;
            Scanner scanner = new Scanner(main.file[f]);

            int length = 0;
            while (scanner.hasNextLine()) {
                length++;
                scanner.nextLine();
            }
            String[] arr = new String[length];

            int i = 0;
            scanner = new Scanner(main.file[f]);
            while (scanner.hasNextLine()) {
                arr[i] = scanner.nextLine();
                i++;
            }


            // stuff

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
                else if (s.contains("dir")) stackContainedDirectories[newDirectory].add(s);
                stackNoDupe.add(s);
            }

            Stack stackNoDupeNames = new Stack<String>();
            for (int j = 0; j < directories.length; j++) {
                for (String s : arr) {
                    if (s.contains("cd") && !s.equals("$ cd ..") && !stackNoDupeNames.contains(s) && directories[j] == null) {
                        directories[j] = new Directory(s.substring(s.indexOf("cd") + 3), 0, false, j);
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


            for (int j = 0; j < directories.length; j++) {
                directories[j].containsDirectories = !stackContainedDirectories[j].empty();
            }
            for (int j = 0; j < directories.length; j++) {
                addSubDirectories(j);
            }

            int size = 0;
            for (Directory directory : directories) if (directory.size < 100000) size += directory.size;
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
    public static void addSubDirectories(int directory) {
        if (directories[directory].containsDirectories) {
            for (int k = 0; k < stackContainedDirectories[directory].size(); k++) {
                String transfer = (String) stackContainedDirectories[directory].pop();
                String dir = transfer.substring(transfer.indexOf("dir") + 4);
                if (hashMap.get(dir).containsDirectories) addSubDirectories(hashMap.get(dir).stack);
                directories[directory].size += hashMap.get(dir).size;
                directories[directory].containsDirectories = false;
            }
        }
    }

    private static class Directory {
        String name;
        int size;
        boolean containsDirectories;
        int stack;
        public Directory(String name, int size, boolean containsDirectories, int stack) {
            this.name = name;
            this.size = size;
            this.containsDirectories = containsDirectories;
            this.stack = stack;
        }
    }
}