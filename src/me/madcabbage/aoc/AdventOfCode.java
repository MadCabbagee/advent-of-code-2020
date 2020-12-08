package me.madcabbage.aoc;

public class AdventOfCode {

    public static void main(String[] args) {
        AdventOfCode aoc = new AdventOfCode();
        Menu menu = new Menu(aoc.createDays());
        menu.run();
    }

    private AocDay[] createDays() {
        return new AocDay[] {
                new Day1("C:\\Users\\MadCabbage\\IdeaProjects\\advent-of-code-2020\\resources\\day1.input"),
                new Day2("C:\\Users\\MadCabbage\\IdeaProjects\\advent-of-code-2020\\resources\\day2.input"),
                new Day3("C:\\Users\\MadCabbage\\IdeaProjects\\advent-of-code-2020\\resources\\day3.input"),
                new Day4("C:\\Users\\MadCabbage\\IdeaProjects\\advent-of-code-2020\\resources\\day4.input")
        };
    }
}
