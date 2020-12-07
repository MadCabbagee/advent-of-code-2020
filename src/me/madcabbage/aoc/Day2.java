package me.madcabbage.aoc;

//How many passwords are valid according to their policies?
public class Day2 extends AocDay {

    public Day2() {
        super("Day2", "C:\\Users\\MadCabbage\\IdeaProjects\\advent-of-code-2020\\resources\\day2.input");
    }

    public void part1() {
        int total = 0;
        int valid = 0;

        for (String policy : stringInput) {
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

        System.out.println("\t" + valid + " passwords out of " + total + " are valid");
    }

    public void part2() {
        int total = 0;
        int valid = 0;

        for (String policy : stringInput) {
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

        System.out.println("\t" + valid + " passwords out of " + total + " are valid");
    }
}
