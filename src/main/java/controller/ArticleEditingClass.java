package controller;

import scanner.ScannerClass;
import services.UserService;

public class ArticleEditingClass {
    public static void show(long userId)
    {
        UserService userService = new UserService();
        userService.selectArticleByUserId(userId);

        System.out.println("input article id for edit: ");
        long articleId = ScannerClass.getNumber();




    }
}
