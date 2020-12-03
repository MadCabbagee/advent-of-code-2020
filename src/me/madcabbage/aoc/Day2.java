package me.madcabbage.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//How many passwords are valid according to their policies?
public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        Day2 d2 = new Day2();
        String[] input = d2.getInput();
        d2.part1(input);

        d2.part2(input);
    }

    private void part1(String[] input) {
        Messages.printStartMsg("Part one");
        long start = System.currentTimeMillis();

        int total = 0;
        int valid = 0;

        for (String policy : input) {
            total++;
            String[] splitPolicy = policy.split(" ");
            String[] bounds = splitPolicy[0].split("-");
            int min = Integer.parseInt(bounds[0]);
            int max = Integer.parseInt(bounds[1]);
            char rule = splitPolicy[1].charAt(0);
            String pw = splitPolicy[2];
            int count = 0;
            for (int i = 0; i < pw.length(); i++) {
                if (pw.charAt(i) == rule) {
                    count++;
                }
            }
            if (count >= min && count <= max) {
                valid++;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(valid + " passwords out of " + total + " are valid");
        Messages.printRunTime(start, end, "Part one");

    }

    private void part2(String[] input) {
        Messages.printStartMsg("Part two");
        long start = System.currentTimeMillis();

        int total = 0;
        int valid = 0;

        for (String policy : input) {
            total++;
            String[] splitPolicy = policy.split(" ");
            String[] bounds = splitPolicy[0].split("-");
            int min = Integer.parseInt(bounds[0]);
            int max = Integer.parseInt(bounds[1]);
            char rule = splitPolicy[1].charAt(0);
            String pw = splitPolicy[2];
            int count = 0;
            if (pw.charAt(min - 1) == rule && pw.charAt(max - 1) != rule) {
                count++;
            }
            if (pw.charAt(min - 1) != rule && pw.charAt(max - 1) == rule) {
                count ++;
            }
            if (count == 1) {
                valid ++;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(valid + " passwords out of " + total + " are valid");
        Messages.printRunTime(start, end, "Part one");
    }

    private String[] getInput() throws FileNotFoundException {
        Messages.printStartMsg("Passwords file read");
        long start = System.currentTimeMillis();

        File input = new File("C:\\Users\\MadCabbage\\IdeaProjects\\Advent of code\\resources\\day2.input");
        Scanner scan = new Scanner(input);
        String[] pws = new String[1000];

        int lines = 0;
        int i = 0;
        while(scan.hasNextLine()) {
            pws[i] = scan.nextLine();
            lines++;
            i++;
        }
        long end = System.currentTimeMillis();
        scan.close();
        System.out.println(lines + " Lines read");
        Messages.printRunTime(start, end, "Reading passwords file");
        return pws;
    }
}
