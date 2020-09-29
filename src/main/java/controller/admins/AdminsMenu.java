package controller.admins;

import scanner.ScannerClass;
import services.ArticleService;
import services.CategoryService;
import services.TagService;
import services.UserService;

public class AdminsMenu {
    public static void show() {
        ArticleService articleService = new ArticleService();
        int selectedNumber;
        while (true) {
            System.out.println("(1) change isPublished article\n" +
                    "(2) delete article\n" +
                    "(3) create new category\n" +
                    "(4) create new tag\n" +
                    "(5) change user role\n" +
                    "(6) exit");
            selectedNumber = ScannerClass.getNumber(1, 6);

            if (selectedNumber == 1) {

                articleService.selectPublishedAndUnpublishedArticle();

                System.out.println("input articleId: ");
                long articleId = ScannerClass.getNumber();

                articleService.changePublishedArticle(articleId);
            } else if (selectedNumber == 2) {
                articleService.selectPublishedAndUnpublishedArticle();

                System.out.println("input articleId: ");
                long articleId = ScannerClass.getNumber();

                articleService.deleteArticleById(articleId);
            } else if (selectedNumber == 3) {
                CategoryService categoryService = new CategoryService();
                categoryService.selectCategories();
                System.out.println("title: ");
                String title = ScannerClass.getString();
                System.out.println("description: ");
                String description = ScannerClass.getString();
                categoryService.insertCategory(title, description);
            } else if (selectedNumber == 4) {
                articleService.selectPublishedAndUnpublishedArticle();
                System.out.println("input articleId: ");
                long articleId = ScannerClass.getNumber();
                System.out.println("tag: ");
                String tag = ScannerClass.getString();


                TagService tagService = new TagService();
                tagService.tagOnArticle(articleId, tag);
            } else if (selectedNumber == 5) {
                UserService userService = new UserService();
                userService.selectAllUsers();
                System.out.println("input userId: ");
                long userId = ScannerClass.getNumber();
                System.out.println("input newRole: ");
                String newRole = ScannerClass.getString();
                userService.changeRole(userId, newRole);
            } else {
                break;
            }
        }
    }
}
