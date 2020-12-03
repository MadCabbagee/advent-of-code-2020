package me.madcabbage.aoc;

import javax.print.DocFlavor;

public class Messages {

    public static void printStartMsg(String task) {
        System.out.println(task + " is starting...");
    }

    public static void printRunTime(long start, long end, String taskName) {
        System.out.println(taskName + " took " + (end - start) + "ms\n");
    }
}
