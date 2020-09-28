package controller;

import scanner.ScannerClass;
import services.ArticleService;

public class MainMenu {
    public static void showMenu()
    {
        int selectedNumber;
        while (true)
        {
            System.out.println("(1) Sign-In\n" +
                    "(2) Sign-Up\n" +
                    "(3) Articles\n" +
                    "(4) End program");
            selectedNumber = ScannerClass.getNumber(1,4);

            if (selectedNumber==1)
            {
                SignInMenu.show();
            }
            else if (selectedNumber==2)
            {
                SignUpMenu.showMenu();
            }
            else if (selectedNumber==3)
            {
                ArticleService articleService = new ArticleService();
                articleService.selectArticles();
            }
            else {
                break;
            }
        }
    }
}
