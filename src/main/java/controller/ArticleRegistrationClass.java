package controller;

import scanner.ScannerClass;
import services.ArticleService;
import services.CategoryService;

public class ArticleRegistrationClass {
    public static void show(long userId) {
        CategoryService categoryService = new CategoryService();
        int numberCategory = categoryService.selectCategories();
        if (numberCategory > 0) {
            System.out.println("input Category id: ");
            long categoryId = ScannerClass.getNumber();

            System.out.println("input title: ");
            String title = ScannerClass.getString();

            System.out.println("input brief: ");
            String brief = ScannerClass.getString();

            System.out.println("input content: ");
            String content = ScannerClass.getString();

            ArticleService articleService = new ArticleService();
            articleService.insertArticle(title, brief, content, categoryId, userId);
        }

    }
}
