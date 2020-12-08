package me.madcabbage.aoc;

public class Day3 extends AocDay {

    public Day3(String inputPath) {
        super("Day3", inputPath);
    }

    @Override
    public void part1() {
        System.out.println("\tTrees encountered: " + getTrees(3,1));
    }

    @Override
    public void part2() {
        System.out.println("\t" +
                (long) getTrees(1, 1) *
                getTrees(3, 1) *
                getTrees(5, 1) *
                getTrees(7, 1) *
                getTrees(1, 2) );
    }

    private int getTrees(int right, int down) {
        int stringLength = 31;

        int treeCount = 0;
        int xPos = 0;
        for (int yPos = down; yPos < stringInput.size(); yPos += down) {
            xPos += right;

            if (xPos >= stringLength) {
                xPos = xPos - stringLength;
            }
            if (stringInput.get(yPos).charAt(xPos) == '#') {
                treeCount++;
            }
        }
        return treeCount;
    }
}
