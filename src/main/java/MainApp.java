import services.ArticleService;

public class MainApp {
    public static void main(String[] args) {
        ArticleService articleService = new ArticleService();
        articleService.insertArticle("c++","b","c");
    }
}
