package controller;

import controller.admins.AdminsMenu;
import domains.User;
import scanner.ScannerClass;
import services.UserService;

public class UsersMenu {
    public static void show(long userId) {
        UserService userService = new UserService();
        int selectedNumber;
        while (true) {
            System.out.println("(1) create article\n" +
                    "(2) edit article\n" +
                    "(3) change my password\n" +
                    "(4) admin sections\n" +
                    "(5) exit");
            selectedNumber = ScannerClass.getNumber(1, 5);

            if (selectedNumber == 1) {
                ArticleRegistrationClass.show(userId);
            } else if (selectedNumber == 2) {
                ArticleEditingClass.show(userId);
            } else if (selectedNumber == 3) {
                System.out.println("input new Password: ");
                String newPassword = ScannerClass.getString();
                userService.editPassword(userId, newPassword);
            } else if (selectedNumber == 4) {
                User user = userService.selectUserById(userId);
                if (user.getRole().getTitle().equalsIgnoreCase("admin")) {
                    AdminsMenu.show();
                } else System.out.println("You do not have access to this section");
            } else {
                break;
            }
        }
    }
}
