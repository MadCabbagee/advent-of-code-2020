package me.madcabbage.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        Day1 d1 = new Day1();

        Messages.printStartMsg("Expense file read");
        long start = System.currentTimeMillis();
        int[] expenses = d1.getExpenses();
        long end = System.currentTimeMillis();
        Messages.printRunTime(start, end, "Reading expenses file");

        Messages.printStartMsg("Part one");
        start = System.currentTimeMillis();
        d1.part1(expenses);
        end = System.currentTimeMillis();
        Messages.printRunTime(start, end, "Part one");

        Messages.printStartMsg("Part two");
        start = System.currentTimeMillis();
        d1.part2(expenses);
        end = System.currentTimeMillis();
        Messages.printRunTime(start, end, "Part two");
    }

    // find 2 numbers from the expenses file that add up to 2020 and print the product
    private void part1(int[] expenses) {
        for (int j = 0; j < expenses.length - 1; j++) {
            for (int k = j + 1; k < expenses.length; k++) {
                if (expenses[j] + expenses[k] == 2020) {
                    System.out.println(expenses[j] * expenses[k]);
                }
            }
        }
    }

    // find 3 numbers from the expenses file that add up to 2020 and print the product
    private void part2(int[] expenses) {
        for (int j = 0; j < expenses.length - 2; j++) {
            for (int k = j + 1; k < expenses.length - 1; k++) {
                for (int i = k + 1; i < expenses.length; i++) {
                    if (expenses[j] + expenses[k] + expenses[i] == 2020) {
                        System.out.println(expenses[j] * expenses[k] * expenses[i]);
                    }
                }
            }
        }
    }

    private int[] getExpenses() throws FileNotFoundException {
        File input = new File("C:\\Users\\MadCabbage\\IdeaProjects\\Advent of code\\resources\\day1.input");
        Scanner scan = new Scanner(input);
        int[] expenses = new int[200];

        int i = 0;
        while(scan.hasNextLine()) {
            expenses[i] = Integer.parseInt(scan.nextLine());
            i++;
        }
        scan.close();

        return expenses;
    }
}
