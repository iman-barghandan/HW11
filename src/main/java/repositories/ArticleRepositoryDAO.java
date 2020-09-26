package repositories;

import domains.Article;

public class ArticleRepositoryDAO extends BaseRepositoryDAO<Article,Long> {
    private static ArticleRepositoryDAO articleRepositoryDAO;
    private ArticleRepositoryDAO(){}
    public static ArticleRepositoryDAO getInstance()
    {
        if (articleRepositoryDAO==null)
        {
            articleRepositoryDAO = new ArticleRepositoryDAO();
        }
        return articleRepositoryDAO;
    }

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

}
