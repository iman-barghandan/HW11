package controller.admins;

import scanner.ScannerClass;
import services.UserService;

public class AdminsMenu {
    public static void show()
    {
        int selectedNumber;
        while (true)
        {
            System.out.println("(1) change isPublished article\n" +
                    "(2) delete article\n" +
                    "(3) create new category\n" +
                    "(4) create new tag\n" +
                    "(5) change user role\n" +
                    "(6) exit");
            selectedNumber = ScannerClass.getNumber(1,6);

            if (selectedNumber==1)
            {

            }
            else if (selectedNumber==2)
            {

            }
            else if (selectedNumber==3)
            {

            }
            else if (selectedNumber==4)
            {

            }
            else if (selectedNumber==5)
            {
                UserService userService = new UserService();
                userService.selectAllUsers();
                System.out.println("input userId: ");
                long userId = ScannerClass.getNumber();
                System.out.println("input newRole: ");
                String newRole = ScannerClass.getString();
                userService.changeRole(userId,newRole);
            }
            else {
                break;
            }
        }
    }
}
