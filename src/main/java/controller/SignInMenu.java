package controller;

import scanner.ScannerClass;
import services.UserService;

public class SignInMenu {
    public static void show()
    {
        System.out.println("userName: ");
        String userName = ScannerClass.getString();

        System.out.println("password: (first time is nationalCode) ");
        String password = ScannerClass.getString();

        UserService userService = new UserService();
        userService.SignInUser(userName,password);
    }
}
