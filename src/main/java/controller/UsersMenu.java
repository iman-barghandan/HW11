package controller;

import scanner.ScannerClass;

public class UsersMenu {
    public static void show(long userId)
    {
        int selectedNumber;
        while (true)
        {
            System.out.println("(1) create article\n" +
                    "(2) edit article\n" +
                    "(3) my articles\n" +
                    "(4) change my password\n" +
                    "(5) admin sections\n" +
                    "(6) exit");
            selectedNumber = ScannerClass.getNumber(1,6);
        }
    }
}
