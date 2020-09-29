package controller;

import scanner.ScannerClass;
import services.ArticleService;
import services.UserService;

public class ArticleEditingClass {
    public static void show(long userId)
    {
        UserService userService = new UserService();
        userService.selectArticleByUserId(userId);

        System.out.println("input article id for edit: ");
        long articleId = ScannerClass.getNumber();

        System.out.println("input new Title: ");
        String newTitle = ScannerClass.getString();

        System.out.println("input new Brief: ");
        String newBrief= ScannerClass.getString();

        System.out.println("input new Content: ");
        String newContent = ScannerClass.getString();

        ArticleService articleService = new ArticleService();
        articleService.editArticle(userId,articleId,newTitle,newBrief,newContent);




    }
}
