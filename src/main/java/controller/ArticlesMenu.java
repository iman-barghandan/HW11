package controller;

import scanner.ScannerClass;
import services.ArticleService;

public class ArticlesMenu {
    public static void show() {
        ArticleService articleService = new ArticleService();
        articleService.selectArticles();
        System.out.println("input article id for reading");
        long articleId = ScannerClass.getNumber();
        articleService.selectById(articleId);
    }
}
