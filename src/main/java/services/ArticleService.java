package services;

import domains.Article;
import repositories.ArticleRepositoryDAO;

import java.util.Date;

public class ArticleService {
    ArticleRepositoryDAO articleRepositoryDAO = ArticleRepositoryDAO.getInstance();

    public void insertArticle(String title,String brief,String content)
    {
        Article article = new Article();
        article.setTitle(title);
        article.setBrief(brief);
        article.setContent(content);
        article.setCreateDate(new Date());
        article.setPublished(false);
        articleRepositoryDAO.save(article);
    }



}
