package me.madcabbage.aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AocDay {

    private final String name;
    private final String inputFilePath;
    protected List<String> stringInput;

    public abstract void part1();
    public abstract void part2();

    AocDay (String name, String inputFilePath) {
        this.name = name;
        this.inputFilePath = inputFilePath;
    }

    public void run() throws FileNotFoundException {
        System.out.println("Running " + name + "...\n");
        // Read file and record run time
        Messages.printStartMsg("file read");
        long start = System.currentTimeMillis();
        this.stringInput = getInput(inputFilePath);
        long end = System.currentTimeMillis();
        Messages.printRunTime(start, end, "Reading file");

        // Run part one and record run time
        Messages.printStartMsg("Part one");
        start = System.currentTimeMillis();
        part1();
        end = System.currentTimeMillis();
        Messages.printRunTime(start, end, "Part one");

        // Run part two and record run time
        Messages.printStartMsg("Part two");
        start = System.currentTimeMillis();
        part2();
        end = System.currentTimeMillis();
        Messages.printRunTime(start, end, "Part two");
    }

    protected List<String> getInput(String path) throws FileNotFoundException {
        File inputFile = new File(path);
        Scanner scan = new Scanner(inputFile);
        List<String> input = new ArrayList<>();

        int lines = 0;
        while(scan.hasNextLine()) {
            lines++;
            input.add(scan.nextLine());
        }
        scan.close();
        System.out.println("\t" + lines + " Lines read");

        return input;
    }

    protected int[] parseIntInput(List<String> input) {
        int[] intInput = new int[input.size()];
        int i = 0;
        for (String inString : input) {
            intInput[i] = Integer.parseInt(inString);
            i++;
        }
        return intInput;
    }

    public String getName() {
        return this.name;
    }
}
