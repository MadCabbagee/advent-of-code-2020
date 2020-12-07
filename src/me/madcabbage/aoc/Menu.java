package me.madcabbage.aoc;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

    private boolean run;
    private final MenuItem[] options;
    /*private final AocDay[] days;*/

    public Menu(AocDay[] days) {
        run = false;
        /*this.days = days;*/
        this.options = getMenuItems(days);
    }

    public void run() {
        run = true;

        while (run) {
            showMenu();
            doSelection(getIntInput());
        }
    }

    private void doSelection(int selection) {
        for (MenuItem option : options) {
            if (option.getMenuPosition() == selection) {
                // if day is null that means this item is the exit item so we set run to false in order to stop running the menu loop
                if (option.getDay() == null) {
                    run = false;
                } else {
                    try {
                        option.getDay().run();
                    } catch (FileNotFoundException e) {
                        System.out.println("The input file for this day could not be found.");
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private int getIntInput() {
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextInt()) {
            return scan.nextInt();
        } else {
            System.out.println("Please enter the number beside your desired selection.");
            return getIntInput();
        }
    }

    private void showMenu() {
        System.out.println("Please make a selection from the menu below;");
        for (MenuItem item : options) {
            System.out.println("\t" + item);
        }
    }

    private MenuItem[] getMenuItems(AocDay[] days) {
        MenuItem[] items = new MenuItem[days.length + 1];
        int i = 0;
        for (AocDay day : days) {
            items[i] = new MenuItem(i+1, day.getName(), day);
            i++;
        }
        items[i] = new MenuItem(0, "Exit");
        return items;
    }
}
