package controller;

import domains.User;
import scanner.ScannerClass;
import services.UserService;

public class SignUpMenu {
    public static void showMenu() {
        System.out.println("userName: ");
        String userName = ScannerClass.getString();

        System.out.println("nationalCode: ");
        String nationalCode = ScannerClass.getString();

        System.out.println("BirthDay: ");
        String birthDay = ScannerClass.getString();

        System.out.println("Country: ");
        String country = ScannerClass.getString();

        System.out.println("City: ");
        String city = ScannerClass.getString();

        System.out.println("Street: ");
        String street = ScannerClass.getString();

        System.out.println("ZipCode: ");
        String zipCode = ScannerClass.getString();

        UserService userService = new UserService();
        User user = userService.signUpUser(userName, nationalCode, birthDay, country, city, street, zipCode);
        long userId = userService.SignInUser(user.getUsername(), user.getPassword());
        if (userId != 0) {
            UsersMenu.show(userId);
        }

    }
}
