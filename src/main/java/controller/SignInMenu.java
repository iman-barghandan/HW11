package controller;

import scanner.ScannerClass;
import services.UserService;

public class SignInMenu {
    public static void show() {
        System.out.println("userName: ");
        String userName = ScannerClass.getString();

        System.out.println("password: (first time is nationalCode) ");
        String password = ScannerClass.getString();

        UserService userService = new UserService();
        long userId = userService.selectByUserNameAndPassword(userName, password);
        if (userId != 0) {
            UsersMenu.show(userId);
        }
        else System.out.println("You did not register");

    }
}
