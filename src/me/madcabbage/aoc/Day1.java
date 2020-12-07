package me.madcabbage.aoc;

public class Day1 extends AocDay {

    public Day1() {
        super("Day1", "C:\\Users\\MadCabbage\\IdeaProjects\\advent-of-code-2020\\resources\\day1.input");
    }

    // find 2 numbers from the expenses file that add up to 2020 and print the product
    @Override
    public void part1() {
        int[] expenses = parseIntInput(stringInput);

        for (int j = 0; j < expenses.length - 1; j++) {
            for (int k = j + 1; k < expenses.length; k++) {
                if (expenses[j] + expenses[k] == 2020) {
                    System.out.println("\t" + expenses[j] * expenses[k]);
                }
            }
        }
    }

    // find 3 numbers from the expenses file that add up to 2020 and print the product
    @Override
    public void part2() {
        int[] intInput = parseIntInput(stringInput);

        for (int j = 0; j < intInput.length - 2; j++) {
            for (int k = j + 1; k < intInput.length - 1; k++) {
                for (int i = k + 1; i < intInput.length; i++) {
                    if (intInput[j] + intInput[k] + intInput[i] == 2020) {
                        System.out.println("\t" + intInput[j] * intInput[k] * intInput[i]);
                    }
                }
            }
        }

    }


}
