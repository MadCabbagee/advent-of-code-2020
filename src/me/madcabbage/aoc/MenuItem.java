package me.madcabbage.aoc;

public class MenuItem {

    private final int menuPosition;
    private final AocDay day;
    private final String itemName;

    public MenuItem(int menuPosition, String itemName, AocDay day) {
        this.menuPosition = menuPosition;
        this.itemName = itemName;
        this.day = day;
    }

    public MenuItem(int menuPosition, String itemName) {
        this.menuPosition = menuPosition;
        this.itemName = itemName;
        this.day = null;
    }

    public int getMenuPosition() {
        return menuPosition;
    }

    public AocDay getDay() {
        return day;
    }

    public String getName() {
        return itemName;
    }

    @Override
    public String toString() {
        return menuPosition + ". " + itemName;
    }
}
