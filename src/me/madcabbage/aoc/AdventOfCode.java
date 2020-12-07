package me.madcabbage.aoc;

public class AdventOfCode {

    int aocDays = 25;

    public static void main(String[] args) {
        AdventOfCode aoc = new AdventOfCode();
        Menu menu = new Menu(aoc.createDays());
        menu.run();
    }

    private AocDay[] createDays() {
        return new AocDay[] {
                new Day1(),
                new Day2(),
                new Day3()
        };
    }
}
